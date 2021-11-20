package com.board.boardchat.service.account;

import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.model.Role;
import com.board.boardchat.model.User;
import com.board.boardchat.repository.account.AccountRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

   @Autowired
   private AccountRepository accountRepository;

    @Override
    public User register(AccountDto accountDto) throws ServiceException {

        User user = new User();
        user.setUserId(accountDto.getUserId());
        user.setPassword(accountDto.getPassword());
        user.setName(accountDto.getName());
        user.setGender(accountDto.getGender());
        Role role = new Role();
//        //TODO USER 별 권한 나눌예정.. (repository 추가예정)
        role.setId(1L);
        user.getRoles().add(role);
        return accountRepository.save(user);
    }
}
