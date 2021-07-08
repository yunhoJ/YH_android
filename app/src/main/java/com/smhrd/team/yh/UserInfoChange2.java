package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class UserInfoChange2 extends AppCompatActivity {
    Button btn_infoChange_finish;
    private NumberPicker interesting_picker, income_picker, location_city_picker, location_gu_picker; //picker 변수정의

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_change2);
        Intent intent = getIntent(); // UserInfoChange 클래스에서 intent로 받아옴

        //id로 pciker 찾아주기
        interesting_picker = findViewById(R.id.interesting_picker);
        income_picker = findViewById(R.id.income_picker);
        location_city_picker = findViewById(R.id.location_city_picker);
        location_gu_picker = findViewById(R.id.location_gu_picker);

        Interesting.initInterestings();
        interesting_picker.setMaxValue(Interesting.getLanguageArrayList().size() - 1);
        interesting_picker.setMinValue(0);
        interesting_picker.setDisplayedValues(Interesting.languageNames());

        interesting_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            @Override
            public void onValueChange(NumberPicker picker, int oldValue, int newValue)
            {
//                textView.setText("" + Interesting.getLanguageArrayList().get(newValue).getName());
            }
        });


        btn_infoChange_finish = findViewById(R.id.btn_infoChange_finish);

        btn_infoChange_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}