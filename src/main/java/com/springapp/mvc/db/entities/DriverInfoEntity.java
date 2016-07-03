package com.springapp.mvc.db.entities;

import javax.persistence.*;

/**
 * Created by zyw on 2016/7/1.
 */
@Entity
@Table(name = "driver_info", schema = "", catalog = "calltaxi")
public class DriverInfoEntity {
    private String username;
    private String pwd;
    private String license;
    private int dbId;

    @Basic
    @Column(name = "username", nullable = true, insertable = true, updatable = true, length = 20)
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
    @Column(name = "license", nullable = false, insertable = true, updatable = true, length = 20)
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Id
    @Column(name = "db_id", nullable = false, insertable = true, updatable = true)
    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverInfoEntity that = (DriverInfoEntity) o;

        if (dbId != that.dbId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (license != null ? !license.equals(that.license) : that.license != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + dbId;
        return result;
    }
}
