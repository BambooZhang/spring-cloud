package com.bamboo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 *1.方法级别的熔断
 *2.类级别的熔断
 *
 * 这里使用的是方法级别的熔断
 * Created by xialeme on 2017/10/20.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    /*********
     * 改造HelloService类，在hiService方法上加上@HystrixCommand注解
     * 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法helloError，熔断方法直接返回了一个字符串
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name) {
       // return restTemplate.getForObject("http://SERVICE-HELLO/hello?name="+name,String.class);
        return restTemplate.getForObject("http://SERVICE-HELLO/hello",String.class);
    }



    //熔断回调方法
    public String helloError(String name) {

        return "hello,sorry,error!";
    }

}
