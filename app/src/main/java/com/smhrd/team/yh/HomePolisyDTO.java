package com.smhrd.team.yh;

import android.graphics.drawable.Drawable;
import android.widget.Button;

public class HomePolisyDTO {
   private String tv_policy_title;
    private String tv_policy_content;
    private Drawable img;


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
