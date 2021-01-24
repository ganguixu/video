package cn.ggx.test;

import cn.ggx.dao.UserDao;
import cn.ggx.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class UserDaoTest {

    @Autowired
    UserDao userDao;

//    @Test
//    public void test1() {
//
//        User user = new User();
//        user.setCreateTime(new Date());
//        user.setMobile("13262900562");
//        user.setEmail("ganguixu@fescoadecco.com");
//        user.setPassword("123");
//        user.setVipFlag(0);
//
//        int code = userDao.addUser(user);
//        System.out.println(code);
//
//    }
//
//    @Test
//    public void test2() {
//
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("password", "123");
//
//        List<User> user = userDao.findUserAll();
//        System.out.println(user);
//    }

//    @Test
//    public void test3(){
//        HashMap<String,String> map = new HashMap<String, String>();
//        map.put("email","ganguixu@fescoadecco.com");
//        List<User> userByEmail = userDao.findUserByEmail(map);
//        System.out.println(userByEmail);
//    }

    @Test
    public void test4(){
        List<User> list = new ArrayList<User>();
        User user1 = new User("zhouxiaolong@fescoadecco.com","1234","13278121254",0,new Date());
        User user2 = new User("yinyangyang@fescoadecco.com","4567","15878121254",0,new Date());
        list.add(user1);
        list.add(user2);
        int i = userDao.addUsers(list);
        System.out.println(i);
    }

//    @Test
//    public void test5(){
//        List<User> list = new ArrayList<User>();
//        User user = new User(1,"zhuyuanji@fescoadecco.com","999",null,null,null);
//        list.add(user);
//        int i = userDao.updateUsers(list);
//        System.out.println(i);
//    }


//    @Test
//    public void test3() {
//
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("password", "321456");
//        map.put("id", "1");
//
//        int code = userDao.updateUser(map);
//        System.out.println(code);
//    }



}
