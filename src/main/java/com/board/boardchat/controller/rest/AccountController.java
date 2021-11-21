package com.board.boardchat.controller.rest;


import com.board.boardchat.common.Constant;
import com.board.boardchat.common.StatusEnum;
import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.entity.AccountEntity;
import com.board.boardchat.model.User;
import com.board.boardchat.service.account.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(Constant.API_URL + "/account")
public class AccountController {

    private final AccountService accountService;

    @Inject
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 회원가입
     */
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AccountDto accountDto) throws NoSuchAlgorithmException {

        User result = accountService.register(accountDto);
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(StatusEnum.OK.toString());
        if(result == null) {
           responseEntity.setCode(StatusEnum.INTERNAL_SERER_ERROR.toString());
        }
        responseEntity.setData(result);

        return responseEntity;
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AccountDto accountDto, HttpServletRequest request) throws NoSuchAlgorithmException {

        AccountEntity result = accountService.login(accountDto, request);
        ResponseEntity responseEntity = new ResponseEntity();
        if (result.getUserId() == null || result.getUserId().equals(""))  {
            responseEntity.setMessage("로그인 정보가 부적절 합니다.");
        }

        responseEntity.setCode(StatusEnum.OK.toString());

        if(result == null) {
           responseEntity.setCode(StatusEnum.INTERNAL_SERER_ERROR.toString());
        }
        responseEntity.setData(result);

        return responseEntity;
    }

    /**
     * 로그아웃
     */
    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody AccountDto accountDto, HttpServletRequest request) throws NoSuchAlgorithmException {

        String result = accountService.logout(accountDto, request);
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(StatusEnum.OK.toString());
        if(result == null) {
            responseEntity.setCode(StatusEnum.INTERNAL_SERER_ERROR.toString());
        }
        responseEntity.setMessage(result);

        return responseEntity;
    }
}
