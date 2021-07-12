package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class UserInfoChange2 extends AppCompatActivity {
    Button btn_infoChange_finish;
    private NumberPicker interesting_picker, location_city_picker, location_gu_picker; //picker 변수정의

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_change2);
        Intent intent = getIntent(); // UserInfoChange 클래스에서 intent로 받아옴

        //id로 pciker 찾아주기
        interesting_picker = findViewById(R.id.interesting_picker);
        location_city_picker = findViewById(R.id.join_age_picker);
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


//        interesting_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
//        {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldValue, int newValue)
//            {
////                textView.setText("" + Interesting.getLanguageArrayList().get(newValue).getName());
//            }
//        });


        btn_infoChange_finish = findViewById(R.id.btn_infoChange_finish); //수정완료 버튼 가져오기

        btn_infoChange_finish.setOnClickListener(new View.OnClickListener() { // 수정완료 클릭 리스너
            @Override
            public void onClick(View v) {

            }
        });
    }
}