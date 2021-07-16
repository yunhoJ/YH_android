package com.smhrd.team.yh;

import android.graphics.drawable.Drawable;
import android.widget.Button;

public class HomePolisyDTO {
   private String tv_policy_title;
    private String tv_policy_content;
    private String tv_policy_apply;
    private String tv_policy_detail;
    private Drawable img;
    private int starList;

    public HomePolisyDTO(String tv_policy_title, String tv_policy_content, String tv_policy_apply, String tv_policy_detail) {
        this.tv_policy_title = tv_policy_title;
        this.tv_policy_content = tv_policy_content;
        this.tv_policy_apply = tv_policy_apply;
        this.tv_policy_detail = tv_policy_detail;
    }

    public String getTv_policy_apply() {
        return tv_policy_apply;
    }

    public void setTv_policy_apply(String tv_policy_apply) {
        this.tv_policy_apply = tv_policy_apply;
    }

    public String getTv_policy_detail() {
        return tv_policy_detail;
    }

    public void setTv_policy_detail(String tv_policy_detail) {
        this.tv_policy_detail = tv_policy_detail;
    }

    public HomePolisyDTO(String tv_policy_title, String tv_policy_content, int starList) {
        this.tv_policy_title = tv_policy_title;
        this.tv_policy_content = tv_policy_content;
        this.starList = starList;
    }

    public int getStarList() {
        return starList;
    }

    public void setStarList(int starList) {
        this.starList = starList;
    }

    @Override
    public java.lang.String toString() {
        return "{" +
                "\"tv_policy_title\":\"" + tv_policy_title +
                "\", \"tv_policy_content\":\"" + tv_policy_content +
                "\", \"starList\":\"" + starList +"\"}";
    }

    public HomePolisyDTO(String tv_policy_title, String tv_policy_content) {
        this.tv_policy_title = tv_policy_title;
        this.tv_policy_content = tv_policy_content;

    }

    public HomePolisyDTO(String tv_policy_title, String tv_policy_content, Drawable img) {
        this.tv_policy_title = tv_policy_title;
        this.tv_policy_content = tv_policy_content;
        this.img = img;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getTv_policy_title() {
        return tv_policy_title;
    }

    public void setTv_policy_title(String tv_policy_title) {
        this.tv_policy_title = tv_policy_title;
    }

    public String getTv_policy_content() {
        return tv_policy_content;
    }

    public void setTv_policy_content(String tv_policy_content) {
        this.tv_policy_content = tv_policy_content;
    }


}
