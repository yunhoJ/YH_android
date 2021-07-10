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

public class Join extends AppCompatActivity {

    private TextView txt, tv_age;
    private EditText join_id, join_pw, join_pw2, join_gender, join_age, join_interesting;
    private ImageView img_psa, img_pre1, img_pre2, img_camera, imgView4;
    private Button btn_photo, btn_ham, btn_pre, btn_next;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private NumberPicker join_age_picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_id = findViewById(R.id.join_id);
        join_pw = findViewById(R.id.join_pw);
       // join_pw2 = findViewById(R.id.join_pw2);
       // join_gender = findViewById(R.id.join_gender);
        join_age = findViewById(R.id.join_age);
        join_interesting = findViewById(R.id.join_interesting);
        img_psa = findViewById(R.id.img_psa);
        img_pre1 = findViewById(R.id.img_pre1);
        img_pre2 = findViewById(R.id.img_pre2);
        img_camera = findViewById(R.id.img_camera);
        imgView4 = findViewById(R.id.imageView4);
        btn_photo = findViewById(R.id.btn_photo);
        btn_ham = findViewById(R.id.btn_ham);
        btn_pre = findViewById(R.id.btn_pre);
        btn_next = findViewById(R.id.btn_join_ok);

        join_age_picker = (NumberPicker) findViewById(R.id.join_age_picker);
        tv_age = (TextView) findViewById(R.id.tv_age);

        join_age_picker.setMaxValue(100);
        join_age_picker.setMinValue(0);
        join_age_picker.setValue(10);
        join_age_picker.setWrapSelectorWheel(false);

        join_age_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(newVal < 2){
                    tv_age.setText("영유아");
                }else if(newVal <20){
                    tv_age.setText("아동");
                }else if(newVal <35){
                    tv_age.setText("청년");
                }else if(newVal <51){
                    tv_age.setText("중장년");
                }else{
                    tv_age.setText("노년");
                }
            }
        });


        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입할때 프사(img_psa)에 사진찍어서넣기
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 128);
                Log.v("resultValue", "click");

            }
            public void doTakeAlbumAction(){
//               // 회원가입할때 프사(img_psa)에 카메라앨범에서넣기
                // 그냥 실제로는 카메라앨범에서 넣는것만 가능하게 만들거임 혹시안될까봐
                // 2개만듬
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent1, 128);

            }

        });


        btn_ham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), hamburger.class);
                intent.putExtra("data", "join");
                startActivityForResult(intent, 1004);
                // 햄버거 페이지 넘어가게하기 페이지없다그럤는데 우선 이렇게 만듬
            }
        });


        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, 2000);
                // 이전 메인화면으로 돌아가기
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = join_id.getText().toString();
                String pw = join_pw.getText().toString();
                //String pw2 = join_pw2.getText().toString();
                String gender = join_gender.getText().toString();
                String age = join_age.getText().toString();
                String interesting = join_interesting.getText().toString();
                // 유저 정보 보내기


//                intent.putExtra("user", "user");
//                startActivityForResult(intent, 1004);

                // next 다음버튼 눌러서 회원가입 2번째 창으로 넘어가기

                MemberDTO dto = new MemberDTO(id, pw, gender, age, interesting);
//                Gson gson = new Gson();
//                String value = gson.toJson(dto);
//                Log.v("resultValue", value);
                //PreferenceManager.setString(getApplicationContext(),"info",value);
                Intent intent = new Intent(getApplicationContext(),join2.class);
                intent.putExtra("join1",dto);
                startActivity(intent);


            }
        });


    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 128 && resultCode == RESULT_OK) ;
//        Bundle bundle = data.getExtras();
//        Bitmap bitmap = (Bitmap) bundle.get("data");
//        img_psa.setImageBitmap(bitmap);
//        // 회원가입할때 프사(img_psa) btn_photo 클릭에 사진촬영해서넣기
//    }
//    public void sendRequest() {
//        queue = Volley.newRequestQueue(this);
//        String url = "http://59.0.234.126:3000/Join";
//        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                // Server로 부터 데이터를 받아온 곳
//                //Log.v("resultValue",response);
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    String value = jsonObject.getString("check");
//                   // Log.v("resultValue",value);
//                    if(value.equals("ok")){
//                    }else{
//                        Toast.makeText(getApplicationContext(), "회원가입에 실패하셨습니다!!", Toast.LENGTH_SHORT).show();
//                        join_id.setText("");
//                        join_pw.setText("");
//                       // join_pw2.setText("");
//                        join_gender.setText("");
//                        join_age.setText("");
//                        join_interesting.setText("");
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // Server 통신시 Error발생 하면 오는 곳
//                error.printStackTrace();
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                // Server로 데이터를 보낼 시 넣어주는 곳
//                // alt + shift + r 한꺼번에 바꿀 수 있다.
//                Map<String,String> params = new HashMap<String, String>();
//                JSONObject jsonObject = new JSONObject();
//                params.put("id",join_id.getText().toString());
//                params.put("pw",join_pw.getText().toString());
//                params.put("gender",join_gender.getText().toString());
//                params.put("age",join_age.getText().toString());
//                params.put("interesting",join_interesting.getText().toString());
////                Log.v("params",params+"");
//                return params;
//            }
//        };
//        queue.add(stringRequest);
//    }
}