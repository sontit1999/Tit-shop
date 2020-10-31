package com.example.titshop.model;

public class CommentResponse {
    String idcomment;
    String iduser;
    String username;
    String noidung;
    String time;
    String linkavatar;

    public CommentResponse() {
    }

    public CommentResponse(String idcomment, String iduser, String username, String noidung, String time, String linkavatar) {
        this.idcomment = idcomment;
        this.iduser = iduser;
        this.username = username;
        this.noidung = noidung;
        this.time = time;
        this.linkavatar = linkavatar;
    }

    public String getIdcomment() {
        return idcomment;
    }

    public void setIdcomment(String idcomment) {
        this.idcomment = idcomment;
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

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLinkavatar() {
        return linkavatar;
    }

    public void setLinkavatar(String linkavatar) {
        this.linkavatar = linkavatar;
    }
}
