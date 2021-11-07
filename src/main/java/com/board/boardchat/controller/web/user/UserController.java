//package com.board.boardchat.controller.web.user;
//
//import com.board.boardchat.model.User;
//import com.board.boardchat.service.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/account")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/signup")
//    public String accountSignup() {
//        return "signup";
//    }
//
//    @PostMapping("/signup")
//    public String accountSp(@RequestBody User user) {
//        userService.save(user);
//        return "redirect:/";
//    }
//
//}
