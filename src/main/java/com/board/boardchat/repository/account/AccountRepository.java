package com.board.boardchat.repository.account;

import com.board.boardchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<User, Long>{

}
