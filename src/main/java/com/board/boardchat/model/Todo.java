package com.board.boardchat.model;


import com.board.boardchat.common.enumtype.TodoType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TODO")
public class Todo {

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

    /**생성자**/
    @Column(name = "CREATE_BY", length = 20)
    public String createBy;

    /**수정자**/
    @Column(name = "MODIFIED_BY", length = 20)
    public String modifiedBy;

    /**생성날짜**/
    @Column(name = "CREATE_AT", length = 50)
    public LocalDateTime createAt = LocalDateTime.now();

    /**수정날짜**/
    @Column(name = "MODIFIED_AT", length = 50)
    public LocalDateTime modifiedAt;

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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
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
