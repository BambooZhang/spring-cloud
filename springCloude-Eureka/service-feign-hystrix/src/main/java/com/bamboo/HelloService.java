package com.bamboo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来绑定并指定调用哪个服务
 * value:服务名
 * fallback:熔断回调的类名称
 * Created by babmoo on 2017/10/21.
 */
@FeignClient(value = "service-hello",fallback = HelloServiceHystric.class)
public interface HelloService {

    //使用的springmvc注解
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
