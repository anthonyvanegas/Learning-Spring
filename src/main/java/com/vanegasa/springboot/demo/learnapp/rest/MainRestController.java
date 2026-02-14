package com.vanegasa.springboot.demo.learnapp.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MainRestController {
    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHelloWorld() {
        return "Hello World";
    }

    // expose a new endpoint
    @GetMapping("/workout")
    public String getMethodName() {
        return "Run a hard 5K!";
    }
    


}
