package com.board.boardchat.repository.account;

import com.board.boardchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<User, Long> ,AccountCustom {

    @Query("select count(u.userId) from User as u where u.userId = ?1 and u.password = ?2")
    Long actionLogin (String userId, String password);

    @Query("select u from User as u where u.userId = ?1")
    User findUsersBy (String userId);

}
