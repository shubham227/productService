package com.scaler.demoproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World Shubham Garg";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getSpecificUser(@PathVariable("id") String id){
        return "I am going to update " + id ;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String getUser(@PathVariable("id") String id){
        return "I am going to update " + id ;
    }
}
