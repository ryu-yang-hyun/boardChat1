package com.board.boardchat.repository.account;

import com.board.boardchat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<User, Long> ,AccountCustom {

    @Query("select count(u.userId) from User as u where u.userId = ?1 and u.password = ?2")
    Long actionLogin (String userId, String password);

    @Query("select count(u.email) from User as u where u.email = ?1 and u.password = ?2")
    Long actionLoginByEmail (String email, String password);

    @Query("select u from User as u where u.userId = ?1")
    User findUsersBy (String userId);

    @Query("select u from User as u where u.email = ?1")
    User findUserByEmail (String email);

    @Query("select u from User as u where u.id = ?1")
    Optional<User> findUserById (Long id);

}
