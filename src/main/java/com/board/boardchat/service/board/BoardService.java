package com.board.boardchat.service.board;

import com.board.boardchat.dto.BoardDto;
import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.model.Board;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {

    /**
     * 조회
     */
    public ResponseEntity boardList (String keyword, Integer offset, Integer limit, HttpServletRequest request) throws ServiceException;

    /**
     * 등록
     */
    public ResponseEntity insertBoard (BoardDto boardDto, HttpServletRequest request) throws  ServiceException;

    /**
     * 상세
     */
    public ResponseEntity details(BoardDto boardDto, HttpServletRequest request) throws ServiceException;

    /**
     * 수정
     */
    public ResponseEntity updateModify(BoardDto boardDto, HttpServletRequest request) throws ServiceException;
}
