package com.an.room.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.an.room.util.TimestampConverter;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class  Note implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    @ColumnInfo(name = "created_date")
    @TypeConverters({TimestampConverter.class})
    private Date createdDate;

    private String description;
    //private String time;

//    @ColumnInfo(name = "created_at")
//    @TypeConverters({TimestampConverter.class})
//    private Date createdAt;

//    @ColumnInfo(name = "modified_at")
//    @TypeConverters({TimestampConverter.class})
//    private Date modifiedAt;
//


    @ColumnInfo(name = "created_time")
    @TypeConverters({TimestampConverter.class})
    private Time createdTime;

    private boolean encrypt;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }

//    public Date getCreatedAt() { return createdAt; }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getModifiedAt() {
//        return modifiedAt;
//    }
//
//    public void setModifiedAt(Date modifiedAt) {
//        this.modifiedAt = modifiedAt;
//    }
    public Date getCreatedDate() { return createdDate; }

    public String getFormattedDate() {
        return (new SimpleDateFormat("dd MMM")).format(this.getCreatedDate());
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Time createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
