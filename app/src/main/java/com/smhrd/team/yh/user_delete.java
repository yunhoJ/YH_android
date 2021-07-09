package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class user_delete extends AppCompatActivity {
    private TextView user_delete;
    private EditText userdelete_id, userdelete_birth, userdelete_phone;
    private ImageView img_userdelete1, img_userdelete2, img_userdelete3;
    private Button btn_userdelete, btn_userdeleteham, btn_userdeletepre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_delete);

        Intent intent = getIntent();

        user_delete = findViewById(R.id.user_delete);
        userdelete_id = findViewById(R.id.userdelete_id);
        userdelete_birth = findViewById(R.id.userdelete_birth);
        userdelete_phone = findViewById(R.id.userdelete_phone);
        img_userdelete1 = findViewById(R.id.img_userdelete1);
        img_userdelete2 = findViewById(R.id.img_userdelete2);
        img_userdelete3 = findViewById(R.id.img_userdelete3);
        btn_userdeleteham = findViewById(R.id.btn_userdeleteham);
        btn_userdeletepre = findViewById(R.id.btn_userdeletepre);
        btn_userdelete = findViewById(R.id.btn_userdelete);
        btn_userdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MemberDTO dto = new MemberDTO

            }
        });




    }
}