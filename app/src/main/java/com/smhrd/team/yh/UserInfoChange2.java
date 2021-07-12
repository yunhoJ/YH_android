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

public class UserInfoChange2 extends AppCompatActivity {
    private Button btn_infoChange_finish;
    private CheckBox cb_fragnant, cb_singleParent, cb_disabled_person, cb_income;
    private NumberPicker interesting_picker, location_city_picker, location_gu_picker; //picker 변수정의
        // 도시 location_city_picker, 구 interesting_picker
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_change2);
        //Intent intent = getIntent(); // UserInfoChange 클래스에서 intent로 받아옴

        //MemberDTO c = (MemberDTO) intent.getSerializableExtra("change1");

        cb_fragnant = findViewById(R.id.cb_fragnant);
        cb_singleParent = findViewById(R.id.cb_singleParent);
        cb_disabled_person = findViewById(R.id.cb_disabled_person);
        cb_income=findViewById(R.id.cb_income);
        btn_infoChange_finish = findViewById(R.id.btn_infoChange_finish);




        btn_infoChange_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });

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

        // 도시 location_city_picker, 구 location_gu_picker

        location_city_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
               if(newVal == 0){
                   Log.v("tetet","서울");
                   LocationGu.sou();
                   location_gu_picker.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                   location_gu_picker.setMinValue(0);
                   location_gu_picker.setDisplayedValues(LocationGu.locationguNames());
                   location_gu_picker.setWrapSelectorWheel(false);

                   } else if(newVal == 1){
                    Log.v("tetet","광주");


                   LocationGu.gw();
                   location_gu_picker.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                   location_gu_picker.setMinValue(0);
                   location_gu_picker.setDisplayedValues(LocationGu.locationguNames());
                   location_gu_picker.setWrapSelectorWheel(false);
               }

            }
        });




    }
}