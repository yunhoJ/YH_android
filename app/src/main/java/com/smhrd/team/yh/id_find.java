package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class id_find extends AppCompatActivity {

    private TextView idfind;
    private EditText idfind_phone, idfind_telecom;
    private ImageView img_idfind, img_idfind2, img_idfindham;
    private Button btn_idfind, btn_idfindham, btn_preid;

    private RadioButton SKT, KT, LG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_find);

        idfind = findViewById(R.id.idfind);
        idfind_phone = findViewById(R.id.idfind_phone);
        btn_preid = findViewById(R.id.btn_preid);
        btn_idfindham = findViewById(R.id.btn_idfindham);
        btn_idfind = findViewById(R.id.btn_idfind);

        // 어플 화면 상단 좌측 이전 버튼 화면이동
        btn_preid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Login.class);
                startActivity(intent1);
            }
        });
        // 어플 화면 상단 우측 햄버거 버튼 화면이동
        btn_idfindham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), hemberger_test.class);
                startActivity(intent2);
            }
        });

//        btn_idfind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//              idfind_phone = findViewById(R.id.idfind_phone).setOnClickListener(v -> {
//                  //doFindidfind_phone();
//              });
//
//
//              findViewById(R.id.btn_idfind);
//
//
//            }
//        });


    }
}
