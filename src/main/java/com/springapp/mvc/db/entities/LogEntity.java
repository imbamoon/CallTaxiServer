package com.springapp.mvc.db.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by zyw on 2016/7/1.
 */
@Entity
@Table(name = "log", schema = "", catalog = "calltaxi")
public class LogEntity {
    private String userId;
    private String driverId;
    private Timestamp stTime;
    private Timestamp edTime;
    private int status;
    private int dbId;

    @Basic
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "driver_id", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "st_time", nullable = false, insertable = true, updatable = true)
    public Timestamp getStTime() {
        return stTime;
    }

    public void setStTime(Timestamp stTime) {
        this.stTime = stTime;
    }

    @Basic
    @Column(name = "ed_time", nullable = false, insertable = true, updatable = true)
    public Timestamp getEdTime() {
        return edTime;
    }

    public void setEdTime(Timestamp edTime) {
        this.edTime = edTime;
    }

    @Basic
    @Column(name = "status", nullable = false, insertable = true, updatable = true)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

        LogEntity logEntity = (LogEntity) o;

        if (status != logEntity.status) return false;
        if (dbId != logEntity.dbId) return false;
        if (userId != null ? !userId.equals(logEntity.userId) : logEntity.userId != null) return false;
        if (driverId != null ? !driverId.equals(logEntity.driverId) : logEntity.driverId != null) return false;
        if (stTime != null ? !stTime.equals(logEntity.stTime) : logEntity.stTime != null) return false;
        if (edTime != null ? !edTime.equals(logEntity.edTime) : logEntity.edTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        result = 31 * result + (stTime != null ? stTime.hashCode() : 0);
        result = 31 * result + (edTime != null ? edTime.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + dbId;
        return result;
    }
}
