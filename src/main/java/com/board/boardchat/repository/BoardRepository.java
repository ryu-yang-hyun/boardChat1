package com.board.boardchat.repository;

import com.board.boardchat.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface BoardRepository extends JpaRepository<Member, Long> , BoardRepositoryCustom {

}
