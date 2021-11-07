//package com.board.boardchat.service;
//
//import com.board.boardchat.dto.UserDto;
//import com.board.boardchat.model.User;
//import com.board.boardchat.repository.SecurityRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class SecurityService implements UserDetailsService {
//
//    private SecurityRepository repository;
//
//    public SecurityService(SecurityRepository repository) {
//        this.repository = repository;
//    }
//
//    @Transactional
//    public void joinUser(User user){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        repository.save(user);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
//        User user = repository.findUserBy(username);
//        return new UserDto(user);
//    }
//}
