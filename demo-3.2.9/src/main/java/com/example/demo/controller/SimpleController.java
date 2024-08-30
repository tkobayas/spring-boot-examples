package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    public SimpleController() {
    }

    @GetMapping("/hello")
    public String hello() {
        logger.info("hello!");
        return "hello!";
    }
}
