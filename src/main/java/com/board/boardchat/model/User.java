package com.board.boardchat.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**아이디**/
    @Column(name = "USERNAME", length = 50)
    public String username;

    /**이메일**/
    @Column(name = "USER_EMAIL", length = 1000)
    public String email;

    /**비밀번호**/
    @Column(name = "PASSWORD", length = 1000)
    public String password;

    /****/
    @Column(name = "ENABLED", length = 10)
    public Boolean enabled;

    /**성별**/
    @Column(name = "USER_GENDER", length = 10)
    public String gender;

    /**이름**/
    @Column(name = "NAME", length = 50)
    public String name;

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

    /**유저권한**/
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "ROLE", length = 30)
    public List<Role> roles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
