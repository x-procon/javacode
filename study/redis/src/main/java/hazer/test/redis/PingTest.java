package hazer.test.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: PingTest
 * @Author: Hazer
 * @Description: 测试redis连接
 * @Date: 2019/12/20 17:01
 * @Version: 1.0
 */
public class PingTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("122.51.94.168", 6380);
        System.out.println(jedis.ping());
    }
}
