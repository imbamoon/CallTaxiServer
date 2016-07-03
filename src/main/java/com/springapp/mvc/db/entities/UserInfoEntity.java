package com.springapp.mvc.db.entities;

import javax.persistence.*;

/**
 * Created by zyw on 2016/7/1.
 */
@Entity
@Table(name = "user_info", schema = "", catalog = "calltaxi")
public class UserInfoEntity {
    private String username;
    private String pwd;
    private short type;
    private int dbId;
    private Integer phone;

    @Basic
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "pwd", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "type", nullable = false, insertable = true, updatable = true)
    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    @Id
    @Column(name = "db_id", nullable = false, insertable = true, updatable = true)
    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true)
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (type != that.type) return false;
        if (dbId != that.dbId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (int) type;
        result = 31 * result + dbId;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
