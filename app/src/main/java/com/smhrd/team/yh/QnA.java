package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class QnA extends AppCompatActivity {
    private ListView qnaListView;
    private Button o;  //버튼 변수 정의

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qna);

        Intent intent = getIntent(); //Fragment에서 intent로 받아오기

        qnaListView = findViewById(R.id.qnaListView);
        o = findViewById(R.id.btn_open);      //  버튼 변수에 아이디값으로 가져오기
        QnAadapter adapter = new QnAadapter();  // 어댑터 초기화

        adapter.addQnA("Q 내가 관심있는 복지혜택을 보고싶은데 어떻게 하면 쉽게 볼 수 있나요?",o); //추가 메소드로 어댑터에 매개변수 넣기
        adapter.addQnA("Q 최신 복지 혜택 알림은 어떻게 해야 받을 수 있나요?",o);

        qnaListView.setAdapter(adapter); // 리스트뷰에 어댑터 출력
    }
}