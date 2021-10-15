package com.board.boardchat.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue

    public Long id;

    @Column(name = "MEMBER_EMAIL", length = 1000)
    public String email;

    @Column(name = "MEMBER_PASSWORD", length = 1000)
    public String password;

    @Column(name = "MEMBER_GENDER", length = 10)
    public String gender;

    @Column(name = "CREATE_BY", length = 20)
    public String createBy;

    @Column(name = "MODIFIED_BY", length = 20)
    public String modifiedBy;

    @Column(name = "CREATE_AT", length = 50)
    public LocalDateTime createAt;

    @Column(name = "MODIFIED_AT", length = 50)
    public LocalDateTime modifiedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
}
