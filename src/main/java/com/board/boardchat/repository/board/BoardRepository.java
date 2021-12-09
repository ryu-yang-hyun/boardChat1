package com.board.boardchat.repository.board;

import com.board.boardchat.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> , PagingAndSortingRepository<Board,Long> {

    @Query("select b from Board as b where b.id = ?1")
    Optional<Board> findBoardId (Long boardId);

}
