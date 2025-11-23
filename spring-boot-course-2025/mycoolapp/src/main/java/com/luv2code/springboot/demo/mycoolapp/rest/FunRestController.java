package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FunRestController {
    // expose the "/" endpoint that will return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
