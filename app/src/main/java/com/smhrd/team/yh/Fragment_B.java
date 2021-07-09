package com.smhrd.team.yh;


import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Fragment_B extends Fragment {

    private RequestQueue queue;
    private StringRequest stringRequest;
    private ListView happyListView;
    private Button btn_search, btn_hamb;
    private View fragment;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragment = inflater.inflate(R.layout.fragment_b, container, false);

        btn_search = fragment.findViewById(R.id.btn_search);
        btn_hamb = fragment.findViewById(R.id.btn_hamb);


        happyListView = fragment.findViewById(R.id.happyListView);

        HomePolisyAdapter adapter = new HomePolisyAdapter();
        adapter.addItem("5차재난지원금","코로나 19 피해");
        adapter.addItem("전세대출지원금","광주지역 만 24세부터");
        adapter.addItem("청년구직활동지원금","청년 무직자");
        adapter.addItem("청소년급식비지원","한부모 가정 ");
        adapter.addItem("지원금","안농");
        adapter.addItem("지원금","안농");
        adapter.addItem("지원금","나는유이야");
        sendRequest();

        happyListView.setAdapter(adapter);


//        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img1),"내용", "댓글내용");

        return fragment;
    }

    public void sendRequest() {
        queue = Volley.newRequestQueue(fragment.getContext());//새로운 객체
        //ㄴ요청하는 것
        String url = "59.0.234.126:3000/policy";
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() { //요청방식 get-내가 보낸데이터가 ?뒤 query=검색한거 일때-내가 검색한 기록을 공유해야 할때,post 데이터가 노출되지 않는다
            //ㄴ요청 정보
            @Override
            public void onResponse(String response) {
                Log.v("response11", response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //서버 통신시 에러 발생 하면 오는곳

                error.printStackTrace();//로그에 띄움

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //서버로 데이터를 보낼시 넣어주는곳
                return super.getParams();
                //파라미터 방식 데이터 보내는곳
            }
        };


        queue.add(stringRequest);
    }



}





