package com.board.boardchat.controller.rest;


import com.board.boardchat.common.Constant;
import com.board.boardchat.common.StatusEnum;
import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.entity.AccountEntity;
import com.board.boardchat.model.User;
import com.board.boardchat.service.account.AccountService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request) {

        String result = accountService.logout(request);
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(StatusEnum.OK.toString());
        if(result == null) {
            responseEntity.setCode(StatusEnum.INTERNAL_SERER_ERROR.toString());
        }
        responseEntity.setMessage(result);

        return responseEntity;
    }
}
