package com.board.boardchat.service.account;

import com.board.boardchat.dto.AccountDto;
import com.board.boardchat.model.Role;
import com.board.boardchat.model.User;
import com.board.boardchat.repository.account.AccountRepository;
import com.board.boardchat.repository.role.RoleRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public User register(AccountDto accountDto) throws ServiceException, NoSuchAlgorithmException {

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
}
