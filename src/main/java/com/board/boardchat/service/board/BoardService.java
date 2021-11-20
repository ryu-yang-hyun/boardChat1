package com.board.boardchat.service.board;

//import com.board.boardchat.dto.UserDto;
import com.board.boardchat.dto.BoardDto;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;

public interface BoardService {

    String boardCreate (BoardDto boardDto) throws ServiceException;

//    void memberCreate(UserDto userDto) throws ServiceException;
//    Page<UserDto> memberList(UserDto userDto) throws ServiceException;

}
