package com.board.boardchat.repository.todo;

import com.board.boardchat.model.Todo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    @Query("select t from Todo t where t.user = ?1")
    List<Todo> findAllList (Long id);
}
