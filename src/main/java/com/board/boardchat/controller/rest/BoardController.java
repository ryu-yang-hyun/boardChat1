package com.board.boardchat.controller.rest;

import com.board.boardchat.dto.BoardDto;
import com.board.boardchat.model.Board;
import com.board.boardchat.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Inject
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public String boardCreate (@RequestBody BoardDto boardDto) {


        String result = boardService.boardCreate(boardDto);


        return "";
    }

//    @GetMapping
//    public String boardList(@RequestParam UserDto userDto) {
//        boardService.memberList(userDto);
//        return null;
//    }

}
