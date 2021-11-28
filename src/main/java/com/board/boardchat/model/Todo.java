package com.board.boardchat.model;


import com.board.boardchat.common.enumtype.TodoType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TODO")
public class Todo extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "TITLE")
    public String title;

    @Column(name = "CONTENT")
    public String content;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS", length = 20, nullable = false)
    private TodoType status;

    @Column(name = "ORDERS")
    public Long orders;

    @Column(name = "STARTTIME")
    public LocalDateTime startTime;

    @Column(name = "ENDTIME")
    public LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TodoType getStatus() {
        return status;
    }

    public void setStatus(TodoType status) {
        this.status = status;
    }

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
