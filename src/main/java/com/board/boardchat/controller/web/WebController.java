//package com.board.boardchat.controller.web;
//
//import com.board.boardchat.service.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class WebController {
//
//    @Autowired
//    private UserService userService;
////
////    /**main 페이지**/
////    @RequestMapping("/")
////    public String index() {
////        return "login";
////    }
//
//    /**
//     * 로그인
//     * @return
//     */
////    @RequestMapping("/login")
////    public String login() {
////        return "login";
////    }
//
////    @RequestMapping("/account/signup")
////    public String accountSignup() {
////        return "signup";
////    }
////
////    @RequestMapping("/account/signup" )
////    public String accountSignup() {
////        return "signup";
////    }
//
//    /**
//     * 로그아웃
//     * @return
//     */
////    @RequestMapping("/logout")
////    public String logout() {
////        return "logout";
////    }
//
//    /**
//     * 유저 페이지
//     * @param model
//     * @param authentication
//     * @return
//     */
////    @GetMapping("/")
////    public String userAccess(Model model, Authentication authentication) {
////        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
////        UserDto userDetail = (UserDto)authentication.getPrincipal();  //userDetail 객체를 가져옴
////        model.addAttribute("info", userDetail.getUsername());      //유저 이메일
////        return "user_access";
////    }
////
////   /**나의 할일(메인게시판)**/
////   @RequestMapping("/myboard")
////    public String myBoard() {
////       return "myboard";
////   }
////
////   /**자유게시판**/
////   @RequestMapping
////   public String board() {
////       return "board";
////   }
////
////   /**채팅**/
////   @RequestMapping("/chat")
////   public String chat() {
////       return "chat";
////   }
////
////   /**공지사항**/
////   @RequestMapping("/notice")
////    public String notice() {
////       return "notice";
////   }
//}
