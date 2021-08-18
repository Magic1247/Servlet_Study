package cn.servlet.request.login.test;

import cn.servlet.request.login.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {


    @Test
    public void test01() {
        User user = new User();
        try {
            BeanUtils.setProperty(user, "userName", "zhangsan");
            System.out.println(BeanUtils.getProperty(user, "userName"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
