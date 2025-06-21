package com.example.hello_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/hello")
    public String hello() {
        var html = "<html><body><h1>Hello World!</h1></body></html>";
        return "Hello World";
    }

}
