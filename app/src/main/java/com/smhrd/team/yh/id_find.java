package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class id_find extends AppCompatActivity {

    private TextView idfind;
    private EditText idfind_phone, idfind_telecom;
    private ImageView img_idfind, img_idfind2, img_idfindham;
    private Button btn_idfind, btn_idfindham, btn_preid;

    private RadioButton SKT, KT, LG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_find);

        idfind = findViewById(R.id.idfind);
        idfind_phone = findViewById(R.id.idfind_phone);
        btn_preid = findViewById(R.id.btn_preid);
        btn_idfindham = findViewById(R.id.btn_idfindham);
        btn_idfind = findViewById(R.id.btn_idfind);

//        btn_idfind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//              idfind_phone = findViewById(R.id.idfind_phone).setOnClickListener(v -> {
//                  //doFindidfind_phone();
//              });
//
//
//              findViewById(R.id.btn_idfind);
//
//
//            }
//        });


    }
}
