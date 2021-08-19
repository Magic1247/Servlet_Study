package cn.provinceMVCDemo.dao.impl;

import cn.provinceMVCDemo.dao.ProvinceDAO;
import cn.provinceMVCDemo.domain.Province;
import cn.servlet.request.login.utills.JDBCUtill;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDAOimpl implements ProvinceDAO {
    @Override
    public List<Province> findAll() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtill.getDataSource());
        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
