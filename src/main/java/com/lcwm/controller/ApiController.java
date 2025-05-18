package com.lcwm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping
    public String message() {
        return "welcome to javatechie";
    }

}
