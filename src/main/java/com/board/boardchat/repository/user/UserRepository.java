package com.board.boardchat.repository.user;

import com.board.boardchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
