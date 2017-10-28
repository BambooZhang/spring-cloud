package com.bamboo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *
 * FeignHystrixApplication
 *
 *  Application
 */
@SpringBootApplication
@EnableDiscoveryClient//向服务中心注册
@EnableFeignClients//@EnableFeignClients注解开启Feign功能
@EnableHystrixDashboard//开启hystrixDashboard监控信息仪表盘
//@EnableHystrix//加@EnableHystrix注解开启Hystrix
@EnableCircuitBreaker
public class FeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixApplication.class, args);
    }


}
