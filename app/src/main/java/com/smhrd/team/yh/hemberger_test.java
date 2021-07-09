package com.smhrd.team.yh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class hemberger_test extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    private ImageView ivMenu;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ImageView btn_back;
    private Button hamberger_btn_join;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemberger_test);


//        Toolbar toolbar=findViewById(R.id.toolbar);

        ivMenu = findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        btn_back = findViewById(R.id.btn_back);
        hamberger_btn_join = findViewById(R.id.hanberger_btn_join);


        setSupportActionBar(toolbar);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 클릭됨");
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setDisplayShowCustomEnabled(true);//커스텀 마이징 하기위한 코드
//
//        actionBar.setDisplayShowTitleEnabled(false);// 제목
//        actionBar.setDisplayHomeAsUpEnabled(true);//뒤로가기 버튼
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_chevron_left_24);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu ) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_item, menu);

        return false;
    }





//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        Log.v(TAG, "뭘 선택했지"+item);
//
//        switch (item.getItemId()) {
//            case R.id.hamberger_notice: {
//                Log.v(TAG, "로그인 클릭");
//                break;
//            }
//            case R.id.hanberger_btn_join: {
//                Log.v(TAG, "조인버튼 클릭");
//                break;
//            }
//            case R.id.btn_back:
//
//                finish();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}


