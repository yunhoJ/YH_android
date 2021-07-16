package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.util.Map;

public class Search_Child extends Fragment {

    private ListView SelectView;
    private Button btn_Find_Pre, btn_Find_Ham;
    private View fragment;
    private TextView Search_title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        fragment=inflater.inflate(R.layout.activity_search_child,container,false);
        SelectView=fragment.findViewById(R.id.SelectView);
        Search_title=fragment.findViewById(R.id.Search_title);
        btn_Find_Pre=fragment.findViewById(R.id.btn_Find_Pre);
        HomePolisyAdapter adapter = new HomePolisyAdapter();
        Intent intent1=getActivity().getIntent();
        String response= intent1.getStringExtra("response");
        //어플 화면 상단 좌측 이전 버튼 & 우측 햄버거 버튼 화면이동 만들기
        try {
            JSONArray array=new JSONArray(response);
            for(int i=0;i<array.length();i++){
                JSONObject jsonObject=array.getJSONObject(i);
                String title=jsonObject.getString("Policy_Name");
                String summary=jsonObject.getString("Policy_Summary");
                adapter.addItem(title,summary);
            }
            SelectView.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String title=PreferenceManager.getString(fragment.getContext(),"Search_title");
        Search_title.setText(title);
        btn_Find_Pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(fragment.getContext(),MainActivity.class);
                startActivity(intent);

            }
        });


        return fragment;

    }
}