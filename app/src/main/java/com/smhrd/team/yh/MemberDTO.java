package com.smhrd.team.yh;

public class MemberDTO {

    // join 회원가입 유저정보 받기위한 DTO !

    private  String id;
    private  String pw;
    private  String sex;
    private  String birth;
    private  String phone;

    public MemberDTO(String id, String pw, String sex, String birth, String phone) {
        this.id = id;
        this.pw = pw;
        this.sex = sex;
        this.birth = birth;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
