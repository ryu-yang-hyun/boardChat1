//package com.board.boardchat.service.user;
//
//import com.board.boardchat.model.Role;
//import com.board.boardchat.model.User;
//import com.board.boardchat.repository.user.UserRepository;
//import org.hibernate.service.spi.ServiceException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository repository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    @Override
//    public User save(User user) throws ServiceException {
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        user.setEnabled(true);
//        Role role = new Role();
//        //TODO USER 별 권한 나눌예정.. (repository 추가예정)
//        role.setId(1L);
//        user.getRoles().add(role);
//        return repository.save(user);
//    }
//
//}
