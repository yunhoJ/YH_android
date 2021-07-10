package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private TextView textView6, login_tv_id, login_tv_pw, login_tv_join;
    private EditText login_edt_id, login_edt_pw;
    private CheckBox login_ck;
    private Button login_btn;
    private View view, view2, view3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView6 = findViewById(R.id.textView6);
        login_tv_id = findViewById(R.id.login_tv_id);
        login_tv_pw = findViewById(R.id.login_tv_pw);
        login_edt_id = findViewById(R.id.login_edt_id);
        login_edt_pw = findViewById(R.id.login_edt_pw);
        login_ck = findViewById(R.id.login_ck);
        login_btn = findViewById(R.id.login_btn);
        view = findViewById(R.id.view);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        login_ck.setChecked(new Boolean(false));
    }
}