package com.s0rInb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.s0rInb.entity.User;
import com.s0rInb.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("api/user/")
public class UserController extends BaseController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public User registerNewUser(@RequestBody @Valid User user) throws Exception {
        return userService.registerNewUser(user);
    }

    @RequestMapping("login")
    public Principal user(Principal user) {
        return user;
    }

}

