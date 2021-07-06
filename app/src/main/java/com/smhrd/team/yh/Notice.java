package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class Notice extends AppCompatActivity {
    private ListView noticeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        Intent intent = getIntent();

        noticeListView = findViewById(R.id.noticeListView);

        NoticeAdapter adapter = new NoticeAdapter();
        adapter.addNotice("2021년 보육료·유아 학비 사전신청안내","2021 - 06 - 05");
        adapter.addNotice("2021년 생계급여 부양의무자 폐지 대상 안내","2021 - 06 - 03");



        noticeListView.setAdapter(adapter);
    }
}