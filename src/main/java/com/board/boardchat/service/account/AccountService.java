package com.board.boardchat.service.account;

import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.entity.AccountEntity;
import com.board.boardchat.model.User;
import org.hibernate.service.spi.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

public interface AccountService {

    /**
     * 회원 가입
     */
    public User register (AccountDto accountDto) throws ServiceException, NoSuchAlgorithmException;

    /**
     * 로그인
     */
    public AccountEntity login (AccountDto accountDto, HttpServletRequest request) throws ServiceException, NoSuchAlgorithmException;

    /**
     * 로그아웃
     */
    public String logout (HttpServletRequest request) throws ServiceException;
}
