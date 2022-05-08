package com.yzh.httpserver.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import request.Request;

/**
 * @ClassName: warningService
 * @Author: yzh
 * @Description:
 * @Date: 2021/12/4 16:27
 * @Version: 1.0
 */
@Service
public interface WarningService {
//    public String activeWarning(RequestParam())
    public void BK(Request request);
}
