package demo.service;

import demo.dao.UserMapper;
import demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/7/26.
 */
@Service
public class UserService {
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
}
