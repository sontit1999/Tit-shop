package com.example.titshop.model;

public class User {
    String userName;
    String urlAvatar;
    String phoneNumber;
    String Address;
    String sentencesLike;
    public User() {
    }

    public User(String userName, String urlAvatar, String phoneNumber, String address, String sentencesLike) {
        this.userName = userName;
        this.urlAvatar = urlAvatar;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.sentencesLike = sentencesLike;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSentencesLike() {
        return sentencesLike;
    }

    public void setSentencesLike(String sentencesLike) {
        this.sentencesLike = sentencesLike;
    }
}
