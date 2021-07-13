package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
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
import java.util.HashMap;
import java.util.Map;

public class Community_info extends AppCompatActivity {
    private RatingBar ratingbar_indicator;
    private TextView tv_change_comm, tv_comm_policy, tv_comm_avg;
    private EditText edt_community_content;
    private Button btn_comm, btn_comm_insert;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private ListView community_listview;
    private String users_id;
   private CommunityAdapter adapter=new CommunityAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_info);

        ratingbar_indicator = findViewById(R.id.ratingbar_Indicator);

//        MyThread myThread = new MyThread();
//        myThread.start();

//        Intent intent = getIntent();
//        users_id = intent.getStringExtra("id");

        tv_change_comm = findViewById(R.id.tv_change_comm);
        tv_comm_policy = findViewById(R.id.tv_comm_policy);
        tv_comm_avg = findViewById(R.id.tv_comm_avg);
        edt_community_content = findViewById(R.id.edt_community_content);
        btn_comm = findViewById(R.id.btn_comm);
        btn_comm_insert = findViewById(R.id.btn_comm_insert);
        community_listview = findViewById(R.id.community_listview);
        adapter.addItem("bm00","210719","asdasd");
        community_listview.setAdapter(adapter);


        ratingbar_indicator.setOnRatingBarChangeListener(new Listener());
    }


    class Listener implements RatingBar.OnRatingBarChangeListener
    {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            ratingbar_indicator.setRating(rating);
            tv_change_comm.setText("("+ Float.toString(rating)+"/5.0)점");

        }
    }

//    public void chatSelect(){
//        adapter = new CommunityAdapter();
//        queue = Volley.newRequestQueue(this);
//        String url = "http://59.0.234.126:3000/Chat";
//        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.v("resultValue", response);
//                try {
//                    JSONArray array = new JSONArray(response);
//                    for(int i = 0 ; i <array.length(); i++){
//                        JSONObject jsonObject = array.getJSONObject(i);
//                        String id = jsonObject.getString("id");
//                        String chat = jsonObject.getString("chat");
//                        adapter.addItem(users_id,edt_community_content);
//                    }
//                    chatList.setAdapter(adapter);
//                    chatList.setSelection(adapter.getCount()-1);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // Server 통신시 Error발생 하면 오는 곳
//                error.printStackTrace();
//            }
//        }) {
//            @Override
//            protected Response<String> parseNetworkResponse(NetworkResponse response) {
//
//                try {
//                    String utf8String = new String(response.data,"UTF-8");
//                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                return super.parseNetworkResponse(response);
//            }
//
//
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                // Server로 데이터를 보낼 시 넣어주는 곳
//                // alt + shift + r 한꺼번에 바꿀 수 있다.
//                Map<String,String> params = new HashMap<String, String>();
//                return params;
//            }
//        };
//        queue.add(stringRequest);
//    }
//
//
//    public void sendRequest() {
//        queue = Volley.newRequestQueue(this);
//        String url = "http://210.223.239.194:8082/AndroidWebServer/ChatInsert";
//        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.v("resultValue", response);
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // Server 통신시 Error발생 하면 오는 곳
//                error.printStackTrace();
//            }
//        }) {
//            @Override
//            protected Response<String> parseNetworkResponse(NetworkResponse response) {
//
//                try {
//                    String utf8String = new String(response.data,"UTF-8");
//                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                return super.parseNetworkResponse(response);
//            }
//
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                // Server로 데이터를 보낼 시 넣어주는 곳
//                // alt + shift + r 한꺼번에 바꿀 수 있다.
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("id",id);
//                params.put("chat",edt_chat_input.getText().toString());
//                return params;
//            }
//        };
//        queue.add(stringRequest);
//    }
//    public class MyThread extends Thread{
//        @Override
//        public void run() {
//            while(true){
//                chatSelect();
//                try {
//                    Thread.sleep(400);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}