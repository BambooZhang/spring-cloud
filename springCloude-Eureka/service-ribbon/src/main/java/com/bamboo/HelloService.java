package com.bamboo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xialeme on 2017/10/20.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    public HelloService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public String helloService(String name) {
         return restTemplate.getForObject("http://SERVICE-HELLO/hello?name=ribbon_"+name,String.class);
        //return restTemplate.getForObject("http://SERVICE-HELLO/hello",String.class);
    }

}
