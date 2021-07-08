package com.smhrd.team.yh;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment_D extends Fragment implements View.OnClickListener{
    private TextView tv_setting_gun1, tv_setting_gun2;
    private Button btn_setting_notice, btn_setting_change, btn_setting_quit, btn_setting_qa, btn_setting_as;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View fragment=inflater.inflate(R.layout.fragment_d,container,false);

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
    }

    private void initView(View fragment) { //뷰 초기화 initView메소드
        tv_setting_gun1 = fragment.findViewById(R.id.tv_setting_gun1);
        tv_setting_gun2 = fragment.findViewById(R.id.tv_setting_gun2);
        btn_setting_notice = fragment.findViewById(R.id.btn_setting_notice);
        btn_setting_change = fragment.findViewById(R.id.btn_setting_change);
        btn_setting_quit = fragment.findViewById(R.id.btn_setting_quit);
        btn_setting_qa = fragment.findViewById(R.id.btn_setting_qa);
        btn_setting_as = fragment.findViewById(R.id.btn_setting_as);
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
        }else if(v.getId() == R.id.btn_setting_quit){ //--- 클릭시 회원정보수정 페이지로 이동
            Intent intent = new Intent(getActivity(),user_delete.class);
            startActivity(intent);
        }
    }

}