package com.example.joinMe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;


public class Activity {

    private int id;
    private String activityName;
    private String email;
    private int maxMembers;
    private Date activityDate;
    private Date activityTime;
    private String location;
    private int categoryId;
    private int isOwner;

    public Activity(int activityid, String activityName, String email, int maxMembers, Date activityDate, Time activityTime, String location, int categoryId, int isOwner) {

        this.id = activityid;
        this.activityName = activityName;
        this.email = email;
        this.maxMembers = maxMembers;
        this.activityDate = activityDate;
        this.activityTime = activityTime;
        this.location = location;
        this.categoryId = categoryId;
        this.isOwner = isOwner;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate= activityDate;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(int isOwner) {
        this.isOwner = isOwner;
    }
}





