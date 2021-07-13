package com.smhrd.team.yh;


import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
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
import java.util.Map;

public class Fragment_B extends Fragment {

    private RequestQueue queue;
    private StringRequest stringRequest;
    private ListView happyListView;
    private Button btn_search, btn_hamb;
    private View fragment;
    private HomePolisyAdapter adapter = new HomePolisyAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragment = inflater.inflate(R.layout.fragment_b, container, false);

        btn_search = fragment.findViewById(R.id.btn_search);
        btn_hamb = fragment.findViewById(R.id.button60);


        happyListView = fragment.findViewById(R.id.happyListView);

        // 상단 검색 버튼 페이지 이동
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchPage.class);
                startActivity(intent);
            }
        });

//        String url = "http://59.0.234.126:3000/policy";
//        InputStream is = null;
//        try {
//            is = new URL(url).openStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            String str;
//            StringBuffer buffer = new StringBuffer();
//            while ((str = rd.readLine()) != null) {
//                buffer.append(str);
//            }
//            String receiveMsg = buffer.toString();
//            Log.v("receiveMsg",receiveMsg);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




       adapter.addItem("5차재난지원금","코로나 19 피해");
//        adapter.addItem("전세대출지원금","광주지역 만 24세부터");
//        adapter.addItem("청년구직활동지원금","청년 무직자");
//        adapter.addItem("청소년급식비지원","한부모 가정 ");
//        adapter.addItem("지원금","안농");
//        adapter.addItem("지원금","안농");
//        adapter.addItem("지원금","나는유이야");
//        adapter.addItem("asd","asdioi");
        sendRequest();

        happyListView.setAdapter(adapter);


//        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img1),"내용", "댓글내용");

        return fragment;
    }

    public void sendRequest() {
        queue = Volley.newRequestQueue(fragment.getContext());//새로운 객체
        //ㄴ요청하는 것
        String url = "http://59.0.234.126:3000/policy";
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() { //요청방식 get-내가 보낸데이터가 ?뒤 query=검색한거 일때-내가 검색한 기록을 공유해야 할때,post 데이터가 노출되지 않는다
            //ㄴ요청 정보
            @Override
            public void onResponse(String response) {

                Log.v("response11", response);



               try {
                    JSONArray jsonArray=new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                        String policy_name=jsonObject.getString("policy_name");
                        String policy_summary=jsonObject.getString("policy_summary");
                        Log.v("jsonObject11",jsonObject+"");
                        Log.v("policy_name1",policy_name);
                        Log.v("policy_summary1",policy_summary);

                        adapter.addItem(policy_name,policy_summary);
                       happyListView.setAdapter(adapter);
                   }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //서버 통신시 에러 발생 하면 오는곳

                error.printStackTrace();//로그에 띄움

            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {

                //응답 데이터 가져오는 부분 인코딩
                try {
                    String utf8string = new String(response.data, "UTF8");
                    return Response.success(utf8string, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Log.v("response",response+"");
                return super.parseNetworkResponse(response);
            }

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





