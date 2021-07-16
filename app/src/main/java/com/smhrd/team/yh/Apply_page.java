package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Apply_page extends Fragment {

    private WebView mWebView;
    private View fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String url = ((MainActivity)((MainActivity)getActivity()).my_context).url;
        fragment=inflater.inflate(R.layout.activity_apply_page,container,false);
        Log.v("test",url);

//        Intent intent1=getActivity().getIntent();
//        String response= intent1.getStringExtra("response");
        //어플 화면 상단 좌측 이전 버튼 & 우측 햄버거 버튼 화면이동 만들기
//        try {
//            JSONArray array=new JSONArray(response);
//            for(int i=0;i<array.length();i++){
//                JSONObject jsonObject=array.getJSONObject(i);
//                String title=jsonObject.getString("Policy_Name");
//                String summary=jsonObject.getString("Policy_Summary");
//                adapter.addItem(title,summary);
//            }
//            SelectView.setAdapter(adapter);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        String title=PreferenceManager.getString(fragment.getContext(),"Search_title");
//        Search_title.setText(title);
//        btn_Find_Pre.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(fragment.getContext(),MainActivity.class);
//                startActivity(intent);
//
//            }
//        });


        return fragment;

    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_apply_page);
//        mWebView= findViewById(R.id.mWebView);
//
//        // 웹뷰 셋팅
//        mWebView.getSettings().setJavaScriptEnabled(true);//자바스크립트 허용
//
//        mWebView.loadUrl("http://bokjiro.go.kr/nwel/bokjiroMain.do");//웹뷰 실행
//        mWebView.setWebChromeClient(new WebChromeClient());//웹뷰에 크롬 사용 허용//이 부분이 없으면 크롬에서 alert가 뜨지 않음
//        mWebView.setWebViewClient(new WebViewClient());//새창열기 없이 웹뷰 내에서 다시 열기//페이지 이동 원활히 하기위해 사용
//
//
//// Initial webview
//        mWebView.setWebViewClient(new WebViewClient());
//// Enable JavaScript
//        mWebView.getSettings().setJavaScriptEnabled(true);
//// Enable Zoom
//        mWebView.getSettings().setBuiltInZoomControls(true);
//        mWebView.getSettings().setSupportZoom(true);
//// Adjust web display
//        mWebView.getSettings().setLoadWithOverviewMode(true);
//        mWebView.getSettings().setUseWideViewPort(true);
//// url은 알아서 설정 예) http://m.naver.com/
//    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {//뒤로가기 버튼 이벤트
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {//웹뷰에서 뒤로가기 버튼을 누르면 뒤로가짐
//            mWebView.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    private class WebViewClientClass extends WebViewClient {//페이지 이동
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            Log.d("check URL",url);
//            view.loadUrl(url);
//            return true;
//        }
//    }
}