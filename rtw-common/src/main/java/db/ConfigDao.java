package db;

import db.vo.JobConfigVo;
import org.apache.ibatis.session.SqlSession;
import request.Request;

/**
 * @ClassName: ConfigDao
 * @Author: yzh
 * @Description:
 * @Date: 2021/11/28 10:41
 * @Version: 1.0
 */

public class ConfigDao {

    private static ConfigDao dao;

    private ConfigDao() {
    }

    public static ConfigDao getInstance() {
        if (dao == null) {
            synchronized (ConfigDao.class) {
                if (dao == null) {
                    dao = new ConfigDao();
                }
            }
        }
        return dao;
    }
    public JobConfigVo findJobConfigByJobName(String jobName) {
        JobConfigVo jobConfigVo;
        try (SqlSession sqlSession = SessionFactory.getInstance().getSqlSession()) {//try-with-resource语法 会自动调用sqlsession.close方法将会话关闭
            jobConfigVo = sqlSession.selectOne("findJobConfigByJobName", jobName);
        }
        return jobConfigVo;
    }

    public void  insertWarningJob(Request request){
        SqlSession sqlSession = SessionFactory.getInstance().getSqlSession();
        try  {
            sqlSession.insert("insertWarningJob",request);
            sqlSession.commit();//插入，更新等操作  需要commit
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();//插入，更新等操作  如果有异常应该要回滚
        }finally {
            sqlSession.close();
        }
     }


}
