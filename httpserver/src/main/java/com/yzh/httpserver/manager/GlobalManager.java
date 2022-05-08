package com.yzh.httpserver.manager;

import db.ConfigDao;
import org.springframework.stereotype.Service;

/**
 * @ClassName: GlobalManager
 * @Author: yzh
 * @Description:
 * @Date: 2021/12/5 12:15
 * @Version: 1.0
 */
@Service
public class GlobalManager {
    private ConfigDao configDao;

    public GlobalManager() {
        this.configDao = ConfigDao.getInstance() ;
    }

    public ConfigDao getConfigDao() {
        return configDao;
    }

    public void setConfigDao(ConfigDao configDao) {
        this.configDao = configDao;
    }
}
