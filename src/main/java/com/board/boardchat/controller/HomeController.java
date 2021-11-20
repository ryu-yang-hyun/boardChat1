package com.board.boardchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/vue")
    public String vue(){

        return "vue/index";
    }
}
