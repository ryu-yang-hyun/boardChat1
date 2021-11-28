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
    public ResponseEntity todoList(@RequestBody TodoDto todoDto, HttpServletRequest request, Pageable pageable) {

        ResponseEntity result = todoService.todoList(todoDto, request, pageable);

        return result;

//        List<Todo> todos = todoService.getTodos(Sort.by(Direction.ASC, "id"));
//        return ResponseEntity.ok(todos);
    }

    /**
     * 등록
     */
    @PostMapping
    public ResponseEntity insertTodo(@RequestBody TodoDto todoDto, HttpServletRequest request) {

        ResponseEntity result = todoService.insertTodo(todoDto, request);

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
//
//    /*
//     *     수정
//     */
//    @PutMapping("/{id}")
//    public ResponseEntity<String> putTodo(@PathVariable("id") Long id) throws Exception {
//        Todo todo = todoService.findTodoById(id);
//
//        Boolean isComplete = todo.getIsComplete() ? false : true;
//        todo.setIsComplete(isComplete);
//        todoService.postTodo(todo);
//
//        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//    }
//
//    /*
//     *     삭제
//     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) throws Exception {
//        todoService.deleteTodo(id);
//
//        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//    }
}
