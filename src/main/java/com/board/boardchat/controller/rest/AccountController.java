package com.board.boardchat.controller.rest;


import com.board.boardchat.common.Constant;
import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.model.User;
import com.board.boardchat.service.account.AccountService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(Constant.API_URL + "/account")
public class AccountController {

    private final AccountService accountService;

    @Inject
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


//    /**
//     * 로그인
//     */
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody AccountDto accountDto) {
//
//        User result = accountService.login(accountDto);
//        ResponseEntity responseEntity = new ResponseEntity();
//        responseEntity.setCode("200");
//        if(result == null) {
//            responseEntity.setCode("999");
//        }
//        responseEntity.setData(result);
//
//        return responseEntity;
//    }

    /**
     * 회원가입
     */
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AccountDto accountDto) {

        User result = accountService.register(accountDto);
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode("200");
        if(result == null) {
           responseEntity.setCode("999");
        }
        responseEntity.setData(result);

        return responseEntity;
    }


}
