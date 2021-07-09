package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

public class join2 extends AppCompatActivity {

    private TextView txt;
    private EditText join2_low_income, join2_single_parent, join2_phone_number, join2_disabled_person, join2_pregnant_women, join2_alarm, join2_location;
    private ImageView img_psa, img_pre1, img_pre2, img_camera, imgView4;
    private Button btn_photo, btn_ham, btn_pre, btn_join_ok;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);

        Intent intent=getIntent();
        MemberDTO s=(MemberDTO) intent.getSerializableExtra("join1");



        join2_low_income = findViewById(R.id.join2_low_income);
        join2_single_parent = findViewById(R.id.join2_single_parent);
        join2_phone_number = findViewById(R.id.join2_phone_number);
        join2_disabled_person = findViewById(R.id.join2_disabled_person);
        join2_pregnant_women = findViewById(R.id.join2_pregnant_women);
        join2_alarm = findViewById(R.id.join2_alarm);
        join2_location = findViewById(R.id.join2_location);
        btn_join_ok = findViewById(R.id.btn_join_ok);

        btn_join_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String low_income = join2_low_income.getText().toString();
                String single_parent = join2_single_parent.getText().toString();
                String phone_number = join2_phone_number.getText().toString();
                String disabled_person = join2_disabled_person.getText().toString();
                String pregnant_women = join2_pregnant_women.getText().toString();
                String alarm = join2_alarm.getText().toString();
                String locaiton = join2_location.getText().toString();

                MemberDTO  memberDTO=new MemberDTO(s.getUsers_id(),s.getUsers_pw(),s.getUsers_gender(),s.getUsers_age(),s.getUsers_interesting(),
                  low_income, single_parent, phone_number, disabled_person, pregnant_women,alarm, locaiton);

//                MemberDTO dto = new MemberDTO(low_income, single_parent, phone_number, disabled_person, pregnant_women,alarm, locaiton);
                Gson gson = new Gson();
               value = gson.toJson(memberDTO);
                Log.v("resultValue", value);
//                PreferenceManager.setString(getApplicationContext(),"info",value);
                    sendRequest();

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
    public void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.234.126:3000/Join";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Server로 부터 데이터를 받아온 곳
                Log.v("resultValue",response);

//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    String value = jsonObject.getString("check");
//                    Log.v("resultValue",value);
//                    if(value.equals("true")){
//                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(getApplicationContext(), "회원가입에 실패하셨습니다!!", Toast.LENGTH_SHORT).show();
//                        join2_low_income.setText("");
//                        join2_single_parent.setText("");
//                        join2_phone_number.setText("");
//                        join2_disabled_person.setText("");
//                        join2_pregnant_women.setText("");
//                        join2_alarm.setText("");
//                        join2_location.setText("");
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Server 통신시 Error발생 하면 오는 곳
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Server로 데이터를 보낼 시 넣어주는 곳
                // alt + shift + r 한꺼번에 바꿀 수 있다.
                Map<String,String> params = new HashMap<String, String>();
                try {


                    JSONObject jsonObject = new JSONObject(value);
                    params.put("id",jsonObject.getString("users_id"));
                    params.put("pw",jsonObject.getString("users_pw"));
                    params.put("gender",jsonObject.getString("users_gender"));
                    params.put("age",jsonObject.getString("users_age"));
                    params.put("interesting",jsonObject.getString("users_interesting"));
                    params.put("low_income",jsonObject.getString("users_income"));
                    params.put("single_parent",jsonObject.getString("users_single_parent"));
                    params.put("phone_number",jsonObject.getString("users_phone_number"));
                    params.put("disabled_person",jsonObject.getString("users_disabled_person"));
                    params.put("pregnant_women",jsonObject.getString("users_pregnant_women"));
                    params.put("alarm",jsonObject.getString("users_alaram"));
                    params.put("location",jsonObject.getString("location_no"));
                    Log.v("users_id",jsonObject.getString("users_id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                params.put(MemberDTO..getText().toString());
//                params.put("pw",join_pw.getText().toString());
//                params.put("gender",join_gender.getText().toString());
//                params.put("age",join_age.getText().toString());
//                params.put("interesting",join_interesting.getText().toString());
                Log.v("params2",params+"");

                return params;
            }
        };
        queue.add(stringRequest);
    }
}