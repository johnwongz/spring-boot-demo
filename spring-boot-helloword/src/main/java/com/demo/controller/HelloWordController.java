package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	
    @GetMapping("/")
    public String hello() {
        return "Hello World.";
    }
 
}
