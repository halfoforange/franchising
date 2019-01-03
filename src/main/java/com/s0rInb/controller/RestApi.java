package com.s0rInb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
    @RequestMapping("api/customer")
    public String patient() {
        return "body:Hello customer springboot";
    }

    @RequestMapping("api/admin")
    public String moderator() {
        return "body: Hello admin springboot";
    }
}
