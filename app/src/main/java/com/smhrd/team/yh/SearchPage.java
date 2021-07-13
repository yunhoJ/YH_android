package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;


public class SearchPage extends AppCompatActivity {

    private Button btn_pregnant, btn_child, btn_teenager, btn_youth, btn_middle_Age,
            btn_old_Age, btn_disabled, btn_single_Parent, btn_low_Income, btn_health,
            btn_education, btn_employ, btn_dwelling, btn_microfinance, btn_culture,
            btn_search_HamBar;
    private NumberPicker area_picker1, area_picker2; //picker 변수정의
    private TextView tv_area, tv1, tv2, tv3, tv4, tv5;



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
                if(newVal == 0){
                    Log.v("tetet","서울");
                    LocationGu.sou();
                    area_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                    area_picker2.setMinValue(0);
                    area_picker2.setDisplayedValues(LocationGu.locationguNames());
                    area_picker2.setWrapSelectorWheel(false);

                } else if(newVal == 1){
                    Log.v("tetet","광주");
                    LocationGu.gw();
                    area_picker2.setMaxValue(LocationGu.getLocationGuArrayList().size() - 1);
                    area_picker2.setMinValue(0);
                    area_picker2.setDisplayedValues(LocationGu.locationguNames());
                    area_picker2.setWrapSelectorWheel(false);


                }

            }
        });

//        NumberPicker picker1 = (NumberPicker) findViewById(R.id.area_picker);
//        picker1.setDisplayedValues(new String[]{
//                "서울", "광주"});
//
//        NumberPicker picker2 = (NumberPicker) findViewById(R.id.area_picker2);
//        picker2.setDisplayedValues(new String[]{
////                picker2.setMinValue(Integer.MIN_VALUE("북구"));
//                "북구", "남구", "서구", "동구"});
//
//        NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
//            @Override
//            public String format(int value) {
//                    switch (value) {
//                        case 0:
//                            return "서울";
//                        case 1:
//                            return "광주";
//                        case 2:
//                            return "경기";
//                    }
//                return null;
//            }
//            };


//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//
//        alert.setTitle("지역");
//        alert.setMessage("서울");
//
//        final EditText input = new EditText(this);
//        alert.setView(input);
//
//        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int whichButton) {
//                String value = input.getText().toString();
//                value.toString();
//                // Do something with value!
//            }
//        });
//
//        alert.setNegativeButton("Cancel",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        // Canceled.
//                    }
//                });
//
//        alert.show();


        btn_pregnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Pregnant.class);
                startActivity(intent);
            }
        });
        btn_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Child.class);
                startActivity(intent);

            }
        });
        btn_teenager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Teenager.class);
                startActivity(intent);

            }
        });
        btn_youth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Youth.class);
                startActivity(intent);

            }
        });
        btn_middle_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Middle_Age.class);
                startActivity(intent);

            }
        });
        btn_old_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Old_Age.class);
                startActivity(intent);

            }
        });
        btn_disabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Disabled.class);
                startActivity(intent);

            }
        });
        btn_single_Parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Single_Parent.class);
                startActivity(intent);

            }
        });
        btn_low_Income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Low_Income.class);
                startActivity(intent);

            }
        });
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Health.class);
                startActivity(intent);

            }
        });
        btn_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Education.class);
                startActivity(intent);

            }
        });
        btn_employ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Employ.class);
                startActivity(intent);

            }
        });
        btn_dwelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Dwelling.class);
                startActivity(intent);

            }
        });
        btn_microfinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Microfinance.class);
                startActivity(intent);

            }
        });
        btn_culture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Search_Culture.class);
                startActivity(intent);

            }
        });
        btn_search_HamBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),hemberger_test.class);
                startActivity(intent);

            }
        });





    }
}   