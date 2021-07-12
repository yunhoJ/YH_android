package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.util.Map;

public class Search_Child extends AppCompatActivity {

    private ListView SelectView;
    private Button btn_Find_Pre, btn_Find_Ham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_culture);
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

                // Fragment_B 에서 가져오고싶은데 어댑터 에러나서 못함 ㅠ.ㅠ ★내일 완성하기

            }
        });

    }
}