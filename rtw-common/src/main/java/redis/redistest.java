package redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: redistest
 * @Author: yzh
 * @Description:
 * @Date: 2021/11/29 19:29
 * @Version: 1.0
 */
public class redistest {

    public static  String redisStr = "192.168.52.100:7001 192.168.52.100:7002 192.168.52.100:7003 192.168.52.100:7004 192.168.52.100:7005 192.168.52.100:7006";
    public static void main(String[] args) {
        Set<HostAndPort> set = new HashSet<HostAndPort>();
        String[] s = redisStr.split(" ");
        for (String s1 : s) {
            String[] split = s1.split(":");
            set.add(new HostAndPort(split[0],Integer.parseInt(split[1])));
        }

        JedisCluster jedisCluster = new JedisCluster(set);
        for (int i = 0;i<3;i++){
            Long hset = jedisCluster.hset("K999", "yzh", Integer.toString(i));
        }

    }
}
