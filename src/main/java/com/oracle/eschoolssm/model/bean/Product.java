package com.oracle.eschoolssm.model.bean;

import java.util.List;

public class Product {


    private int productid;
    private String name;
    private int costprice;
    private int nowprice;
    private int discount;
    private int quality;
    private String describle;
    private String endtime;
    private String starttime;
    private int promotion;
    private int count;
    private int shelves;
    private int id;
    private int userid;

    private List<Comment> comments;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCostprice() {
        return costprice;
    }

    public void setCostprice(int costprice) {
        this.costprice = costprice;
    }

    public int getNowprice() {
        return nowprice;
    }

    public void setNowprice(int nowprice) {
        this.nowprice = nowprice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getShelves() {
        return shelves;
    }

    public void setShelves(int shelves) {
        this.shelves = shelves;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", costprice=" + costprice +
                ", nowprice=" + nowprice +
                ", discount=" + discount +
                ", quality=" + quality +
                ", describle='" + describle + '\'' +
                ", endtime='" + endtime + '\'' +
                ", starttime='" + starttime + '\'' +
                ", promotion=" + promotion +
                ", count=" + count +
                ", shelves=" + shelves +
                ", id=" + id +
                ", userid=" + userid +
                ", comments=" + comments +
                '}';
    }
}
