package com.duong.newrelic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String sayHello(@RequestParam(required = false) String name) {
        return "Hello, " + name.toUpperCase() + "!";
    }

}
