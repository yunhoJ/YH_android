package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class pw_find extends AppCompatActivity {

    private TextView pwfind;
    private EditText pwfind_birth, pwfind_id, pwfind_phone;
    private ImageView img_pwfindham, img_pwfindpre, img_pwfind,img_pwfindpre2;
    private Button btn_prepw, btn_pwfindham, btn_pwfind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_find);

        Intent intent = getIntent();

        pwfind = findViewById(R.id.idfind);
        pwfind_birth = findViewById(R.id.pwfind_birth);
        pwfind_phone = findViewById(R.id.idfind_phone);
        btn_prepw = findViewById(R.id.btn_preid);
        btn_pwfindham = findViewById(R.id.btn_idfindham);
        btn_pwfind = findViewById(R.id.btn_idfind);

        btn_pwfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MemberDTo dto =
            }
        });

        // 어플 화면 상단 좌측 이전 버튼 화면이동
        btn_prepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Login.class);
                startActivity(intent1);
            }
        });
        // 어플 화면 상단 우측 햄버거 버튼 화면이동
        btn_pwfindham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), hemberger_test.class);
                startActivity(intent2);
            }
        });
    }
}