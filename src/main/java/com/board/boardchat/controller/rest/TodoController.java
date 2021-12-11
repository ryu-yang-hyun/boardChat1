package com.board.boardchat.controller.rest;


import com.board.boardchat.common.Constant;
import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.dto.TodoDto;
import com.board.boardchat.service.todo.TodoService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(Constant.API_URL + "/todos")
public class TodoController {

    private final TodoService todoService;

    @Inject
    public TodoController (TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     *  조회
     */
    @GetMapping
    public ResponseEntity todoList(HttpServletRequest request) {

        ResponseEntity result = todoService.todoList(request);

        return result;
    }
//    @GetMapping
//    public ResponseEntity todoList(@RequestBody TodoDto todoDto, HttpServletRequest request, Pageable pageable) {
//
//        ResponseEntity result = todoService.todoList(todoDto, request, pageable);
//
//        return result;
//    }


    /**
     * 등록
     */
    @PostMapping
    public ResponseEntity insertTodo(@RequestBody TodoDto todoDto, HttpServletRequest request) {

        ResponseEntity result = todoService.insertTodo(todoDto, request);

        return result;
    }

    /**
     * 상세
     */
    @PostMapping("/details")
    public ResponseEntity details(@RequestBody TodoDto todoDto, HttpServletRequest request) {

        ResponseEntity result = todoService.details(todoDto, request);

        return result;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id, HttpServletRequest request) {
        return todoService.delete( id, request );
    }

    /**
     *수정
     */
    @PostMapping("/modify")
    public ResponseEntity updateModify(@RequestBody TodoDto todoDto, HttpServletRequest request) throws Exception {

        ResponseEntity result = todoService.updateModify(todoDto, request);

        return result;
    }

    /**
     * 상태변경
     */
    @PostMapping("/status")
    public ResponseEntity updateStatus(@RequestBody TodoDto todoDto, HttpServletRequest request) {

        ResponseEntity result = todoService.updateStatus(todoDto, request);

        return result;
    }

    /**
     * 상태변경
     */
    @PatchMapping("/order/{todoId}/{order}")
    public ResponseEntity updateOrder(@PathVariable Long todoId, @PathVariable Long order, HttpServletRequest request) {

        ResponseEntity result = todoService.updateOrders(todoId, order, request);

        return result;
    }

}
