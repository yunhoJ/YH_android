package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserInfoChange extends AppCompatActivity {
    Button btn_infoChange_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_change);

        Intent intent = getIntent(); //설정 Fragment에서 intent로 받아오기

        btn_infoChange_next = findViewById(R.id.btn_infoChange_finish);

        btn_infoChange_next.setOnClickListener(new View.OnClickListener() { //UserInfoChange2로 가는 버튼메소드 생성
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),UserInfoChange2.class);
                startActivity(intent1); // UserInfoChange2클래스로 이동
            }
        });
    }
}