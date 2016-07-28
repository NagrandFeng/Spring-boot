package demo.controller;

import demo.entity.User;
import demo.service.UserService;
import demo.utils.SpringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/26.
 */
@RestController
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/userinfo")
    public User getUserInfo(@RequestParam(name = "id") int id) {
        User user = userService.getUserInfo(id);
        logger.info(user.toString());
        return user;
    }


    @ResponseBody
    @RequestMapping("/alluser")
    public User[] getAllUser() {
        User[] users = userService.getAllUser();
        for (int i = 0; i < users.length; i++) {
            logger.info(users[i].toString());
        }
        return users;
    }

    @RequestMapping("/errorLog")
    public String writeError() {
        String now = new Date().toLocaleString();
        logger.error("error log:" + now);
        return now;
    }

    @RequestMapping("/addUser")
    public void addUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.insert(user);
        logger.info("add User:" + user.toString());
    }

    @RequestMapping("/getBean/{beanName}")
    public String getBean(@PathVariable("beanName") String beanName) {
        ApplicationContext applicationContext= SpringUtil.getApplicationContext();
        logger.info("applicationContextName:"+applicationContext.getApplicationName());
        String o = SpringUtil.getBean(beanName).toString();
        logger.info("getBean:" + o);
        return o;
    }

}
