package com.oracle.eschoolssm.model.bean;

public class User {
      int userid ;
      String username;
      String password  ;
      String nickname ;
      int sex  ;
      int age  ;
      String qq ;
      String  phone ;
      String email ;
      String  image ;
      String     address ;
      String  createtime  ;
      int statue ;


  public User() {
  }

  public User(int userid) {
    this.userid = userid;
  }

  public User(int userid, String username, String password, String nickname, int sex, int age, String qq, String phone, String email, String image, String address, String createtime, int statue) {
    this.userid = userid;
    this.username = username;
    this.password = password;
    this.nickname = nickname;
    this.sex = sex;
    this.age = age;
    this.qq = qq;
    this.phone = phone;
    this.email = email;
    this.image = image;
    this.address = address;
    this.createtime = createtime;
    this.statue = statue;
  }

  @Override
  public String toString() {
    return "User{" +
            "userid=" + userid +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", nickname='" + nickname + '\'' +
            ", sex=" + sex +
            ", age=" + age +
            ", qq='" + qq + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", image='" + image + '\'' +
            ", address='" + address + '\'' +
            ", createtime='" + createtime + '\'' +
            ", statue=" + statue +
            '}';
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public int getStatue() {
    return statue;
  }

  public void setStatue(int statue) {
    this.statue = statue;
  }
}
