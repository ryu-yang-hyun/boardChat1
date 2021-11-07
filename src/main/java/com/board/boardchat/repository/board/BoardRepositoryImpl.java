package com.board.boardchat.repository.board;

import com.board.boardchat.dto.UserDto;
import org.springframework.data.domain.Page;

public class BoardRepositoryImpl implements BoardRepositoryCustom {

    @Override
    public Page<UserDto> memberList (UserDto userDto) {

        //TODO Pageable 작업 ..
        return null;
    }


}
