package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.Gson;

public class UserInfoChange extends AppCompatActivity{

    private Button btn_change_photo,btn_pw_check, btn_infoChange_next;
    private TextView tv_change_id;
    private EditText edt_change_pw, edt_change_pw2, edt_phoneNumber;
    private Switch switch_alarm;
    private RadioGroup change_gender;
    private String users_gender;
    private ImageView ivMenu;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ImageView btn_back;
    private String users_change_gender, change_phone_number,  change_alaram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_change);

        Intent intent = getIntent(); //설정 Fragment에서 intent로 받아오기

        btn_change_photo = findViewById(R.id.btn_chage_photo);
        btn_infoChange_next = findViewById(R.id.btn_infoChange_finish);
        tv_change_id = findViewById(R.id.tv_change_comm);
        edt_change_pw = findViewById(R.id.edt_change_pw);
        edt_change_pw2 = findViewById(R.id.edt_change_pw2);
        btn_pw_check = findViewById(R.id.btn_pw_check);
        edt_phoneNumber = findViewById(R.id.edt_phoneNumber);
        switch_alarm = findViewById(R.id.switch_alarm);

        change_gender = findViewById(R.id.change_gender);

        ivMenu = findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        btn_back = findViewById(R.id.btn_back);

        setSupportActionBar(toolbar);

        switch_alarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    change_alaram = "Y";
                    Log.v("checked","Y");
                }else{
                    change_alaram = "N";
                    Log.v("checked","N");
                }

            }
        });


        change_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.M) {
                    users_change_gender = "M";
                    Log.v("gender","M");
                } else {
                    users_change_gender = "F";
                    Log.v("gender","F");
                }
            }
        });


        btn_change_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent1,129);

            }
        });

        btn_infoChange_next.setOnClickListener(new View.OnClickListener() { //UserInfoChange2로 가는 버튼메소드 생성
            @Override
            public void onClick(View v) {
                String users_id = tv_change_id.getText().toString();
                String users_pw = edt_change_pw.getText().toString();
                String users_pw2 = edt_change_pw2.getText().toString();
                String change_phone_number = edt_phoneNumber.getText().toString();

                if(users_pw.equals(users_pw2)){

                    MemberDTO dto = new MemberDTO(users_id, users_pw, users_pw2, users_change_gender, change_phone_number, change_alaram);
                    Gson gson = new Gson();
                    String value = gson.toJson(dto);
                    Log.v("resultValue", value);

                    Intent intent = new Intent(getApplicationContext(), UserInfoChange2.class);
                    intent.putExtra("change1", dto);
                    startActivity(intent); // UserInfoChange2클래스로 이동
                }

            }
        });

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