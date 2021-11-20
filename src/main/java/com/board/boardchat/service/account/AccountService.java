package com.board.boardchat.service.account;

import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.model.User;
import org.hibernate.service.spi.ServiceException;

public interface AccountService {


    public User register (AccountDto accountDto) throws ServiceException;
}
