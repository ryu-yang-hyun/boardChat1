package com.board.boardchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestController {

    @GetMapping("/test")
    public String hello(){
        return "Hello Spring Boot";
    }
}