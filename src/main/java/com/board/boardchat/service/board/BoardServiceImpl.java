//package com.board.boardchat.service.board;
//
//import com.board.boardchat.dto.UserDto;
//import com.board.boardchat.repository.board.BoardRepository;
//import org.hibernate.service.spi.ServiceException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BoardServiceImpl implements BoardService {
//
//    private BoardRepository boardRepository;
//
//    @Autowired
//    public BoardServiceImpl(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }
//
//
//    @Override
//    public void memberCreate(UserDto userDto) throws ServiceException {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
//    }
//
//    @Override
//    public Page<UserDto> memberList(UserDto userDto) throws ServiceException {
//        Page<UserDto> selectMember = boardRepository.memberList(userDto);
//
//        return selectMember;
//    }
//}
