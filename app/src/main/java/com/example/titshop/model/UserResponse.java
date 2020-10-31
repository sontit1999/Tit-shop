package com.example.titshop.model;

public class UserResponse {
    String status;
    String iduser;
    String username;
    String sdt;
    String password;
    String linkavatar;
    String address;

    public UserResponse() {
    }

    public UserResponse(String status, String iduser, String username, String sdt, String password, String linkavatar, String address) {
        this.status = status;
        this.iduser = iduser;
        this.username = username;
        this.sdt = sdt;
        this.password = password;
        this.linkavatar = linkavatar;
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLinkavatar() {
        return linkavatar;
    }

    public void setLinkavatar(String linkavatar) {
        this.linkavatar = linkavatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
