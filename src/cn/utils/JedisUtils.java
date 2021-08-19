package cn.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class JedisUtils {
    private static final JedisPool jedisPool;

    static {
        InputStream is = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(parseInt(pro.getProperty("MaxTotal")));
        config.setMaxIdle(parseInt(pro.getProperty("MaxIdle")));
        jedisPool = new JedisPool(config, pro.getProperty("host"), parseInt(pro.getProperty("port")));
    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


}
