package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: JedisFactory
 * @Author: yzh
 * @Description:
 * @Date: 2021/11/30 19:40
 * @Version: 1.0
 */
public class JedisFactory {
    public  static Logger LOG = LoggerFactory.getLogger(JedisFactory.class);
    public static JedisFactory jedisFactory;

    public JedisFactory getInstance(){
        if (jedisFactory == null){
            synchronized (JedisFactory.class){
//                if (jedisFactory == null)
            }
        }
        return null;
    }

}
