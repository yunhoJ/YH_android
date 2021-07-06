package com.smhrd.team.yh;

import android.graphics.drawable.Drawable;
import android.widget.Button;

public class ListViewItem {

    private Drawable img;
    private String title;
    private String info;
    private Button findbar;

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Button getFindbar() {
        return findbar;
    }

    public void setFindbar(Button findbar) {
        this.findbar = findbar;
    }
}
