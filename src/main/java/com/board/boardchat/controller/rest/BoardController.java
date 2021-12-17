package com.board.boardchat.controller.rest;

import com.board.boardchat.common.Constant;
import com.board.boardchat.common.GetSort;
import com.board.boardchat.dto.BoardDto;
import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.model.Board;
import com.board.boardchat.service.board.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(Constant.API_URL + "/board")
public class BoardController {

    private final BoardService boardService;

    @Inject
    public BoardController (BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     *  조회
     */
    @GetMapping
    public ResponseEntity boardList(HttpServletRequest request,
                                    @RequestParam(value = "keyword", defaultValue = "") String keyword,
                                    @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        ResponseEntity result = boardService.boardList(keyword, offset, limit, request);

        return result;
    }


    /**
     * 등록
     */
    @PostMapping
    public ResponseEntity insertBoard(@RequestBody BoardDto boardDto, HttpServletRequest request) {

        ResponseEntity result = boardService.insertBoard(boardDto, request);

        return result;
    }

    /**
     * 상세
     */
    @PostMapping("/details")
    public ResponseEntity details(@RequestBody BoardDto boardDto, HttpServletRequest request) {

        ResponseEntity result = boardService.details(boardDto, request);

        return result;
    }

    /**
     *수정
     */
    @PostMapping("/modify")
    public ResponseEntity updateModify(@RequestBody BoardDto boardDto, HttpServletRequest request) throws Exception {

        ResponseEntity result = boardService.updateModify(boardDto, request);

        return result;
    }
}
