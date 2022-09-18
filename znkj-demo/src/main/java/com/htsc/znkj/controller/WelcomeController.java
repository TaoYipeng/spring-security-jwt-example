package com.htsc.znkj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class WelcomeController {

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome to javatechie !!";
    }

}
