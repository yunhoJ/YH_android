package com.smhrd.team.yh;


import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

public class CommunityAMainDTO implements Serializable {
    String tv_community_title,tv_community_star,tv_community_rating,tv_community_person;
    Drawable img_community_star;



    public CommunityAMainDTO(String tv_community_title, String tv_community_star, String tv_community_rating, String tv_community_person) {
        this.tv_community_title = tv_community_title;
        this.tv_community_star = tv_community_star;
        this.tv_community_rating = tv_community_rating;
        this.tv_community_person = tv_community_person;

    }

    public CommunityAMainDTO() {

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
