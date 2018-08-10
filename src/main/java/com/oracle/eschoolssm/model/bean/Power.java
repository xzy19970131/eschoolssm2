package com.oracle.eschoolssm.model.bean;

/**
 * 权限信息类
 */
public class Power {
    private int powerid;
    private String powername;
    private String requesturl;
    private int have;
    private Admin admin;

    public int getPowerid() {
        return powerid;
    }

    public void setPowerid(int powerid) {
        this.powerid = powerid;
    }

    public String getPowername() {
        return powername;
    }

    public void setPowername(String powername) {
        this.powername = powername;
    }

    public String getRequesturl() {
        return requesturl;
    }

    public void setRequesturl(String requesturl) {
        this.requesturl = requesturl;
    }

    public int getHave() {
        return have;
    }

    public void setHave(int have) {
        this.have = have;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Power{" +
                "powerid=" + powerid +
                ", powername='" + powername + '\'' +
                ", requesturl='" + requesturl + '\'' +
                ", have=" + have +
                '}';
    }
}
