package com.bamboo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *ribbon的基础上实现断路器和断路器监控
 * 客户端
 *
 *   service-hystrix Application
 */
@SpringBootApplication
@EnableDiscoveryClient//向服务中心注册
@EnableHystrix//加@EnableHystrix注解开启Hystrix
@EnableHystrixDashboard//开启hystrixDashboard监控信息仪表盘（必加1）
@EnableCircuitBreaker//（必加2）
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    @Bean
    @LoadBalanced//开启负载均衡的功能
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
