package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class join2 extends AppCompatActivity {

    private TextView txt, main_join;
    private EditText txt_im, txt_han, txt_jang, txt_so, txt_gwan, txt_ji;
    private ImageView img_psa, img_pre1, img_pre2, img_camera, imgView4;
    private Button btn_photo, btn_ham, btn_pre, btn_join;
    private CheckBox cb_im, cb_han, cb_jang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        txt = findViewById(R.id.txt);
        main_join = findViewById(R.id.main_join);
        txt_im = findViewById(R.id.txt_im);
        txt_han = findViewById(R.id.txt_han);
        txt_jang = findViewById(R.id.txt_jang);
        txt_so = findViewById(R.id.txt_so);
        txt_gwan = findViewById(R.id.txt_gwan);
        txt_ji = findViewById(R.id.txt_ji);
        img_camera = findViewById(R.id.img_camera);
        img_pre1 = findViewById(R.id.img_pre1);
        img_pre2 = findViewById(R.id.img_pre2);
        img_camera = findViewById(R.id.img_camera);
        imgView4 = findViewById(R.id.imageView4);
        cb_han = findViewById(R.id.cb_han);
        cb_im = findViewById(R.id.cb_im);
        cb_jang = findViewById(R.id.cb_jang);
        btn_ham = findViewById(R.id.btn_ham);
        btn_pre = findViewById(R.id.btn_pre);
        btn_join = findViewById(R.id.btn_join);


        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btn_ham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MemberDTO

            }
        });



    }
}