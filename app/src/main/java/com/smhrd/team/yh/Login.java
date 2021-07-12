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
import android.widget.CheckBox;
import android.widget.EditText;
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
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Fragment {
    private EditText login_edt_id, login_edt_pw;
    private Button login_btn;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private CheckBox login_ck;
    private boolean isLogin ;
    private View fragment;
    private TextView textView6, login_tv_id, login_tv_pw, login_tv_join;

    private View view, view2, view3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        fragment = inflater.inflate(R.layout.activity_login, container, false);


        login_edt_id = fragment.findViewById(R.id.login_edt_id);
        login_edt_pw = fragment.findViewById(R.id.login_edt_pw);
        login_btn = fragment.findViewById(R.id.login_btn);
        login_ck = fragment.findViewById(R.id.login_ck);


        sendRequest();
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
                if (isLogin) {

                    PreferenceManager.setString(getApplicationContext(),"Login",value);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                 }
            }
        });

        return fragment;
    }




    }

    public void sendRequest() {
        queue = Volley.newRequestQueue(fragment.getContext());
        String url = "http://59.0.234.126:3000/Login";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);
                // MemberDTO(id, pw, name, tel) -> LoginSuccess
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getString("check").equals("ok")) {
                        isLogin = true;
                        String id = login_edt_id.getText().toString();
                        String pw = login_edt_pw.getText().toString();

                        Log.v("passw", id + pw);
                        MemberDTO dto = new MemberDTO(id, pw);
                        Gson gson = new Gson();
                        String value = gson.toJson(dto);
                        Log.v("resultValue", value);


                        PreferenceManager.setString(fragment.getContext(), "Login", value);
                        Intent intent = new Intent(fragment.getContext(), MainActivity.class);
                        startActivity(intent);

                    } else {
                        isLogin = false;
                        Toast.makeText(fragment.getContext(), "아이디와 비밀번호를 확인해주세요~!", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//

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
                params.put("id", login_edt_id.getText().toString());
                params.put("pw", login_edt_pw.getText().toString());
                Log.v("params", params + "");
                return params;

            }
        };
        queue.add(stringRequest);

        textView6 = fragment.findViewById(R.id.textView6);
        login_tv_id = fragment.findViewById(R.id.login_tv_id);
        login_tv_pw = fragment.findViewById(R.id.login_tv_pw);
        login_edt_id = fragment.findViewById(R.id.login_edt_id);
        login_edt_pw = fragment.findViewById(R.id.login_edt_pw);
        login_ck = fragment.findViewById(R.id.login_ck);
        login_btn = fragment.findViewById(R.id.login_btn);
        view = fragment.findViewById(R.id.view);
        view2 = fragment.findViewById(R.id.view2);
        view3 = fragment.findViewById(R.id.view3);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        login_ck.setChecked(new Boolean(false));
    }
}