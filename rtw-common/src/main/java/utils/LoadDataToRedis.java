package utils;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

/**
 * @ClassName: LoadDataToRedis
 * @Author: yzh
 * @Description:
 * @Date: 2022/4/19 21:07
 * @Version: 1.0
 */
public class LoadDataToRedis {
    public static void main(String[] args) {
        HostAndPort hostAndPort = new HostAndPort("192.168.52.100", 6379);
        Jedis jedis = new Jedis(hostAndPort);
        Long hset = jedis.hset("K999", "name", "yzh");
        System.out.println(hset);

    }
}
