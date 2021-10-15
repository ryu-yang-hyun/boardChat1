package com.board.boardchat.service;

import com.board.boardchat.dto.MemberDto;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;

public interface BoardService{

    void memberCreate(MemberDto memberDto) throws ServiceException;
    Page<MemberDto> memberList(MemberDto memberDto) throws ServiceException;

}
