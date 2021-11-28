package com.board.boardchat.service.todo;

import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.dto.TodoDto;
import org.hibernate.service.spi.ServiceException;

public interface TodoService {

    /**
     * 조회
     */
    public ResponseEntity todoList(TodoDto todoDto) throws ServiceException;


    /**
     * 등록
     */
    public ResponseEntity insertTodo(TodoDto todoDto) throws ServiceException;

}
