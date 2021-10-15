package com.board.boardchat.service;

import com.board.boardchat.dto.MemberDto;
import com.board.boardchat.model.Member;
import com.board.boardchat.repository.BoardRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    @Override
    public void memberCreate(MemberDto memberDto) throws ServiceException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

    }

    @Override
    public Page<MemberDto> memberList(MemberDto memberDto) throws ServiceException {
        Page<MemberDto> selectMember = boardRepository.memberList(memberDto);

        return selectMember;
    }
}
