package com.yahikko.springboot.exceptions.springbootexceptions.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.yahikko.springboot.exceptions.springbootexceptions.models.domain.User;
import com.yahikko.springboot.exceptions.springbootexceptions.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v0")
public class AppController {

private static final String STATUS_OK = "200 ok";
private static final String ROUTE_MAPPING = "/";

@Autowired
private UserService userService;

    @GetMapping(ROUTE_MAPPING)
    public String getMethodName(@RequestParam(name = "number-id") String numberId) {

        //Integer calc = 100/0;
        Integer value = Integer.parseInt(numberId);

        return STATUS_OK + value;
    }
    
    @GetMapping("/users/{user-id}")
    public User findById(@PathVariable(name = "user-id") Long userId) {
        return userService.findById(userId);
    }
    
}
