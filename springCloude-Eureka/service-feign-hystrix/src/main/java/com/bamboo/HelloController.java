package com.bamboo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xialeme on 2017/10/21.
 */
@RestController
public class HelloController {


    @Autowired
    HelloService schedualServiceHello;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHello.sayHiFromClientOne(name);
    }


}
