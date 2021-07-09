package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
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

        adapter.addQnA("Q1 내가 관심있는 복지혜택을 보고싶은데 어떻게 하면 쉽게 볼 수 있나요?",o); //추가 메소드로 어댑터에 매개변수 넣기
        adapter.addQnA("A1 맞춤정책 메뉴를 터치하면 관심있는 혜택들을 볼 수 있습니다.",o);
        adapter.addQnA("Q2 최신 복지 혜택 알림은 어떻게 해야 받을 수 있나요?",o);
        adapter.addQnA("A2 회원가입시 설정 가능하며 로그인 후 설정에서 맞춤 알림 ON/OFF 설정 가능 합니다.",o);

        qnaListView.setAdapter(adapter); // 리스트뷰에 어댑터 출력

    }
}