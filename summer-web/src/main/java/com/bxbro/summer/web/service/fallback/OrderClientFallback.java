package com.bxbro.summer.web.service.fallback;

import com.bxbro.summer.common.constant.SystemEnum;
import com.bxbro.summer.common.resp.BaseResponse;
import com.bxbro.summer.web.service.feign.OrderClient;
import org.springframework.stereotype.Component;

/**
 * @author dong
 * @description 服务降级实现类
 * @date 2021/9/26
 */
@Component
public class OrderClientFallback implements OrderClient {


    @Override
    public BaseResponse getOrderById(Integer id) {
        return BaseResponse.fail(SystemEnum.SERVICE_INVOCATION_ERROR.getCode(),
                SystemEnum.SERVICE_INVOCATION_ERROR.getDesc());
    }
}
