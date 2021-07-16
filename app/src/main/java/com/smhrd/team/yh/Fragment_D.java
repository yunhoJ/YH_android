package com.smhrd.team.yh;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Fragment_D extends Fragment implements View.OnClickListener{
    private TextView tv_setting_gun1, tv_setting_gun2;
    private Button btn_setting_notice, btn_setting_change, btn_setting_quit, btn_setting_qa, btn_setting_as,btn_setting_Logout;
    private ArrayList<JSONObject> dtos=new ArrayList<JSONObject>();
    private View fragment;
    private RequestQueue queue;
    private StringRequest stringRequest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


         fragment=inflater.inflate(R.layout.fragment_d,container,false);
        dtos= PreferenceManager.getStringArrayPref(fragment.getContext(),"my_policy_lisy");
        tv_setting_gun1=fragment.findViewById(R.id.tv_setting_gun1);
        tv_setting_gun2=fragment.findViewById(R.id.guideline2);
        tv_setting_gun1.setText(dtos.size()+"건");
        sendRequest();
        initView(fragment);

        button();


        return fragment;
    }

    private void button() { // 버튼 메소드
        tv_setting_gun1.setOnClickListener(this);
        tv_setting_gun2.setOnClickListener(this);
        btn_setting_notice.setOnClickListener(this);
        btn_setting_change.setOnClickListener(this);
        btn_setting_quit.setOnClickListener(this);
        btn_setting_qa.setOnClickListener(this);
        btn_setting_as.setOnClickListener(this);
        btn_setting_Logout.setOnClickListener(this);
    }

    private void initView(View fragment) { //뷰 초기화 initView메소드
        tv_setting_gun1 = fragment.findViewById(R.id.tv_setting_gun1);
        tv_setting_gun2 = fragment.findViewById(R.id.tv_setting_gun2);
        btn_setting_notice = fragment.findViewById(R.id.btn_setting_notice);
        btn_setting_change = fragment.findViewById(R.id.btn_setting_change);
        btn_setting_quit = fragment.findViewById(R.id.btn_setting_quit);
        btn_setting_qa = fragment.findViewById(R.id.btn_setting_qa);
        btn_setting_as = fragment.findViewById(R.id.btn_setting_as);
        btn_setting_Logout=fragment.findViewById(R.id.btn_setting_Logout);

    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_setting_notice){ //--- 클릭시 공지사항페이지로 이동
            Intent intent = new Intent(getActivity(),Notice.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_setting_qa){ //--- 클릭시 QnA페이지로 이동
            Intent intent = new Intent(getActivity(),QnA.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_setting_as){ //--- 클릭시 고객센터페이지로 이동
            Intent intent = new Intent(getActivity(),AS.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_setting_change){ //--- 클릭시 회원정보수정 페이지로 이동
            Intent intent = new Intent(getActivity(),UserInfoChange.class);
            startActivity(intent);
        }else if(v.getId() == R.id.btn_setting_quit){ //--- 클릭시 회원탈퇴 페이지로 이동
            Intent intent = new Intent(getActivity(),user_delete.class);
            startActivity(intent);
        }else if(v.getId()==R.id.btn_setting_Logout){
            PreferenceManager.clear(fragment.getContext());
            Toast.makeText(fragment.getContext(), "로그아웃", Toast.LENGTH_SHORT).show();
          Intent intent=new Intent(fragment.getContext(),MainActivity.class);
          startActivity(intent);


        }
        else if(v.getId() == R.id.tv_setting_gun1){
            Log.v("data","관심있는 복지 혜택");


        }else if(v.getId() == R.id.tv_setting_gun2){
            Intent intent = new Intent(getActivity(),My_comment.class);
            startActivity(intent);
        }
    }
    public void sendRequest() {
        queue = Volley.newRequestQueue(fragment.getContext());//새로운 객체
        //ㄴ요청하는 것
        String url = "http://59.0.234.126:3000/fragmentD";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() { //요청방식 get-내가 보낸데이터가 ?뒤 query=검색한거 일때-내가 검색한 기록을 공유해야 할때,post 데이터가 노출되지 않는다
            //ㄴ요청 정보
            @Override
            public void onResponse(String response) {
                Log.v("response11", response);
                try {
                    JSONArray jsonArray=jsonArray = new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id = jsonObject.getString("count");


                        tv_setting_gun2.setText(id+"건");
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
            String login1 = PreferenceManager.getString(getActivity(),"Login");
//
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
public static Fragment_D newInstance(){
        return new Fragment_D();
}
}