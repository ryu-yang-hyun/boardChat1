package com.board.boardchat.model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class CommonEntity {

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

    /**삭제여부**/
    @Column(name = "DEL_YN", length = 10)
    public String delYn;

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

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }
}
