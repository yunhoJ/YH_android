package com.smhrd.team.yh;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment_D_2 extends Fragment {

    private Button btnjoin, btnlogin, btn_setting_notice, btn_setting_qa, btn_setting_as;
    private TextView textView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//언니화이팅 :)

        View fragment=inflater.inflate(R.layout.fragment_d_2,container,false);

        btnjoin = fragment.findViewById(R.id.btnjoin);
        btnlogin = fragment.findViewById(R.id.btnlogin);
        btn_setting_notice = fragment.findViewById(R.id.btn_setting_notice);
        btn_setting_qa = fragment.findViewById(R.id.btn_setting_qa);
        btn_setting_as = fragment.findViewById(R.id.btn_setting_as);

        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),Join.class);
                startActivity(intent);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
        btn_setting_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),Notice.class);
                startActivity(intent);
            }
        });
        btn_setting_qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),QnA.class);
                startActivity(intent);
            }
        });
        btn_setting_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),AS.class);
                startActivity(intent);
            }
        });






        return fragment;
    }
}
