package com.cheney.springboot.oauth2.entity;

public class User {
    private Integer id;

    private String password;

    private String username;

    private String oauthrole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getOauthrole() {
        return oauthrole;
    }

    public void setOauthrole(String oauthrole) {
        this.oauthrole = oauthrole;
    }
}