package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class searchPage extends AppCompatActivity {

    private Button btn_searchBar, btn_hambar,btn_jeo, btn_han, btn_moon, btn_imsin, btn_gyo,
            btn_so, btn_joong, btn_geon, btn_yeong, btn_jang, btn_no, btn_goyong,
            btn_cheong, btn_seomin, btn_joo;

    private ImageView img_search_ham, img_jeo, img_han, img_moon, img_imsin, img_gyo,
            img_so, img_joong, img_geon, img_yeong, img_jang, img_no, img_goyong,
            img_cheong, img_seomin, img_joo, img_search;

    private TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        btn_searchBar = findViewById(R.id.btn_searchBar);
        btn_hambar = findViewById(R.id.btn_hambar);
        btn_jeo = findViewById(R.id.btn_jeo);
        btn_han = findViewById(R.id.btn_han);
        btn_moon = findViewById(R.id.btn_moon);
        btn_imsin = findViewById(R.id.btn_imsin);
        btn_gyo = findViewById(R.id.btn_gyo);
        btn_so = findViewById(R.id.btn_so);
        btn_joong = findViewById(R.id.btn_joong);
        btn_geon = findViewById(R.id.btn_geon);
        btn_yeong = findViewById(R.id.btn_yeong);
        btn_jang = findViewById(R.id.btn_jang);
        btn_no = findViewById(R.id.btn_no);
        btn_goyong = findViewById(R.id.btn_goyong);
        btn_cheong = findViewById(R.id.btn_cheong);
        btn_seomin = findViewById(R.id.btn_seomin);
        btn_joo = findViewById(R.id.btn_joo);

        img_search_ham = findViewById(R.id.img_search_ham);
        img_jeo = findViewById(R.id.img_jeo);
        img_han = findViewById(R.id.img_han);
        img_moon = findViewById(R.id.img_moon);
        img_imsin = findViewById(R.id.img_imsin);
        img_gyo = findViewById(R.id.img_gyo);
        img_so = findViewById(R.id.img_so);
        img_joong = findViewById(R.id.img_joong);
        img_geon = findViewById(R.id.img_geon);
        img_yeong = findViewById(R.id.img_yeong);
        img_jang = findViewById(R.id.img_jang);
        img_no = findViewById(R.id.img_no);
        img_goyong = findViewById(R.id.img_goyong);
        img_cheong = findViewById(R.id.img_cheong);
        img_seomin = findViewById(R.id.img_seomin);
        img_joo = findViewById(R.id.img_joo);
        img_search = findViewById(R.id.img_search);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);









    }
}   