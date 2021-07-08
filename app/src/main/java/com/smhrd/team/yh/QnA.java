package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class QnA extends AppCompatActivity {
    private ListView qnaListView;
    private Button o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qna);

        Intent intent = getIntent();

        qnaListView = findViewById(R.id.qnaListView);
        o = findViewById(R.id.btn_open);
        QnAadapter adapter = new QnAadapter();

        adapter.addQnA("Q 내가 관심있는 복지혜택을 보고싶은데 어떻게 하면 쉽게 볼 수 있나요?",o);
        adapter.addQnA("Q 최신 복지 혜택 알림은 어떻게 해야 받을 수 있나요?",o);

        qnaListView.setAdapter(adapter);
    }
}