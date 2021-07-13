package com.smhrd.team.yh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment_C_child1 extends Fragment {

    private View fragment;
    private ListView custom_listview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        fragment=inflater.inflate(R.layout.fragment_c_child, container, false);
        custom_listview=fragment.findViewById(R.id.custom_listview);
        CustomPolicyAdapter adapter = new CustomPolicyAdapter();


        adapter.addItem("정칙이름","정책내용");
        adapter.addItem("정칙이름","정책내용");
        adapter.addItem("정칙이름","정책내용");
        adapter.addItem("정칙이름","정책내용");
        adapter.addItem("정칙이름","정책내용");
        adapter.addItem("정칙이름","정책내용");



        custom_listview.setAdapter(adapter);

        return fragment;
    }
}
