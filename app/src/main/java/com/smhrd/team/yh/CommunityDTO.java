package com.smhrd.team.yh;

public class CommunityDTO {

    private String users_id;
    private String community_date;
    private String community_content;
    private String community_policy;

//    public CommunityDTO(String users_id, String community_content) {
//        this.users_id = users_id;
//        this.community_content = community_content;
//    }
//
//    public CommunityDTO(String community_policy) {
//        this.community_policy = community_policy;
//    }

    public CommunityDTO(String users_id, String community_date, String community_content) {
        this.users_id = users_id;
        this.community_date = community_date;
        this.community_content = community_content;
    }

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public String getCommunity_date() {
        return community_date;
    }

    public void setCommunity_date(String community_date) {
        this.community_date = community_date;
    }

    public String getCommunity_content() {
        return community_content;
    }

    public void setCommunity_content(String community_content) {
        this.community_content = community_content;
    }

    public String getCommunity_policy() {
        return community_policy;
    }

    public void setCommunity_policy(String community_policy) {
        this.community_policy = community_policy;

import android.graphics.drawable.Drawable;

public class CommunityDTO {
    String tv_community_title,tv_community_star,tv_community_rating,tv_community_person;
    Drawable img_community_star;

    public CommunityDTO(String tv_community_title, String tv_community_star, String tv_community_rating, String tv_community_person) {
        this.tv_community_title = tv_community_title;
        this.tv_community_star = tv_community_star;
        this.tv_community_rating = tv_community_rating;
        this.tv_community_person = tv_community_person;

    }

    public String getTv_community_title() {
        return tv_community_title;
    }

    public void setTv_community_title(String tv_community_title) {
        this.tv_community_title = tv_community_title;
    }

    public String getTv_community_star() {
        return tv_community_star;
    }

    public void setTv_community_star(String tv_community_star) {
        this.tv_community_star = tv_community_star;
    }

    public String getTv_community_rating() {
        return tv_community_rating;
    }

    public void setTv_community_rating(String tv_community_rating) {
        this.tv_community_rating = tv_community_rating;
    }

    public String getTv_community_person() {
        return tv_community_person;
    }

    public void setTv_community_person(String tv_community_person) {
        this.tv_community_person = tv_community_person;
    }

    public Drawable getImg_community_star() {
        return img_community_star;
    }

    public void setImg_community_star(Drawable img_community_star) {
        this.img_community_star = img_community_star;
    }
}
