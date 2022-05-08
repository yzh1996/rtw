package db;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

import static constans.GlobalConstans.DBConstans.MYBATIS_CONFIG;

/**
 * @ClassName: SessionFactory
 * @Author: yzh
 * @Description:
 * @Date: 2021/11/28 11:24
 * @Version: 1.0
 */
public class SessionFactory {
    private static final Logger LOG = LoggerFactory.getLogger(SessionFactory.class);   //为什么要加static 和final
    private static SessionFactory sessionFactory;
    private SqlSessionFactory sqlSessionFactory;

    public SessionFactory() {
        try {
            System.out.println("mybatis 初始化 start ！！");
            LOG.info("mybatis 初始化 start ！！");
            InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            LOG.info("mybatis 初始化 end +！！");
        } catch (IOException e) {
            throw new RuntimeException("mybatis 初始化异常！！", e);
        }
    }

    public static SessionFactory getInstance() {
        if (sessionFactory == null) {
            synchronized (SessionFactory.class) {
                if (sessionFactory == null) {
                    sessionFactory = new SessionFactory();
                }
            }
        }
        return sessionFactory;
    }

    public SqlSession getSqlSession() {
        return sessionFactory.sqlSessionFactory.openSession();
    }

    public synchronized static  void close(){//同步方法？
        if (sessionFactory == null || sessionFactory.sqlSessionFactory == null ){
            return;
        }
        DataSource dataSource = null;
        try {
            dataSource = sessionFactory.sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
            if (dataSource !=null && dataSource instanceof DruidDataSource){
                ((DruidDataSource) dataSource).close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        sessionFactory.sqlSessionFactory = null;
        sessionFactory =null;
        LOG.info("close dataSource finish");

    }
}
