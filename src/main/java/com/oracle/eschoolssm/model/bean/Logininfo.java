package com.oracle.eschoolssm.model.bean;

public class Logininfo {
    private int logininfoid;
    private String ip;
    private String logintime;
    private String endtime;
    private User user;

    public int getLogininfoid() {
        return logininfoid;
    }

    public void setLogininfoid(int logininfoid) {
        this.logininfoid = logininfoid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
