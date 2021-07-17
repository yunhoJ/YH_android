package com.smhrd.team.yh;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fragment_A extends Fragment {
    private MainActivity mainActivity;

    private ListView community_listview;
    private CommunityAdapterAMAin adapter;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private View fragment;
    private ArrayList<CommunityAMainDTO> list;
    private CommunityAMainDTO dto;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        fragment=inflater.inflate(R.layout.fragment_a,container,false);
        community_listview=fragment.findViewById(R.id.community_listview);
        adapter=new CommunityAdapterAMAin();
        list =new ArrayList<CommunityAMainDTO>();
        sendRequest();

        community_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendRequest();
                Log.v("asdf","클릭");
                Intent intent =new Intent(fragment.getContext(),Community_info.class);
                intent.putExtra("dto",list.get(position));
                startActivity(intent);



            }
        });







//        fragmentA 맨위에 어레이리스트생성
//        어레이리스트 <dto >변수 생성
//        발리 서버
//        데이터
//        dto 생성자 만들기
//        서버에서받아온 데이터를 생성자로 보내줘가지고
//        변수에다가 변수.addDTO로
////        이렇게하면 어레이리스트가 DTO가들어감
//        아이템클릭하면 포지션이 그 어레이리스트DTO랑 똑같은애임
//        그럼 포지션해가지고 풋엑스트라로다가 DTO를 넣어버려
//        다른페이지에서는 DTO로 받아오면됨
//        어레이리스트 겟포지션



        return fragment;
    }


    public void sendRequest() {
        queue = Volley.newRequestQueue(fragment.getContext());//새로운 객체
        //ㄴ요청하는 것
        String url = "http://59.0.234.126:3000/C_Policy_Rating";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() { //요청방식 get-내가 보낸데이터가 ?뒤 query=검색한거 일때-내가 검색한 기록을 공유해야 할때,post 데이터가 노출되지 않는다
            //ㄴ요청 정보

            @Override
            public void onResponse(String response) {

            Log.v("response112", response);
            String Star;

            try {
                JSONArray jsonArray= new JSONArray(response);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String C_policy_name = jsonObject.getString("name");
                    String count = jsonObject.getString("count");
                    String avg = jsonObject.getString("avg");
                    float avgs=Float.valueOf(avg);

                    if (avgs > 4.5) {
                        Star = "★★★★★";
                    } else if (avgs > 4) {
                        Star = "★★★★☆";
                    } else if (avgs > 3.5) {
                        Star = "★★★★";
                    } else if (avgs > 3) {
                        Star = "★★★☆";
                    } else if (avgs > 2.5) {
                        Star = "★★★";
                    }else if (avgs > 2) {
                        Star = "★★☆";
                    } else if (avgs > 1.5) {
                        Star = "★★";
                    }else if (avgs > 1) {
                        Star = "★☆";
                    } else if (avgs > 0) {
                        Star = "★";
                    }else {
                        Star = "☆";
                    }
                    dto=new CommunityAMainDTO(C_policy_name,Star,avg+"/5.0",count);
                    list.add(dto);
                    adapter.addItem(C_policy_name,Star,avg+"/5.0",count);


                }
                community_listview.setAdapter(adapter);


//                Log.v("asfd",list.get(1).getTv_community_title());
//                community_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String item = String.valueOf(parent.getItemAtPosition(position));
//                        Log.v("asdf",item);
//                    }
//                });
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


            String login1 = PreferenceManager.getString(getActivity(),"Login");

            try {
                JSONObject jsonObject=new JSONObject(login1);
                Log.v("login12",jsonObject.getString("users_id"));
                params.put("id",jsonObject.getString("users_id"));


            } catch (JSONException e) {
                e.printStackTrace();
            }
                return params;
                //파라미터 방식 데이터 보내는곳
            }
        };
        queue.add(stringRequest);
    }
}
