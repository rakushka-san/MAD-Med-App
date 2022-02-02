package com.rakushkins.madmeditationapp;

public class LoginResponse {
    private String id;
    private String email;
    private String nickName;
    private String avatar;
    private String token;

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getToken() {
        return token;
    }
}
