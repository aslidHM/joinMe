package com.example.joinMe;

import java.time.ZonedDateTime;
import java.util.List;


public class Activity {

    private int activityId;
    private String activityName;

    private int maxMembers;
    private ZonedDateTime activityDate;
    //private Time activityTime;
    private String location;
    private int categoryId;
    private String categoryName;
    private int ownerMemberId;


    public Activity() {

    }
    private List<Member> activityMembers;

    public Activity(int activityId, String activityName, int maxMembers, ZonedDateTime activityDate, String location, int categoryId, String categoryName, int ownerMemberId) {

        this.activityId = activityId;
        this.activityName = activityName;
        this.maxMembers = maxMembers;
        this.activityDate = activityDate;
        // this.activityTime = activityTime;
        this.location = location;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.ownerMemberId = ownerMemberId;

    }

    public void setActivityMembers(List<Member> activityMembers) {

        /*for (Member member : activityMembers) {
            activityMembers.add(member);
        }*/
        this.activityMembers = activityMembers;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Member> getActivityMembers() {
        return activityMembers;
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

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int id) {
        this.activityId = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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

    public int getOwnerMemberId() {
        return ownerMemberId;
    }

    public void setOwnerMemberId(int ownerMemberId) {
        this.ownerMemberId = ownerMemberId;
    }

    public void updateWithDisplayDateAndTime(DisplayDateAndTime dt) {
        setActivityDate(ZonedDateTime.of(dt.getDate(), dt.getTime(), DateUtil.DEFAULT_ZONE));
    }


}





