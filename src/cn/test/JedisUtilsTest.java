package cn.test;

import cn.utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtilsTest {
    /**
     * 获取jedis连接对象方法测试
     */
    @Test
    public void test() {
        Jedis jedis = JedisUtils.getJedis();
        jedis.set("test2139", "2139");
        System.out.println(jedis.get("test2139"));
        jedis.close();
    }

    /**
     * 获取JedisPool方法测试
     */
    @Test
    public void test01() {
        JedisPool jedisPool = JedisUtils.getJedisPool();
        Jedis jedis = jedisPool.getResource();
        jedis.set("test2139", "4464");
        System.out.println(jedis.get("test2139"));
        jedis.close();
    }
}
