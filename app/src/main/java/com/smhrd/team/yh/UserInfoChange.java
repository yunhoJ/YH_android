package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UserInfoChange extends AppCompatActivity {
    Button btn_infoChange_next;

    private ImageView ivMenu;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ImageView btn_back;

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

        ivMenu = findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        btn_back = findViewById(R.id.btn_back);



        setSupportActionBar(toolbar);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu ) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_item, menu);

        return false;
    }
}