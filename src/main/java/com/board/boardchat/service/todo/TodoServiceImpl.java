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
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ResponseEntity todoList(TodoDto todoDto) throws ServiceException {

        ResponseEntity responseEntity = new ResponseEntity();
        Optional<User> userCheck = accountService.userCheck(todoDto.getUserId());
        if(!userCheck.isPresent()) {
            responseEntity.setMessage("회원 정보가 없습니다. 관리자에게 문의해 주세요.");
            return responseEntity;
        }

//        responseEntity.setData(todoRepository.findAllList());

//        Optional<Todo> todoList = todoRepository.findById(todoDto.getUser().getId());

        return null;
    }

    /**
     * 등록
     */
    @Override
    public ResponseEntity insertTodo(TodoDto todoDto) throws ServiceException {

        ResponseEntity responseEntity = new ResponseEntity();
        Optional<User> userCheck = accountService.userCheck(todoDto.getUserId());
        if(!userCheck.isPresent()) {
            responseEntity.setMessage("회원 정보가 없습니다. 관리자에게 문의해 주세요.");
            return responseEntity;
        }

        // TODO: 21. 11. 26. SESSION 정보도 예외 처리할 예정

        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setContent(todoDto.getContent());
        todo.setStatus(TodoType.valueOf(todoDto.getStatus().toUpperCase()));
        todo.setStartTime(todoDto.getStartTime());
        todo.setEndTime(todoDto.getEndTime());
        todo.setOrders(todoDto.getOrders());
        todo.setCreateBy(userCheck.get().getName());

        userCheck.get().setRoles(customRole(userCheck.get().getRoles()));
        todo.setUser(userCheck.get());

        responseEntity.setData(todoRepository.save(todo));
        responseEntity.setCode(StatusEnum.OK.toString());
        if(responseEntity == null) {
            responseEntity.setCode(StatusEnum.INTERNAL_SERER_ERROR.toString());
        }

        return responseEntity;
    }

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
}
