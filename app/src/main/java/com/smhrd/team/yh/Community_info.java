package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView tv_change_star, tv_comm_policy, tv_comm_avg, tv_community_star,tv_community_p;
    private EditText edt_community_content;
    private Button btn_comm, btn_comm_insert, btn_rating_insert ,btn_community_back;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private ListView community_list;
    private String users_id, title;
    private CommunityAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_info);
        adapter = new CommunityAdapter();
           ratingbar_indicator = findViewById(R.id.ratingbar_indicator);

        MyThread myThread = new MyThread();
        myThread.start();

        btn_community_back=findViewById(R.id.btn_community_back);
        tv_community_star=findViewById(R.id.tv_community_star);
        tv_community_p=findViewById(R.id.tv_community_p);
        ratingbar_indicator = findViewById(R.id.ratingbar_indicator);
        tv_change_star = findViewById(R.id.tv_change_id);
        tv_comm_policy = findViewById(R.id.tv_comm_policy);
        tv_comm_avg = findViewById(R.id.tv_community_star);
        edt_community_content = findViewById(R.id.edt_community_content);
        btn_comm = findViewById(R.id.btn_comm);
        btn_comm_insert = findViewById(R.id.btn_comm_insert);
        community_list = findViewById(R.id.community_list);
        btn_rating_insert = findViewById(R.id.btn_rating_insert);

        Intent intent = getIntent();
        CommunityAMainDTO communityAMainDTO = (CommunityAMainDTO) intent.getSerializableExtra("dto");

        title = communityAMainDTO.getTv_community_title();



        btn_rating_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(),)
                sendRating();
                Toast.makeText(getApplicationContext(), "별점이 등록되었습니다!", Toast.LENGTH_SHORT).show();
                if(ratingbar_indicator.getRating()>0){
                    ratingbar_indicator.setRating(0);}
            }
        });

        tv_comm_policy.setText(title);
        tv_community_p.setText(communityAMainDTO.getTv_community_person()+"명");
        tv_community_star.setText(communityAMainDTO.getTv_community_rating());
        Log.v("asfd",tv_community_star.getText().toString());


        btn_comm_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();

               // community_list.setAdapter(adapter);
            }
        });
        btn_community_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myThread.interrupt();
                Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                sendRating();
                startActivity(intent1);
            }
        });
        ratingbar_indicator.setOnRatingBarChangeListener(new Listener());
    }
//

    class Listener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            ratingbar_indicator.setRating(rating);
            tv_change_star.setText("(" + Float.toString(rating) + "/5.0)점");

        }
    }

    public void chatSelect() {
        adapter = new CommunityAdapter();
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.234.126:3000/ChatSelect";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);

                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);
                        String id = jsonObject.getString("users_id");
                        String date = jsonObject.getString("community_date");
                        String content = jsonObject.getString("community_content");
                        String policy = title;
                        adapter.addItem(id, date, content);
                    }
                    community_list.setAdapter(adapter);
                    community_list.setSelection(adapter.getCount()-1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Server 통신시 Error발생 하면 오는 곳
                error.printStackTrace();
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {

                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return super.parseNetworkResponse(response);
            }


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Server로 데이터를 보낼 시 넣어주는 곳
                // alt + shift + r 한꺼번에 바꿀 수 있다.
                Map<String, String> params = new HashMap<String, String>();
                params.put("policy", title);
               // Log.v("policy",title);
                return params;
            }
        };
        queue.add(stringRequest);
    }


    public void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.234.126:3000/ChatSend";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Server 통신시 Error발생 하면 오는 곳
                error.printStackTrace();
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {

                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return super.parseNetworkResponse(response);
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Server로 데이터를 보낼 시 넣어주는 곳
                // alt + shift + r 한꺼번에 바꿀 수 있다.
                Map<String, String> params = new HashMap<String, String>();
                String login1 = PreferenceManager.getString(getApplication(), "Login");
                try {
                    JSONObject jsonObject = new JSONObject(login1);
                    jsonObject.getString("users_id");
                    params.put("id", jsonObject.getString("users_id"));
                    params.put("content", edt_community_content.getText().toString());
                    params.put("policy", title);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return params;
            }
        };

        queue.add(stringRequest);
    }
    public void sendRating() {
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.234.126:3000/RatingSend";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Server 통신시 Error발생 하면 오는 곳
                error.printStackTrace();
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {

                try {
                    String utf8String = new String(response.data,"UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return super.parseNetworkResponse(response);
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Server로 데이터를 보낼 시 넣어주는 곳
                // alt + shift + r 한꺼번에 바꿀 수 있다.
                Map<String,String> params = new HashMap<String, String>();
                String login1 = PreferenceManager.getString(getApplication(),"Login");
                try {
                    JSONObject jsonObject= new JSONObject(login1);
                    jsonObject.getString("users_id");
                    params.put("id",jsonObject.getString("users_id"));
                    params.put("point", String.valueOf(ratingbar_indicator.getRating()));
                    Log.v("asdf",String.valueOf(ratingbar_indicator.getRating()));
                    params.put("policy",title);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return params;
            }
        };

        queue.add(stringRequest);
    }

    public class MyThread extends Thread {
        @Override
        public void run() {

            try {
                while (!Thread.currentThread().isInterrupted()) {
                    chatSelect();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
