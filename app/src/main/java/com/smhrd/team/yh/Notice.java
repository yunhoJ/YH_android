package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Notice extends AppCompatActivity {
    private ListView noticeListView;    //리스트뷰 변수 정의
    private Button btn_notice_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        Intent intent = getIntent(); //Fragment 에서 intent로 받아오기

        btn_notice_back = findViewById(R.id.btn_notice_back);
        noticeListView = findViewById(R.id.noticeListView);

        NoticeAdapter adapter = new NoticeAdapter();    //NoticeAdapter 타입 adapter변수로 초기화
        adapter.addNotice("2021년 보육료·유아 학비 사전신청안내","2021 - 06 - 05");  // 어탭터에 출력할 매개변수 입력
        adapter.addNotice("2021년 생계급여 부양의무자 폐지 대상 안내","2021 - 06 - 03");


        noticeListView.setAdapter(adapter); //noticeListView에 어탭터로 화면에 출력

        btn_notice_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}