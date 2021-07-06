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

        noticeListView = findViewById(R.id.noticeListView);
        Intent intent = getIntent();

        NoticeAdapter adapter = new NoticeAdapter();
        adapter.addNotice("2021년 보육료·유아 학비 사전신청안내","2021 - 06 - 05");
        adapter.addNotice("추가추가","날짜 날짜");



        noticeListView.setAdapter(adapter);
    }
}