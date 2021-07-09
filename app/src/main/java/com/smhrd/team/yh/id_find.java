package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class id_find extends AppCompatActivity {

    private TextView idfind;
    private EditText idfind_birth, idfind_id, idfind_phone;
    private ImageView img_idfindham, img_idfindpre, img_idfindpre2;
    private Button btn_preid, btn_idfindham, btn_idfind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_find);

        idfind = findViewById(R.id.pwfind);
        idfind_birth = findViewById(R.id.pwfind_birth);
        idfind_phone = findViewById(R.id.pwfind_phone);
        btn_preid = findViewById(R.id.btn_prepw);
        btn_idfindham = findViewById(R.id.btn_pwfindham);
        btn_idfind = findViewById(R.id.btn_pwfind);

        btn_idfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
