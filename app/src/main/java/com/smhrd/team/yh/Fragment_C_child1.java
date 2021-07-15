package com.smhrd.team.yh;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fragment_C_child1 extends Fragment {
    private RequestQueue queue;
    private StringRequest stringRequest;
    private View fragment;
    private ListView custom_listview;
    private CustomPolicyAdapter adapter;

    private String id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        fragment=inflater.inflate(R.layout.fragment_c_child, container, false);
        custom_listview=fragment.findViewById(R.id.custom_listview);
        adapter = new CustomPolicyAdapter();


        String login1 = PreferenceManager.getString(getActivity(),"Login");

        try {
          JSONObject jsonObject=new JSONObject(login1);
           id=jsonObject.getString("users_id");
        Log.v("LoginLog2",id);//이 로그는 나와요
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sendRequest();//여기 있어요
        custom_listview.setAdapter(adapter);



        return fragment;
    }
    public void sendRequest() {
    queue = Volley.newRequestQueue(fragment.getContext());//새로운 객체
    //ㄴ요청하는 것
    String url = "http://59.0.234.126:3000/C_Policy";
    stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() { //요청방식 get-내가 보낸데이터가 ?뒤 query=검색한거 일때-내가 검색한 기록을 공유해야 할때,post 데이터가 노출되지 않는다
        //ㄴ요청 정보
        @Override
        public void onResponse(String response) {
            Log.v("response11", response);
            try {
                JSONArray jsonArray=new JSONArray(response);
                PreferenceManager.removeKey(fragment.getContext(),"happysuble");
                PreferenceManager.setString(fragment.getContext(),"happysuble",jsonArray.length()+"");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject= jsonArray.getJSONObject(i);
                    String policy_name=jsonObject.getString("C_Policy_Name");
                    String policy_summary=jsonObject.getString("C_Policy_Summary");
                    Log.v("jsonObject11",jsonObject+"");
                    Log.v("policy_name1",policy_name);
                    Log.v("policy_summary1",policy_summary);

                    adapter.addItem(policy_name,policy_summary);
                    custom_listview.setAdapter(adapter);
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

            Map<String,String> params = new HashMap<String, String>();
//            String login1 = PreferenceManager.getString(getActivity(),"Login");
//
//            try {
//                JSONObject jsonObject=new JSONObject(login1);
//                Log.v("login12",jsonObject.getString("users_id"));
                params.put("id",id);//이게 안되요
                Log.v("LoginLog",id);//로그가 안나와요
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
         return params;
            //파라미터 방식 데이터 보내는곳
        }
    };
        queue.add(stringRequest);
}
}
