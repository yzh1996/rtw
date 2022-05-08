package com.yzh.httpserver.controller;

import com.yzh.httpserver.service.WarningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import request.Request;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * @ClassName: WarningController
 * @Author: yzh
 * @Description:
 * @Date: 2021/12/4 15:33
 * @Version: 1.0
 */
@RestController
@Api("布撤控接口")
@RequestMapping("/httpserver")
 public class WarningController {
    @Resource
    private WarningService warningService;
     @RequestMapping("/BK")
    public String BK(@RequestBody Request request){
         warningService.BK(request);
        return "ok";
    }
}
