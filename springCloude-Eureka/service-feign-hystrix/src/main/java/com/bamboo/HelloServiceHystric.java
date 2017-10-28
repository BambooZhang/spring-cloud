package com.bamboo;

import org.springframework.stereotype.Component;

/**
 *
 * 熔断的实现类
 *SchedualServiceHello 接口，并注入到Ioc容器中
 * Created by bamboo on 2017/10/21.
 */
@Component
public class HelloServiceHystric implements HelloService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }


}