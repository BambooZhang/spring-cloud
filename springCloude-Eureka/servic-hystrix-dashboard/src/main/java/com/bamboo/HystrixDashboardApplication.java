package com.bamboo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 服务端service-hystrix-dashboard
 * 增加断路器和断路器的监控
 *
 *  service-hystrix-dashboard Application
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix//添加断路器的注解
@EnableHystrixDashboard//添加断路器监控注解
public class HystrixDashboardApplication {


    public static void main(String... args) throws Exception {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "helloError")//明断路点和回调方法名
    public String home() {
        return "hello from port:" +port;
    }


    //异常处理的回调方法
    public String helloError() {
        return "hello Error,sorry,error!";
    }

}

