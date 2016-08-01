package demo.service;

import demo.dao.UserMapper;
import demo.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/7/26.
 */
@Service
public class UserService {
    private Logger logger=Logger.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(int id){
        User user = userMapper.findUserInfo(id);
        return user;
    }

    public User[] getAllUser(){
        return userMapper.getAllUser();
    }

    public int insert(User user){
       return userMapper.insert(user);
    }

    @Cacheable(value = "usercache", keyGenerator = "wiselyKeyGenerator")
    public User getCache(String username){
        logger.info("无缓存的时候调用这里---数据库查询");
        User db_user=userMapper.findByName(username);
       /* if(db_user!=null){
            System.out.println("---------new User method");
            return db_user;
        }*/
        if(db_user==null){
            logger.info("数据库中无此记录");
            return new User(-1,username,"nopass");
        }
        return db_user;
    }

}
