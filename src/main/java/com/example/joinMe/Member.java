package com.example.joinMe;

public class Member {

    private int memberID;
    private String email;
    private String fullName;
    private String password;

    public Member(int memberId, String fullName, String email, String password){

        this.memberID = memberId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
