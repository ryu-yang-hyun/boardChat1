package com.board.boardchat.service.board;

import com.board.boardchat.dto.UserDto;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;

public interface BoardService{

    void memberCreate(UserDto userDto) throws ServiceException;
    Page<UserDto> memberList(UserDto userDto) throws ServiceException;

}
