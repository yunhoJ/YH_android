package com.smhrd.team.yh;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class JoinResult extends AppCompatActivity {

    private TextView txt_id, txt_pw, txt_sex, txt_birth, txt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_result);
        txt_id = findViewById(R.id.join2_low_income);
        txt_pw = findViewById(R.id.join_pw);
        txt_sex = findViewById(R.id.join2_disabled_person);
        txt_birth = findViewById(R.id.join2_pregnant_women);
        txt_phone = findViewById(R.id.join2_location);


        String info = PreferenceManager.getString(getApplicationContext(),"info");
        if(!info.equals("")){
            try {
                JSONObject jsonObject = new JSONObject(info);
                String id = jsonObject.getString("id");
                String pw = jsonObject.getString("pw");
                String sex = jsonObject.getString("sex");
                String birth = jsonObject.getString("birth");
                String phone = jsonObject.getString("phone");

                txt_id.setText(id);
                txt_pw.setText(pw);
                txt_sex.setText(sex);
                txt_birth.setText(birth);
                txt_phone.setText(phone);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}