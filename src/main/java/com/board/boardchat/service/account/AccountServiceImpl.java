package com.board.boardchat.service.account;

import com.board.boardchat.converter.LoginConverter;
import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.entity.AccountEntity;
import com.board.boardchat.model.Role;
import com.board.boardchat.model.User;
import com.board.boardchat.repository.account.AccountRepository;
import com.board.boardchat.repository.role.RoleRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public AccountEntity login(AccountDto accountDto, HttpServletRequest request) throws ServiceException, NoSuchAlgorithmException {


        HttpSession session = request.getSession(true);
        if (session.getAttribute("USER") != null) {
            AccountEntity accountEntity = (AccountEntity) session.getAttribute("USER");
            return accountEntity;
        }

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
        session.setAttribute("USER", accountEntity);

        return accountEntity;
    }

    /**
     * 로그아웃
     */
    @Override
    public String logout(HttpServletRequest request) throws ServiceException {

        String message = null;
        HttpSession session = request.getSession();
        if (session.getAttribute("USER") != null) {
            session.removeAttribute("USER");
            message = "로그아웃 되었습니다.";
        }

        return message;
    }
}
