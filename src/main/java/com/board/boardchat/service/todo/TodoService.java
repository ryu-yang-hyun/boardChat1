package com.board.boardchat.service.todo;

import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.dto.TodoDto;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;

public interface TodoService {

    /**
     * 조회
     */
    public ResponseEntity todoList(TodoDto todoDto, HttpServletRequest request, Pageable pageable) throws ServiceException;

    /**
     * 등록
     */
    public ResponseEntity insertTodo(TodoDto todoDto, HttpServletRequest request) throws ServiceException;

    /**
     * 상태변경
     */
    public ResponseEntity updateStatus(TodoDto todoDto, HttpServletRequest request) throws ServiceException;

}
