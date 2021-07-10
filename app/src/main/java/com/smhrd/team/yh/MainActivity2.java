package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String login = PreferenceManager.getString(getApplicationContext(),"Login");
        try {
            JSONObject jsonObject =new JSONObject(login);
            String id= jsonObject.getString("users_id");
            String pw= jsonObject.getString("users_pw");
            Log.v("idsd",id+pw);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}