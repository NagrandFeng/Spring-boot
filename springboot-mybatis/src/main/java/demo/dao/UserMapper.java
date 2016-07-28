package demo.dao;

import demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/7/26.
 */

public interface UserMapper {
    public User findUserInfo(int id);

    public User[] getAllUser();

    public int insert(User user);
}
