package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserInfoChange2 extends AppCompatActivity {
    private Button btn_infoChange_finish;
    private CheckBox cb_fragnant, cb_singleParent, cb_disabled_person, cb_income;
    private NumberPicker interesting_picker, location_city_picker, location_gu_picker; //picker 변수정의
    private String change_fragnant, change_singleParent, change_disabled_person, change_income;
    private String change_interesting, change_city, change_gu, change_location, value;
    private RequestQueue queue;
    private StringRequest stringRequest;

    private String select_area;
    private String select_gu;
    private String select_interesting;
    private int c_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_change2);
        Intent intent = getIntent(); // UserInfoChange 클래스에서 intent로 받아옴

        MemberDTO c = (MemberDTO)intent.getSerializableExtra("change1");

        cb_fragnant = findViewById(R.id.cb_fragnant);
        cb_singleParent = findViewById(R.id.cb_singleParent);
        cb_disabled_person = findViewById(R.id.cb_disabled_person);
        cb_income=findViewById(R.id.cb_income);
        btn_infoChange_finish = findViewById(R.id.btn_infoChange_finish);

        cb_fragnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_fragnant.isChecked()){
                    change_fragnant = "1";
                    Log.v("checked","Y");
                }else {
                    change_fragnant = "0";
                    Log.v("checked","N");
                }
            }
        });

        cb_singleParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_singleParent.isChecked()){
                    change_singleParent = "1";
                }else {
                    change_singleParent = "0";
                }
            }
        });

        cb_disabled_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_disabled_person.isChecked()){
                    change_disabled_person = "1";
                }else {
                    change_disabled_person = "0";
                }
            }
        });

        cb_income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_income.isChecked()){
                    change_income = "1";
                }else {
                    change_income = "0";
                }
            }
        });


        btn_infoChange_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                change_location = String.valueOf(c_location);

                MemberDTO  memberDTO =new MemberDTO(c.getUsers_id(), c.getUsers_pw(), c.getUsers_gender(), change_interesting, change_income,
                        change_singleParent, c.getUsers_phone_number(), change_disabled_person, change_fragnant, c.getUsers_alaram(), change_location);
                Gson gson = new Gson();
                value = gson.toJson(memberDTO);
                Log.v("resultValue", value);

                sendRequest();

            }
        });

        //id로 pciker 찾아주기
        interesting_picker = findViewById(R.id.interesting_picker);
        location_city_picker = findViewById(R.id.area_picker1);
        location_gu_picker = findViewById(R.id.location_gu_picker);


        LocationCity.initLocationCitys();
        location_city_picker.setMaxValue(LocationCity.getLocationCityArrayList().size() - 1);
        location_city_picker.setMinValue(0);
        location_city_picker.setDisplayedValues(LocationCity.locationcityNames());
        location_city_picker.setWrapSelectorWheel(false);

        LocationGu.initLocationGus();

        location_gu_picker.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
        location_gu_picker.setMinValue(0);
        location_gu_picker.setDisplayedValues(LocationGu.locationguNames());
        location_gu_picker.setWrapSelectorWheel(false);

        //Interesting 클래스에서 초기화한 리스트를 가져옴
        Interesting.initInterestings();
        //interesting_picker 보여줄 값 입력
        interesting_picker.setMaxValue(Interesting.getInterestingArrayList().size() - 1);
        interesting_picker.setMinValue(0);
        interesting_picker.setDisplayedValues(Interesting.interestingNames());
        interesting_picker.setWrapSelectorWheel(false);


        interesting_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(newVal == 0){
                    Log.v("pick",picker.getValue()+"");
                    change_interesting = Interesting.getInteresting(select_interesting,picker.getValue());
                    Log.v("intrs",change_interesting);
                    change_interesting = "education";
                    Log.v("rn",change_interesting);
                }else if (newVal == 1){
                    change_interesting = Interesting.getInteresting(select_interesting,picker.getValue());
                    change_interesting = "hire";
                    Log.v("rn",change_interesting);
                }else if (newVal == 2){
                    change_interesting = Interesting.getInteresting(select_interesting,picker.getValue());
                    change_interesting = "home";
                    Log.v("rn",change_interesting);
                }else if (newVal == 3){
                    change_interesting = Interesting.getInteresting(select_interesting,picker.getValue());
                    change_interesting = "health";
                    Log.v("rn",change_interesting);
                }else if (newVal == 4){
                    change_interesting = Interesting.getInteresting(select_interesting,picker.getValue());
                    change_interesting = "culture";
                    Log.v("rn",change_interesting);
                }
            }
        });


        // 도시 location_city_picker, 구 location_gu_picker

        location_city_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
               if(newVal == 1){

                   select_area = "서울";

                   Log.v("tetet","서울");
                   LocationGu.sou();
                   location_gu_picker.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                   location_gu_picker.setMinValue(0);
                   location_gu_picker.setDisplayedValues(LocationGu.locationguNames());
                   location_gu_picker.setWrapSelectorWheel(false);

                   } else if(newVal == 2){
                    Log.v("tetet","광주");

                   select_area = "광주";

                   LocationGu.gw();
                   location_gu_picker.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                   location_gu_picker.setMinValue(0);
                   location_gu_picker.setDisplayedValues(LocationGu.locationguNames());
                   Log.v("location",LocationGu.locationguNames()+"");


                   location_gu_picker.setWrapSelectorWheel(false);
               }else if(newVal == 0){
                   select_area = "시";
                   LocationGu.initLocationGus();
                   location_gu_picker.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                   location_gu_picker.setMinValue(1);
                   location_gu_picker.setDisplayedValues(null);
                   location_gu_picker.setWrapSelectorWheel(false);
               }

            }
        });

        location_gu_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {


                if(select_area != null){
                    if(select_area.equals("서울")){
                        Log.v("select_gu", picker.getValue()+1+"");
                        select_gu = LocationGu.getLocationGu(select_area, picker.getValue());
                        Log.v("s",select_gu);
                        c_location = picker.getValue()+1;
                    }else if(select_area.equals("광주")){
                        Log.v("select_gu", picker.getValue()+27+"");
                        select_gu = LocationGu.getLocationGu(select_area, picker.getValue());
                        c_location = picker.getValue()+27;
                    }

                    Log.v("locationGu", select_gu);
                }

            }
        });

    }

    private void sendRequest() {
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
                        Toast.makeText(getApplicationContext(), "회원수정에 실패하셨습니다!!", Toast.LENGTH_SHORT).show();
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