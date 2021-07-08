package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class join2 extends AppCompatActivity {

    private TextView txt;
    private EditText txt_id, txt_pw, txt_pw2, txt_birth, txt_sex, txt_phone;
    private ImageView img_psa, img_pre1, img_pre2, img_camera, imgView4;
    private Button btn_photo, btn_ham, btn_pre, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
    }
}