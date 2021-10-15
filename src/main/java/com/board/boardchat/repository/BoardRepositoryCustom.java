package com.board.boardchat.repository;

import com.board.boardchat.dto.MemberDto;
import org.springframework.data.domain.Page;

public interface BoardRepositoryCustom {

    Page<MemberDto> memberList(MemberDto memberDto);
}
