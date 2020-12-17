package com.example.joinMe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.Date;


public class Activity {

    private int id;
    private String activityName;
    private String email;
    private int maxMembers;
    private ZonedDateTime activityDate;
    //private Time activityTime;
    private String location;
    private int categoryId;
    private String categoryName;
    private int isOwner;

    public Activity() {

    }

    public Activity(int activityId, String activityName, String email, int maxMembers, ZonedDateTime activityDate, String location, int categoryId, String categoryName, int isOwner) {

        this.id = activityId;
        this.activityName = activityName;
        this.email = email;
        this.maxMembers = maxMembers;
        this.activityDate = activityDate;
        // this.activityTime = activityTime;
        this.location = location;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.isOwner = isOwner;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String categoryName() {
        return categoryName;
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

    public ZonedDateTime getActivityDate() {

        return activityDate;
    }

    public void setActivityDate(ZonedDateTime activityDate) {
        this.activityDate = activityDate;
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

    public void updateWithDisplayDateAndTime(DisplayDateAndTime dt) {
        setActivityDate(ZonedDateTime.of(dt.getDate(), dt.getTime(), DateUtil.DEFAULT_ZONE));
    }


}





