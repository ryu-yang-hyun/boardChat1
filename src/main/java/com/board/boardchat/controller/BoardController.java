package com.board.boardchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/index")
    public String hello (Model model) {
        model.addAttribute("test", "test123");
        return "index";
    }

}
