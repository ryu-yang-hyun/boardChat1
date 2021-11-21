package com.board.boardchat.service.account;

import com.board.boardchat.common.StatusEnum;
import com.board.boardchat.converter.LoginConverter;
import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.entity.AccountEntity;
import com.board.boardchat.model.Role;
import com.board.boardchat.model.User;
import com.board.boardchat.repository.account.AccountRepository;
import com.board.boardchat.repository.role.RoleRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

   @Autowired
   private AccountRepository accountRepository;

   @Autowired
   private RoleRepository roleRepository;

    /**
     * 회원 가입
     */
    @Override
    public User register(AccountDto accountDto) throws ServiceException, NoSuchAlgorithmException {

        //TODO 예외처리 추가 예정
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(accountDto.getPassword().getBytes());

        User user = new User();
        user.setUserId(accountDto.getUserId());
        user.setEmail(accountDto.getEmail());
        user.setPassword(String.format("%064x", new BigInteger(1, md.digest())));
        user.setName(accountDto.getName());
        user.setGender(accountDto.getGender());

        Optional<Role> role = roleRepository.findById(accountDto.getRole());
        Role roles = new Role();

        if(!role.isPresent()) {
           Role re = roleAdd();
           roles.setId(re.id);
        } else {
            roles.setId(role.get().id);
        }
        user.getRoles().add(roles);

        return accountRepository.save(user);
    }

    public Role roleAdd () {
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

    /**
     * 로그인
     */
    @Override
    public AccountEntity login(AccountDto accountDto) throws NoSuchAlgorithmException {

        //TODO Login 시 session 정보 추가해줘야함.
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(accountDto.getPassword().getBytes());
        String password = String.format("%064x", new BigInteger(1, md.digest()));

        //계정 확인
        Long result = accountRepository.actionLogin(accountDto.getUserId(), password);
        if(result <= 0) {
            AccountEntity accountEntity = new AccountEntity();
            return accountEntity;
        }

        User userInfo = accountRepository.findUsersBy(accountDto.getUserId());
        LoginConverter loginConverter = new LoginConverter();
        AccountEntity accountEntity = loginConverter.convert(userInfo);

        return accountEntity;

    }
}
