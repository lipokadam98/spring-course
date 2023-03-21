package com.lipokadam.Springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example/api")
public class ExampleController {
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
}
