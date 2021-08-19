package cn.provinceMVCDemo.service.impl;

import cn.provinceMVCDemo.dao.impl.ProvinceDAOimpl;
import cn.provinceMVCDemo.domain.Province;
import cn.provinceMVCDemo.service.ProvinceService;
import cn.utils.JedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceimpl implements ProvinceService {
    private ProvinceDAOimpl dao = new ProvinceDAOimpl();

    @Override
    public List<Province> findAll() {
        dao = new ProvinceDAOimpl();
        return dao.findAll();
    }

    @Override
    public String findAllRedis() {
        Jedis jedis = JedisUtils.getJedisPool().getResource(); // 获取redis连接池
        String json = jedis.get("province");    // 尝试从redis获取province
        if (json == null || json.length() == 0) { // 如果json字符串为空或长度为0查询DB
            List<Province> list = dao.findAll(); // 调用ProvinceDAOimpl查询数据库
            ObjectMapper mapper = new ObjectMapper(); // 创建ObjectMapper对象
            try {
                json = mapper.writeValueAsString(list); // 将DB返回的Province集合序列化为json
                jedis.set("province", json); // 将返回的json结果set进redis
                return json;  // 返回json
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;  // 如果发生异常返回null
            } finally {
                jedis.close();
            }
        } else {
            System.out.println("redis");
            return json; // 如果redis中存在province则直接返回
        }
    }
}
