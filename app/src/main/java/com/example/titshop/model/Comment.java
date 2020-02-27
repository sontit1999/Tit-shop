package com.example.titshop.model;

public class Comment {
    User user;
    String content;
    String timeComment;

    public Comment() {
    }

    public Comment(User user, String content, String timeComment) {
        this.user = user;
        this.content = content;
        this.timeComment = timeComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(String timeComment) {
        this.timeComment = timeComment;
    }
}
