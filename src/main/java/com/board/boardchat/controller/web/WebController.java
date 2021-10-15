package com.board.boardchat.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    /**main 페이지**/
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    /**로그인 페이지**/
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**로그아웃 페이지**/
    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

    /**회원가입 페이지**/
   @RequestMapping("/membership")
   public String memberShip() {
       return "membership";
   }

   /**나의 할일(메인게시판)**/
   @RequestMapping("/myboard")
    public String myBoard() {
       return "myboard";
   }

   /**자유게시판**/
   @RequestMapping
   public String board() {
       return "board";
   }

   /**채팅**/
   @RequestMapping("/chat")
   public String chat() {
       return "chat";
   }

   /**공지사항**/
   @RequestMapping("/notice")
    public String notice() {
       return "notice";
   }
}
