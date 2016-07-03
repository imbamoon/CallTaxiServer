package com.springapp.mvc.db.entities;

import javax.persistence.*;

/**
 * Created by zyw on 2016/7/1.
 */
@Entity
@Table(name = "driver_loca", schema = "", catalog = "calltaxi")
public class DriverLocaEntity {
    private String username;
    private double lati;
    private double longi;
    private int valid;
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
    @Column(name = "lati", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getLati() {
        return lati;
    }

    public void setLati(double lati) {
        this.lati = lati;
    }

    @Basic
    @Column(name = "longi", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    @Basic
    @Column(name = "valid", nullable = false, insertable = true, updatable = true)
    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
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

        DriverLocaEntity that = (DriverLocaEntity) o;

        if (Double.compare(that.lati, lati) != 0) return false;
        if (Double.compare(that.longi, longi) != 0) return false;
        if (valid != that.valid) return false;
        if (dbId != that.dbId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = username != null ? username.hashCode() : 0;
        temp = Double.doubleToLongBits(lati);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longi);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + valid;
        result = 31 * result + dbId;
        return result;
    }
}
