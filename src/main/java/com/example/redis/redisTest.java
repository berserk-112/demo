package com.example.redis;

import com.alibaba.fastjson.JSON;
import com.example.test.People;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

public class redisTest {
    public static void main(String[] args) {
        People people = new People("sun", 25);
        String s = JSON.toJSONString(people);
        System.out.println(s);
        People people1 = JSON.parseObject(s, people.getClass());
        System.out.println(people1.toString());

        JedisPool pool = new JedisPool("localhost", 6379);
        try (Jedis jedis = pool.getResource()) {
            jedis.set("peopleJson", s);
            String str = jedis.get("peopleJson");
            System.out.println(str);
            jedis.hset("people", "name", people.getName());
            jedis.hset("people", "age",  String.valueOf(people.getAge()));
            Map<String, String> peopleHash = jedis.hgetAll("people");
            for (Map.Entry<String, String> entry : peopleHash.entrySet()) {
                String sss = entry.getKey() + entry.getValue();
                System.out.println(sss);
            }
        }
    }
}
