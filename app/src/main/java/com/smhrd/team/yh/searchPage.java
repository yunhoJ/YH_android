package com.smhrd.team.yh;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class searchPage extends AppCompatActivity {

    private Button btn_pregnant, btn_child, btn_teenager, btn_youth, btn_middle_Age,
            btn_old_Age, btn_disabled, btn_single_Parent, btn_low_Income, btn_health,
            btn_education, btn_employ, btn_dwelling, btn_microfinance, btn_culture,
            btn_search_HamBar;

    private ImageView img_search_Ham, img_pregnant, img_child, img_teenager, img_youth,
            img_middle_Age, img_old_Age, img_disabled, img_single_Parent, img_low_Income,
            img_health, img_education, img_employ, img_dwelling, img_microfinance,
            img_culture;

    private TextView tv_area, tv1, tv2, tv3, tv4, tv5;
    private NumberPicker AreaPicker;

    private EditText areapicker, areapicker2;

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

        img_search_Ham = findViewById(R.id.img_search_Ham);
        img_pregnant = findViewById(R.id.img_pregnant);
        img_child = findViewById(R.id.img_child);
        img_teenager = findViewById(R.id.img_teenager);
        img_youth = findViewById(R.id.img_youth);
        img_middle_Age = findViewById(R.id.img_middle_Age);
        img_old_Age = findViewById(R.id.img_old_Age);
        img_disabled = findViewById(R.id.img_disabled);
        img_single_Parent = findViewById(R.id.img_single_Parent);
        img_low_Income = findViewById(R.id.img_low_Income);
        img_health = findViewById(R.id.img_health);
        img_education = findViewById(R.id.img_education);
        img_employ = findViewById(R.id.img_employ);
        img_dwelling = findViewById(R.id.img_dwelling);
        img_microfinance = findViewById(R.id.img_microfinance);
        img_culture = findViewById(R.id.img_culture);

        tv_area = findViewById(R.id.tv_area);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);

        NumberPicker picker1 = (NumberPicker)findViewById(R.id.area_picker);
        picker1.setDisplayedValues(new String[]{
                "서울", "광주"});



        NumberPicker picker2 = (NumberPicker)findViewById(R.id.area_picker2);
        picker2.setDisplayedValues(new String[]{
                "북구", "남구", "서구", "동구"});

        NumberPicker.Formatter mFormatter = new NumberPicker.Formatter() {



            @Override

            public String format(int value) {

                // TODO Auto-generated method stub

                switch(value){

                    case 0:

                        return "zero";

                    case 1:

                        return "one";

                    case 2:

                        return "two";



                }



                return null;

            }

        };

        AreaPicker = findViewById(R.id.area_picker);

        AreaPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                if(newVal < 2){
//                    tv_age.setText("영유아");
//                }else if(newVal <20){
//                    tv_age.setText("아동");
//                }else if(newVal <35){
//                    tv_age.setText("청년");
//                }else if(newVal <51){
//                    tv_age.setText("중장년");
//                }else{
//                    tv_age.setText("노년");
//                }
            }
        });

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("지역");
        alert.setMessage("서울");

        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString();
                value.toString();
                // Do something with value!
            }
        });

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

        alert.show();


        btn_pregnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),UserInfoChange2.class);
                startActivity(intent1);
            }
        });
        btn_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_teenager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_youth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_middle_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_old_Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_disabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_single_Parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_low_Income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_employ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_dwelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_microfinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_culture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_search_HamBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }
}   