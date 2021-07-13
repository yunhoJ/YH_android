package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Join extends AppCompatActivity  {

    private TextView tv_age;
    private EditText join_id, join_pw, join_pw2, edit;
    private Button btn_photo, btn_ham, btn_pre, btn_next;
    private NumberPicker join_age_picker;
    private RadioGroup ra_gender, ra_like;
    private String users_age, users_interesting, users_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_id = findViewById(R.id.join_id);
        join_pw = findViewById(R.id.join_pw);
        join_pw2 = findViewById(R.id.join_pw2);
        btn_photo = findViewById(R.id.btn_photo);
        btn_next = findViewById(R.id.btn_join_ok);
        join_age_picker = findViewById(R.id.join_age_picker);
        tv_age = findViewById(R.id.tv_age);
        ra_gender = findViewById(R.id.ra_gender);
        ra_like = findViewById(R.id.ra_like);

        EditText edit = new EditText(this);
        edit.setWidth(200);
        edit.setText("", TextView.BufferType.NORMAL);
        edit.setPadding(10, 10, 10, 10);


        ra_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.cb_men) {
                    users_gender = "M";
                } else {
                    users_gender = "F";
                }

            }
        });

        ra_like.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.cb_health) {
                    Log.v("ra_like", "건강");
                    users_interesting = "health";
                } else if (checkedId == R.id.cb_education) {
                    Log.v("ra_like", "교육");
                    users_interesting = "education";
                } else if (checkedId == R.id.cb_hire) {
                    Log.v("ra_like", "고용 ");
                    users_interesting = "hire";
                } else if (checkedId == R.id.cb_home) {
                    Log.v("ra_like", "주거");
                    users_interesting = "home";
                } else {
                    Log.v("ra_like", "문화");
                    users_interesting = "culture";
                }
            }
        });


        join_age_picker.setMaxValue(100);
        join_age_picker.setMinValue(0);
        join_age_picker.setValue(10);
        join_age_picker.setWrapSelectorWheel(false);
        join_age_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if (newVal < 5) {
                    tv_age.setText("영유아");
                    users_age = "1";
                } else if (newVal < 19) {
                    tv_age.setText("아동,청소년");
                    users_age = "5";
                } else if (newVal < 35) {
                    tv_age.setText("청년");
                    users_age = "19";
                } else if (newVal < 65) {
                    tv_age.setText("중장년");
                    users_age = "35";
                } else {
                    tv_age.setText("노년");
                    users_age = "65";
                }
            }
        });


//        btn_photo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 회원가입할때 프사(img_psa)에 사진찍어서넣기
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, 128);
//                Log.v("resultValue", "click");
//
//            }
//
//            public void doTakeAlbumAction() {
////               // 회원가입할때 프사(img_psa)에 카메라앨범에서넣기
//                // 그냥 실제로는 카메라앨범에서 넣는것만 가능하게 만들거임 혹시안될까봐
//                // 2개만듬
//                Intent intent1 = new Intent(Intent.ACTION_PICK);
//                intent1.setType(MediaStore.Images.Media.CONTENT_TYPE);
//                startActivityForResult(intent1, 128);
//
//            }
//
//        });


        // next 다음버튼 눌러서 회원가입 2번째 창으로 넘어가기
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users_id = join_id.getText().toString();
                String users_pw = join_pw.getText().toString();
                String users_pw2 = join_pw2.getText().toString();

                if (users_pw.equals(users_pw2)) {
                    MemberDTO dto = new MemberDTO(users_id, users_pw, users_gender, users_age, users_interesting);
                    Gson gson = new Gson();
                    String value = gson.toJson(dto);
                    Log.v("resultValue", value);

                    Intent intent = new Intent(getApplicationContext(), join2.class);
                    intent.putExtra("join1", dto);
                    startActivity(intent);

                }
            }
        });



    }
}