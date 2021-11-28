package com.board.boardchat.repository.todo;

import com.board.boardchat.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    @Query("select t from Todo as t where t.user.id = ?1")
    List<Todo> findTotoList (Long userId);
}
