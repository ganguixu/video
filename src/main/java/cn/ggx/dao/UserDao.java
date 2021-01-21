package cn.ggx.dao;

import cn.ggx.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    int addUser(User user);

    List<User> findUserAll();

    List<User> findUserByEmail(HashMap<String,String> map);

    int addUsers(List<User> list);

    int updateUsers(List<User> list);

}
