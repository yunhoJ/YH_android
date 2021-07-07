package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Join extends AppCompatActivity {

    private EditText txt_id, txt_pw, txt_pw2, txt_birth, txt_sex, txt_phone;
    private ImageView imageView2, imageView3, imageView4, imageView5, imageView6;
    private Button btn_photo, btn_ham, btn_pre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        txt_id = findViewById(R.id.txt_id);
    }
}