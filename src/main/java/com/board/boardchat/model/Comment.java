package com.board.boardchat.model;

import javax.persistence.*;


@Entity
@Table(name = "COMMENT")
public class Comment extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "COMMENT")
    public String comment;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    public Board board;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
