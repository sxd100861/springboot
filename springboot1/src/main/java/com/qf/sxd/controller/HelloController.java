package com.qf.sxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println(dataSource);
        return "Hello world!";
    }
}
