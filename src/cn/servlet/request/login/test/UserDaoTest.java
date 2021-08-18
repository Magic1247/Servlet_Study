package cn.servlet.request.login.test;

import cn.servlet.request.login.bean.User;
import cn.servlet.request.login.dao.UserDao;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoTest {

    @Test
    public void test01() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName("zhangsan");
        user.setPassword("pw111");
        User daouser = userDao.login(user);
        System.out.println(daouser);
    }

    @Test
    public void test02() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd_HH:mm:ss");
        String formatdate = dateFormat.format(date);
        System.out.println(formatdate);
    }

    @Test
    public void test03() {
        UserDao userDao = new UserDao();
        boolean zhangsan = userDao.findUser("test02");
        System.out.println(zhangsan);
    }
}
