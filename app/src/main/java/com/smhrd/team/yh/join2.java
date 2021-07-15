package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

public class join2 extends AppCompatActivity {


    private EditText join2_phone_number,join2_location;
    private ImageView img_psa, img_pre1, img_pre2, img_camera, imgView4;
    private Button  btn_join_ok;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private String value;
    private RadioGroup ra_low_income,ra_single_parent,ra_disabled_person,ra_pregnant,ra_alarm;
   private String low_income,single_parent,disabled_person,pregnant,alarm;
   private NumberPicker join_picker1, join_picker2;
   private String join_area, join_gu;
   private int location;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);

        Intent intent=getIntent();
        MemberDTO s=(MemberDTO) intent.getSerializableExtra("join1");


        join_picker1 = findViewById(R.id.join_picker1);
        join_picker2 = findViewById(R.id.join_picker2);

        LocationCity.initLocationCitys();
        join_picker1.setMaxValue(LocationCity.getLocationCityArrayList().size() - 1);
        join_picker1.setMinValue(0);
        join_picker1.setDisplayedValues(LocationCity.locationcityNames());
        join_picker1.setWrapSelectorWheel(false);

        LocationGu.initLocationGus();

        join_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
        join_picker2.setMinValue(0);
        join_picker2.setDisplayedValues(LocationGu.locationguNames());
        join_picker2.setWrapSelectorWheel(false);

        join_picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(newVal == 0){
                    Log.v("tetet","서울");

                    join_area = "서울";

                    LocationGu.sou();
                    join_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size()-1);
                    join_picker2.setMinValue(0);
                    join_picker2.setDisplayedValues(LocationGu.locationguNames());
                    join_picker2.setWrapSelectorWheel(false);

                } else if(newVal == 1){
                    Log.v("tetet","광주");

                    join_area = "광주";

                    LocationGu.gw();
                    join_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size()-1);
                    join_picker2.setMinValue(0);
                    join_picker2.setDisplayedValues(LocationGu.locationguNames());
                    join_picker2.setWrapSelectorWheel(false);

                }

            }

        });

        join_picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(join_area != null){
                    if(join_area.equals("서울")){
                        Log.v("select_gu", picker.getValue()+1+"");
//                        join_gu = LocationGu.getLocationGu(join_area, picker.getValue());
                        Log.v("s",join_gu);
                        location = picker.getValue()+1;
                    }else if(join_area.equals("광주")){
                        Log.v("select_gu", picker.getValue()+27+"");
//                        join_gu = LocationGu.getLocationGu(join_area, picker.getValue());
                        location = picker.getValue()+27;
                    }

                    Log.v("locationGu", join_gu);
                    Log.v("loc_num",location+"");
                }

            }
        });

        join2_phone_number = findViewById(R.id.join2_phone_number);

        join2_location=findViewById(R.id.join2_location);
        ra_low_income=findViewById(R.id.ra_low_income);
        ra_single_parent=findViewById(R.id.ra_single_parent);
        ra_disabled_person=findViewById(R.id.ra_disabled_person);
        ra_pregnant=findViewById(R.id.ra_pregnent);
        ra_alarm=findViewById(R.id.ra_alarm);


        ra_low_income.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.cb_low_income_Y)
                {
                    low_income="1";
                }
                else
                {
                    low_income="0";
                }
            }
        });
        ra_single_parent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.cb_single_parent_Y)
                {
                   single_parent="1";
                }
                else
                {
                    single_parent="0";
                }

            }
        });

        ra_disabled_person.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.cb_disabled_person_Y)
                {
                    disabled_person="1";
                }
                else
                {
                    disabled_person="0";
                }

            }
        });

        ra_pregnant.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.cb_pregnant_Y)
                {
                    pregnant="1";
                }
                else
                {
                    pregnant="0";
                }

            }
        });

        ra_alarm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.cb_alarm_Y)
                {
                    alarm="Y";
                    Log.v("alarm",alarm);
                }
                else
                {
                    alarm="N";
                    Log.v("alarm",alarm);
                }

            }
        });

        btn_join_ok = findViewById(R.id.btn_join_ok);
        btn_join_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone_number = join2_phone_number.getText().toString();
                String join_location = String.valueOf(location);
                MemberDTO  memberDTO=new MemberDTO(s.getUsers_id(),s.getUsers_pw(),s.getUsers_gender(),s.getUsers_age(),s.getUsers_interesting(),
                  low_income, single_parent, phone_number, disabled_person, pregnant,alarm, join_location);
                Gson gson = new Gson();
               value = gson.toJson(memberDTO);
                Log.v("resultValue", value);

                    sendRequest();

                }
        });


    }


    public void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.234.126:3000/Join";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Server로 부터 데이터를 받아온 곳
                Log.v("resultValue",response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");
                    Log.v("resultValue",value);
                    if(value.equals("ok")){
                        Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent1);
                    }else{
                        Toast.makeText(getApplicationContext(), "회원가입에 실패하셨습니다!!", Toast.LENGTH_SHORT).show();
//                        join2_low_income.setText("");
//                        join2_single_parent.setText("");
//                        join2_phone_number.setText("");
//                        join2_disabled_person.setText("");
//                        join2_pregnant_women.setText("");
//                        join2_alarm.setText("");
//                        join2_location.setText("");
//
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
//

                return params;
            }
        };
        queue.add(stringRequest);
    }
}