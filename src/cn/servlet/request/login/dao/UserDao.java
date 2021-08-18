package cn.servlet.request.login.dao;

import cn.servlet.request.login.bean.User;
import cn.servlet.request.login.utills.JDBCUtill;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtill.getDataSource());

    public User login(User loginUser) {
        String sql = "select * from user where username = ? and password = ?";
        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUserName(),
                    loginUser.getPassword()
            );
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    public int regist(User registUser) {
        String sql = "insert into user values(null,?,?)";
        try {
            template.update(sql, registUser.getUserName(), registUser.getPassword());
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public boolean findUser(String userName) {
        String sql = "Select * from user where username = ?";
        try {
            List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class), userName);
            System.out.println(query.size());
            return query.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

