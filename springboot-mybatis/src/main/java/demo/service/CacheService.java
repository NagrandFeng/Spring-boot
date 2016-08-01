package demo.service;

import demo.dao.UserMapper;
import demo.entity.User;
import demo.utils.RedisUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/29.
 */
@Service
public class CacheService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtils redisUtils;

    private Logger logger=Logger.getLogger(CacheService.class);
    @Cacheable(value = "cachetest", keyGenerator = "wiselyKeyGenerator")
    public String setCache(String username) {
        System.out.println("调用数据库查询");
        User user=userMapper.findByName(username);
        redisUtils.set("password",user.getPassword());
        logger.info("存入缓存:"+"key:password "+",value:"+user.getPassword());
        String result=(String)redisUtils.get("password");
        logger.info("获取缓存:"+"key:password "+",value:"+result);
        return user.getUsername();
    }

    @Cacheable(value = "allUser", keyGenerator = "wiselyKeyGenerator")
    public String getAllUser(){
        User[] users=userMapper.getAllUser();
        String names="";
        for (User user:users) {
            names+=user.getId()+",";
        }
        return names;
    }


}
