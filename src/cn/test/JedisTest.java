package cn.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    private Jedis jedis;

    @Before
    public void getJedis() {
        this.jedis = new Jedis();
    }

    @After
    public void closeJedis() {
        this.jedis.close();
    }

    @Test
    public void test() {
        Jedis jedis = new Jedis("localhost", 6379);
        String set = jedis.set("username", "zhangsan");
        System.out.println(set);
//        Long username = jedis.del("username");
//        System.out.println(username);
        jedis.close();
    }

    /**
     * Jedis操作String类型
     */
    @Test
    public void test01() {
        this.jedis.set("user", "zhangsan"); // 设置String类型键值对
        System.out.println(this.jedis.get("user")); // 根据键获取String类型键值对
        this.jedis.setex("userTime", 20, "lisi");  // 设置自动过期的String类型键值对
    }

    /**
     * Jedis操作hash类型
     */
    @Test
    public void test02() {
        this.jedis.hset("user", "username", "zhangsan");
        this.jedis.hset("user", "gender", "male");
        String username = this.jedis.hget("user", "username");
        System.out.println(username);
        Map<String, String> user = this.jedis.hgetAll("user");
        for (String s : user.keySet()) {
            String value = user.get(s);
            System.out.println(s + ":" + value);
        }
    }

    /**
     * Jedis操作list类型（允许重复元素）
     */
    @Test
    public void test03() {
        this.jedis.lpush("userlist", "zhangsan", "lisi"); // 从左侧添加数据，value可传多个
        this.jedis.lpush("userlist", "wangwu");
        List<String> userlist = this.jedis.lrange("userlist", 0, -1);
        for (String s : userlist) {
            System.out.println(s);
        }
        String user = this.jedis.rpop("userlist");
        System.out.println(user);

    }

    /**
     * Jedis操作set类型（不允许重复元素，无法保证获取顺序）
     */
    @Test
    public void test04() {
        this.jedis.sadd("myset", "张三", "李四", "王五");
        Set<String> myset = this.jedis.smembers("myset");
        System.out.println(myset);

    }

    /**
     * Jedis操作sortedset类型（不允许重复元素，根据score从小到大排序）
     */
    @Test
    public void test05() {
        this.jedis.zadd("mysortedset", 1, "张三");
        this.jedis.zadd("mysortedset", 2, "张三");
        this.jedis.zadd("mysortedset", 0, "李四");
        this.jedis.zadd("mysortedset", -1, "王五");
        Set<String> mysortedset = this.jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);
    }

    /**
     * Jedis连接池
     */
    @Test
    public void test06() {
        JedisPool jedisPool = new JedisPool("localhost", 6379); // 创建jedis连接池
        Jedis poolJedis = jedisPool.getResource(); // 获取jedis对象
        poolJedis.set("test", "hehe");
        System.out.println(poolJedis.get("test"));
        poolJedis.close(); // 如果是从连接池获取的资源，close方法为归还资源而非释放资源
    }


    /**
     * 测试不存在的key返回
     */
    @Test
    public void test07() {
        JedisPool jedisPool = new JedisPool("localhost", 6379); // 创建jedis连接池
        Jedis poolJedis = jedisPool.getResource(); // 获取jedis对象
        String hsuidhigahs = poolJedis.get("hsuidhigahs");
        System.out.println(hsuidhigahs);
    }

}
