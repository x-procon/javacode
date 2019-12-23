package hazer.test.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @ClassName: TestAPI
 * @Author: Hazer
 * @Description: 测试常用API
 * @Date: 2019/12/20 17:13
 * @Version: 1.0
 */
public class TestStringAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("122.51.94.168", 6380);
        jedis.select(1);
        jedis.set("sex", "女");
        jedis.set("age", "23");
        jedis.set("name", "做爱", "NX", "EX", 10);
        Set<String> keySet = jedis.keys("*");
        for (String key : keySet) {
            System.out.println("当前key的过期时间：" + jedis.ttl(key));
            System.out.println(key);
        }
    }
}
