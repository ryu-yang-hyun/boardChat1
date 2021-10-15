package com.board.boardchat.repository;

import com.board.boardchat.dto.MemberDto;
import org.springframework.data.domain.Page;

public class BoardRepositoryImpl implements BoardRepositoryCustom {

    @Override
    public Page<MemberDto> memberList (MemberDto memberDto) {

        //TODO Pageable 작업 ..
        return null;
    }


}
