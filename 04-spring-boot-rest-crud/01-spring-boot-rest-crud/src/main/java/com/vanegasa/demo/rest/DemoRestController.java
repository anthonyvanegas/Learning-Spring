package com.vanegasa.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    // Add code for the "hello world" endpoint here
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
