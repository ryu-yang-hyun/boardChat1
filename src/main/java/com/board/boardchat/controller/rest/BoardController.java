package com.board.boardchat.controller.rest;

import com.board.boardchat.dto.MemberDto;
import com.board.boardchat.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public void memberCreate(@RequestParam MemberDto memberDto) {
        boardService.memberCreate(memberDto);
    }

    @GetMapping
    public String memberList(@RequestParam MemberDto memberDto) {
        boardService.memberList(memberDto);
        return null;
    }

}
