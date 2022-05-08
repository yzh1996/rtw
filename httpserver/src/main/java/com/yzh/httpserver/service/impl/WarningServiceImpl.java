package com.yzh.httpserver.service.impl;

import com.yzh.httpserver.manager.GlobalManager;
import com.yzh.httpserver.service.WarningService;
import db.ConfigDao;
import org.springframework.stereotype.Service;
import request.Request;

import javax.annotation.Resource;

/**
 * @ClassName: warningServiceImpl
 * @Author: yzh
 * @Description:
 * @Date: 2021/12/5 11:52
 * @Version: 1.0
 */
@Service
public class WarningServiceImpl implements WarningService {
    @Resource
    private GlobalManager globalManager;

    @Override
    public void BK(Request request) {
        globalManager.getConfigDao().insertWarningJob(request);
    }
}
