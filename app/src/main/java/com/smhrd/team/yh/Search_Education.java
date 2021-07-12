package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Search_Education extends AppCompatActivity {

    private Button btn_Find_Pre, btn_Find_Ham;
    private ListView SelectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_education);

        //인텐트 받아오기
        Intent intent = getIntent();

        btn_Find_Pre = findViewById(R.id.btn_Find_Pre);
        btn_Find_Ham = findViewById(R.id.btn_Find_Ham);
        SelectView = findViewById(R.id.SelectView);

        //어플 화면 상단 좌측 이전 버튼 & 우측 햄버거 버튼 화면이동 만들기
        btn_Find_Pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Fragment_B.class);
                startActivity(intent1);
            }
        });
        btn_Find_Ham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), hemberger_test.class);
                startActivity(intent2);


            }
        });
    }
}