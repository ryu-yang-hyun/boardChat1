//package com.board.boardchat.converter;
//
//import com.board.boardchat.common.AbstractDataConverter;
//import com.board.boardchat.entity.AccountEntity;
//import com.board.boardchat.entity.TodoEntity;
//import com.board.boardchat.model.Role;
//import com.board.boardchat.model.Todo;
//import com.board.boardchat.model.User;
//import org.springframework.core.convert.ConversionException;
//import org.springframework.util.CollectionUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TodoConverter extends AbstractDataConverter<Todo, TodoEntity> {
//
//    @Override
//    protected TodoEntity createTarget() {
//        return new TodoEntity();
//    }
//
//    @Override
//    public TodoEntity convert(Todo todo, TodoEntity todoEntity) throws ConversionException {
//
//        todoEntity.setId(todo.getId());
////        todoEntity.setUserId(todo.getUserId());
//
//        todoEntity.setTitle();
//        todoEntity.setContent();
//        todoEntity.setStatus();
//        todoEntity.setOrders();
//
//        if (!CollectionUtils.isEmpty(user.getRoles())) {
//            todoEntity.setRole(customRole(user.getRoles()));
//        }
//
//        return todoEntity;
//    }
//
//    public List<Role> customRole(List<Role> role) {
//        List<Role> roles = new ArrayList<>();
//        Role cuRoles = new Role();
//        for(Role list : role) {
//           cuRoles.setId(list.getId());
//           cuRoles.setName(list.getName());
//            roles.add(cuRoles);
//        }
//        return roles;
//    }
//}
