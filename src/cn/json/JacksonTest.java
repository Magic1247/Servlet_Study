package cn.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JacksonTest {
    @Test
    public void test01() throws Exception {
        Person person = new Person();
        person.setName("张三");
        person.setAge(18);
        person.setGender("男");
        person.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper(); // 创建jackson核心对象
        String json = mapper.writeValueAsString(person); // writeValueAsString 将对象转化为json字符串
        mapper.writeValue(new FileWriter("D:\\jsonTest.txt"), person);  // writeValue 将对象转化为json并嵌入输出流中，支持字符流或字节流重载
        System.out.println(json);
    }

    @Test
    public void test02() throws JsonProcessingException {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setGender("男");

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(18);
        p2.setGender("男");

        Person p3 = new Person();
        p3.setName("张三");
        p3.setAge(18);
        p3.setGender("男");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
    }

    @Test
    public void test03() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 19);
        map.put("gender", "男");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);
    }

    @Test
    public void test04() throws IOException {
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":19}";
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, new Person().getClass());
        System.out.println(person);
    }

}
