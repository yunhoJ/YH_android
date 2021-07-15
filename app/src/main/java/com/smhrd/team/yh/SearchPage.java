package com.smhrd.team.yh;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchPage extends AppCompatActivity {

    private Button btn_pregnant, btn_child, btn_teenager, btn_youth, btn_middle_Age,
            btn_old_Age, btn_disabled, btn_single_Parent, btn_low_Income, btn_health,
            btn_education, btn_employ, btn_dwelling, btn_microfinance, btn_culture,
            btn_search_HamBar;
    private NumberPicker area_picker1, area_picker2; //picker 변수정의
    private TextView tv_area, tv1, tv2, tv3, tv4, tv5;
    private String search_area, search_gu;
    private int search_location;


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
                    LocationGu.initLocationGus();
                    area_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                    area_picker2.setMinValue(1);
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
//                    Log.v("locationGu", search_gu);
                    Log.v("loc_num",search_location+"");
                }
            }
        });






    }
}
