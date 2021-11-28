package com.board.boardchat.service.todo;

import com.board.boardchat.common.StatusEnum;
import com.board.boardchat.common.enumtype.TodoType;
import com.board.boardchat.dto.ResponseEntity;
import com.board.boardchat.dto.TodoDto;
import com.board.boardchat.model.Role;
import com.board.boardchat.model.Todo;
import com.board.boardchat.model.User;
import com.board.boardchat.repository.todo.TodoRepository;
import com.board.boardchat.service.account.AccountService;
import com.google.gson.Gson;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private AccountService accountService;


    /**
     * 조회
     */
    @Override
    public ResponseEntity todoList(TodoDto todoDto, HttpServletRequest request, Pageable pageable) throws ServiceException {

        ResponseEntity responseEntity = sessionUserCheck(todoDto, request);
        if(!"OK".equals(responseEntity.getCode())) {
            return responseEntity;
        }

        Gson gson = new Gson();
        String checkData = gson.toJson(responseEntity.getData());
        Todo todo = gson.fromJson(checkData,Todo.class);

        responseEntity.setData(todoRepository.findTotoList(todo.getUser().getId()));
        return responseEntity;
    }

    /**
     * 등록
     */
    @Override
    public ResponseEntity insertTodo(TodoDto todoDto, HttpServletRequest request) throws ServiceException {

        //user, session Check
        ResponseEntity responseEntity = sessionUserCheck(todoDto, request);

        if(!"OK".equals(responseEntity.getCode())) {
            return responseEntity;
        }

        Gson gson = new Gson();
        String checkData = gson.toJson(responseEntity.getData());
        Todo todo = gson.fromJson(checkData,Todo.class);

        todo.setTitle(todoDto.getTitle());
        todo.setContent(todoDto.getContent());
        todo.setStatus(TodoType.valueOf(todoDto.getStatus().toUpperCase()));
        todo.setStartTime(todoDto.getStartTime());
        todo.setEndTime(todoDto.getEndTime());
        todo.setOrders(todoDto.getOrders());

        responseEntity.setData(todoRepository.save(todo));
        if(responseEntity == null) {
            responseEntity.setCode(StatusEnum.INTERNAL_SERER_ERROR.toString());
        }

        return responseEntity;
    }

    /**
     * 상태변경
     */
    @Override
    public ResponseEntity updateStatus(TodoDto todoDto, HttpServletRequest request) throws ServiceException {

        //user, session Check
        ResponseEntity responseEntity = sessionUserCheck(todoDto, request);
        if(!"OK".equals(responseEntity.getCode())) {
            return responseEntity;
        }

        Gson gson = new Gson();
        String checkData = gson.toJson(responseEntity.getData());
        Todo todo = gson.fromJson(checkData,Todo.class);
        todo.setId(todoDto.getId());

        Optional<Todo> optionalTodo = todoRepository.findById(todo.getId());
        if(!optionalTodo.isPresent()) {
            responseEntity.setMessage("Todo 정보가 없습니다.");
            return responseEntity;
        }

        todo = optionalTodo.get();
        todo.setStatus(TodoType.valueOf(todoDto.getStatus().toUpperCase()));
        todo.setModifiedAt(LocalDateTime.now());
        todo.setModifiedBy(todo.getUser().getName());
        responseEntity.setData(todoRepository.save(todo));

        return responseEntity;
    }

    /**
     * 권한 add
     */
    public List<Role> customRole(List<Role> role) {
        List<Role> roles = new ArrayList<>();
        Role cuRoles = new Role();
        for(Role list : role) {
            cuRoles.setId(list.getId());
            cuRoles.setName(list.getName());
            roles.add(cuRoles);
        }
        return roles;
    }

    /**
     * usercheck
     */
    public ResponseEntity sessionUserCheck(TodoDto todoDto, HttpServletRequest request){

        ResponseEntity responseEntity = new ResponseEntity();
        Todo todo = new Todo();
        Optional<User> userCheck = accountService.userCheck(todoDto.getUserId());
        if(!userCheck.isPresent()) {
            responseEntity.setMessage("회원 정보가 없습니다. 관리자에게 문의해 주세요.");
            return responseEntity;
        }

        HttpSession session = request.getSession();
        if (session.getAttribute("USER") == null) {
            responseEntity.setMessage("로그인 정보가 없습니다. 관리자에게 문의해 주세요.");
            return responseEntity;
        }
        responseEntity.setCode(StatusEnum.OK.toString());
        todo.setCreateBy(userCheck.get().getName());

        userCheck.get().setRoles(customRole(userCheck.get().getRoles()));
        todo.setUser(userCheck.get());
        responseEntity.setData(todo);


        return responseEntity;
    }


}
