package com.bxbro.summer.gateway.controller;

import com.bxbro.summer.common.constant.SystemEnum;
import com.bxbro.summer.common.resp.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dong
 * @description 服务降级 controller
 * @date 2021/10/1
 */
@RestController
public class FallbackController {

    @GetMapping("/defaultFallback")
    public BaseResponse defaultFallback() {
        return BaseResponse.fail(
                SystemEnum.SERVICE_UNAVAILABLE.getCode(), SystemEnum.SERVICE_UNAVAILABLE.getDesc());
    }
}
