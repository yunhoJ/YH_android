package com.smhrd.team.yh;

import java.io.Serializable;

public class MemberDTO implements Serializable {

    // join 회원가입 유저정보 받기위한 DTO !
    private String users_id;
    private String users_pw;
    private String users_pw2;
    private String users_gender;
    private String users_age;
    private String users_interesting;
    private String users_income;
    private String users_single_parent;
    private String users_phone_number;
    private String users_disabled_person;
    private String users_pregnant_women;
    private String users_alaram;
    private String location_no;

    public MemberDTO(String users_id, String users_pw, String users_gender, String users_interesting, String users_income, String users_single_parent, String users_phone_number, String users_disabled_person, String users_pregnant_women, String users_alaram, String location_no){
        this.users_id = users_id;
        this.users_pw = users_pw;
        this.users_gender = users_gender;
        this.users_interesting = users_interesting;
        this.users_income = users_income;
        this.users_single_parent = users_single_parent;
        this.users_phone_number = users_phone_number;
        this.users_disabled_person = users_disabled_person;
        this.users_pregnant_women = users_pregnant_women;
        this.users_alaram = users_alaram;
        this.location_no = location_no;
    }

    public MemberDTO(String users_id, String users_pw, String users_gender, String users_age, String users_interesting, String users_income, String users_single_parent, String users_phone_number, String users_disabled_person, String users_pregnant_women, String users_alaram, String location_no) {
        this.users_id = users_id;
        this.users_pw = users_pw;
        this.users_gender = users_gender;
        this.users_age = users_age;
        this.users_interesting = users_interesting;
        this.users_income = users_income;
        this.users_single_parent = users_single_parent;
        this.users_phone_number = users_phone_number;
        this.users_disabled_person = users_disabled_person;
        this.users_pregnant_women = users_pregnant_women;
        this.users_alaram = users_alaram;
        this.location_no = location_no;
    }

    public MemberDTO(String users_income, String users_single_parent, String users_phone_number, String users_disabled_person, String users_pregnant_women, String users_alaram, String location_no) {
        this.users_income = users_income;
        this.users_single_parent = users_single_parent;
        this.users_phone_number = users_phone_number;
        this.users_disabled_person = users_disabled_person;
        this.users_pregnant_women = users_pregnant_women;
        this.users_alaram = users_alaram;
        this.location_no = location_no;
    }

    public MemberDTO(String users_id, String users_pw, String users_gender, String users_age, String users_interesting) {
        this.users_id = users_id;
        this.users_pw = users_pw;
        this.users_gender = users_gender;
        this.users_age = users_age;
        this.users_interesting = users_interesting;
    }

    public MemberDTO(String users_id, String users_pw) {
        this.users_id = users_id;
        this.users_pw = users_pw;
    }

    public MemberDTO(String users_id, String users_pw, String users_pw2, String users_gender, String users_phone_number, String users_alaram){
        this.users_id = users_id;
        this.users_pw = users_pw;
        this.users_gender = users_gender;
        this.users_phone_number = users_phone_number;
        this.users_alaram = users_alaram;
    }

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public String getUsers_pw() {
        return users_pw;
    }

    public void setUsers_pw(String users_pw) {
        this.users_pw = users_pw;
    }

    public String getUsers_gender() {
        return users_gender;
    }

    public void setUsers_gender(String users_gender) {
        this.users_gender = users_gender;
    }

    public String getUsers_age() {
        return users_age;
    }

    public void setUsers_age(String users_age) {
        this.users_age = users_age;
    }

    public String getUsers_interesting() {
        return users_interesting;
    }

    public void setUsers_interesting(String users_interesting) {
        this.users_interesting = users_interesting;
    }

    public String getUsers_income() {
        return users_income;
    }

    public void setUsers_income(String users_income) {
        this.users_income = users_income;
    }

    public String getUsers_single_parent() {
        return users_single_parent;
    }

    public void setUsers_single_parent(String users_single_parent) {
        this.users_single_parent = users_single_parent;
    }

    public String getUsers_phone_number() {
        return users_phone_number;
    }

    public void setUsers_phone_number(String users_phone_number) {
        this.users_phone_number = users_phone_number;
    }

    public String getUsers_disabled_person() {
        return users_disabled_person;
    }

    public void setUsers_disabled_person(String users_disabled_person) {
        this.users_disabled_person = users_disabled_person;
    }

    public String getUsers_pregnant_women() {
        return users_pregnant_women;
    }

    public void setUsers_pregnant_women(String users_pregnant_women) {
        this.users_pregnant_women = users_pregnant_women;
    }

    public String getUsers_alaram() {
        return users_alaram;
    }

    public void setUsers_alaram(String users_alaram) {
        this.users_alaram = users_alaram;
    }

    public String getLocation_no() {
        return location_no;
    }

    public void setLocation_no(String location_no) {
        this.location_no = location_no;
    }
}
