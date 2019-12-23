package hazer.test.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName: javacode
 * @Package: hazer.test.redis
 * @ClassName: TestListAPI
 * @Author: Hazer
 * @Description: Redis List
 * @Date: 2019/12/21 11:37
 * @Version: 1.0
 */
public class TestListAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("122.51.94.168", 6380);
        jedis.select(2);
        List<Integer> lList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lList.add(i);
        }

        if (lList != null && lList.size() > 0) {
            for (int j : lList) {
                jedis.lpush("jedisList", String.valueOf(j));


            }
            List<String> strings = jedis.lrange("jedisList", 0, -1);
            for (String string : strings) {
                System.out.println("jedisList的值是：" + string);
            }
            System.out.println("jedisList的大小是：" + jedis.llen("jedisList"));
            jedis.lpop("jedisList");
            List<String> string3 = jedis.lrange("jedisList", 0, -1);
            for (String string : string3) {
                System.out.println("jedisList的值是：" + string);
            }
        }
    }

}
