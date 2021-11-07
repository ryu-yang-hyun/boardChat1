package com.board.boardchat.model;

import javax.persistence.*;

@Entity
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "TITLE", length = 50)
    public String title;

    @Column(name = "CONTENT", length = 10000)
    public String content;
}
