//package com.board.boardchat.repository;
//
//import com.board.boardchat.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface SecurityRepository extends JpaRepository<User, Long> {
//
//    @Query("select u from User u where u.username = ?1")
//    User findUserBy (String username);
//
//}
