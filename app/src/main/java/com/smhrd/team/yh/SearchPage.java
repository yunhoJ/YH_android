package com.smhrd.team.yh;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SearchPage extends AppCompatActivity {

    private Button btn_pregnant, btn_child, btn_teenager, btn_youth, btn_middle_Age,
            btn_old_Age, btn_disabled, btn_single_Parent, btn_low_Income, btn_health,
            btn_education, btn_employ, btn_dwelling, btn_microfinance, btn_culture,
            btn_search_HamBar;
    private String search_pregnant, search_child, search_teenager, search_youth, search_middle_age, search_old_age;
    private String search_disabled, search_single_parent, search_low_income, search_health, search_education;
    private String search_employ, search_dwelling, search_culture;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private NumberPicker area_picker1, area_picker2; //picker 변수정의
    private TextView tv_area, tv1, tv2, tv3, tv4, tv5;
    private String search_area, search_gu;
    private int search_location;
    private String val;
    private HomePolisyAdapter adapter = new HomePolisyAdapter();
    private View fragment;
    private ListView search_ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        Intent intent = getIntent();



        btn_pregnant = findViewById(R.id.btn_pregnant);
        btn_child = findViewById(R.id.btn_child);
        btn_teenager = findViewById(R.id.btn_teenager);
        btn_youth = findViewById(R.id.btn_youth);
        btn_middle_Age = findViewById(R.id.btn_middle_Age);
        btn_old_Age = findViewById(R.id.btn_old_Age);
        btn_disabled = findViewById(R.id.btn_disabled);
        btn_single_Parent = findViewById(R.id.btn_single_Parent);
        btn_low_Income = findViewById(R.id.btn_low_Income);
        btn_health = findViewById(R.id.btn_health);
        btn_education = findViewById(R.id.btn_education);
        btn_employ = findViewById(R.id.btn_employ);
        btn_dwelling = findViewById(R.id.btn_dwelling);
        btn_microfinance = findViewById(R.id.btn_microfinance);
        btn_culture = findViewById(R.id.btn_culture);
        btn_search_HamBar = findViewById(R.id.btn_search_HamBar);

        tv_area = findViewById(R.id.tv_area);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);


        area_picker1 = findViewById(R.id.area_picker1);
        area_picker2 = findViewById(R.id.area_picker2);

        LocationCity.initLocationCitys();
        area_picker1.setMaxValue(LocationCity.getLocationCityArrayList().size() - 1);
        area_picker1.setMinValue(0);
        area_picker1.setDisplayedValues(LocationCity.locationcityNames());
        area_picker1.setWrapSelectorWheel(false);

        LocationGu.initLocationGus();
        area_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
        area_picker2.setMinValue(0);
        area_picker2.setDisplayedValues(LocationGu.locationguNames());
        area_picker2.setWrapSelectorWheel(false);

        area_picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(newVal == 1){
                    Log.v("tetet","서울");

                    search_area = "서울";
                    LocationGu.sou();
                    area_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                    area_picker2.setMinValue(0);
                    area_picker2.setDisplayedValues(LocationGu.locationguNames());
                    area_picker2.setWrapSelectorWheel(false);

                } else if(newVal == 2){
                    Log.v("tetet","광주");

                    search_area = "광주";
                    LocationGu.gw();
                    area_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                    area_picker2.setMinValue(0);
                    area_picker2.setDisplayedValues(LocationGu.locationguNames());
                    area_picker2.setWrapSelectorWheel(false);


                }else if(newVal == 0){
                    search_area = "시";
                    Interesting.initInterestings();
                    area_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                    area_picker2.setMinValue(0);
                    area_picker2.setDisplayedValues(null);
                    area_picker2.setWrapSelectorWheel(false);
                }

            }
        });

        area_picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(search_area != null){
                    if(search_area.equals("서울")){
                        Log.v("select_gu", picker.getValue()+1+"");
                        search_gu = LocationGu.getLocationGu(search_area, picker.getValue());
                        Log.v("s",search_gu);
                        search_location = picker.getValue()+1;
                    }else if(search_area.equals("광주")){
                        Log.v("select_gu", picker.getValue()+27+"");
                        search_gu = LocationGu.getLocationGu(search_area, picker.getValue());
                        search_location = picker.getValue()+27;
                    }
                    Log.v("locationGu", search_gu);
                     Log.v("loc_num",search_location+"");
                }
            }
        });

        btn_pregnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_pregnant = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_pregnant);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("preg",val);
                sendRequest();
                Intent intent1 = new Intent(getApplicationContext(),Fragment_B.class);

            }
        });

        btn_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_child = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_child);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("child",val);
                sendRequest();
            }
        });

        btn_teenager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_teenager = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_teenager);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("teen",val);
                sendRequest();
            }
        });

        btn_youth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_youth = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_youth);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("youth",val);
                sendRequest();
            }
        });

        btn_middle_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_middle_age = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_middle_age);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("middle",val);
                sendRequest();
            }
        });

        btn_old_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_old_age = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_old_age);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("old",val);
                sendRequest();
            }
        });

        btn_disabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_disabled = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_disabled);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("disabled",val);
                sendRequest();
            }
        });

        btn_single_Parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_single_parent = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_single_parent);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("single",val);
                sendRequest();
            }
        });

        btn_low_Income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_low_income = "1";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_low_income);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("low",val);
                sendRequest();
            }
        });

        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_health = "health";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_health);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("health",val);
                sendRequest();
            }
        });

        btn_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_education = "education";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_education);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("edu",val);
                sendRequest();
            }
        });

        btn_employ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_employ = "hire";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_employ);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("emp",val);
                sendRequest();
            }
        });

        btn_dwelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_dwelling = "home";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_dwelling);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("home",val);
                sendRequest();
            }
        });

        btn_culture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_culture = "culture";
                String location = String.valueOf(search_location);
                SearchPageDTO searchPageDTO = new SearchPageDTO(location, search_culture);
                Gson gson = new Gson();
                val = gson.toJson(searchPageDTO);
                Log.v("culture",val);
                sendRequest();
            }
        });

    }

    public void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.234.126:3000/Search";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Server로 부터 데이터를 받아온 곳
                Log.v("resultValue",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                        String policy_name=jsonObject.getString("policy_name");
                        String policy_summary=jsonObject.getString("policy_summary");
                        Log.v("jsonObject11",jsonObject+"");
                        Log.v("policy_name1",policy_name);
                        Log.v("policy_summary1",policy_summary);
                        adapter.addItem(policy_name,policy_summary);
                        search_ListView.setAdapter(adapter);
                    }
                    Intent intent = new Intent(getApplicationContext(),Fragment_B.class);
                    startActivity(intent);


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
//                params.put("Location", String.valueOf(search_location));
//                Log.v("location","loc");
//                params.put("category",search_pregnant);
//                Log.v("category","preg");
                try {
                    JSONObject jsonObject = new JSONObject(val);
                    params.put("Location",jsonObject.getString("search_location"));
                    params.put("Policy",jsonObject.getString("search_category"));

                    Log.v("params",params+"");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return params;
            }
        };
        queue.add(stringRequest);
    }

}
