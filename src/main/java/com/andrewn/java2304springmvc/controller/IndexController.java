package com.andrewn.java2304springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "{\"message\": \"hello\"}";
    }

    @GetMapping("/asd")
    public String returnAsd() {
        return "{\"message\": \"asd\"}";
    }
}
