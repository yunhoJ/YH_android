package com.smhrd.team.yh;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_C extends Fragment {
    private Button fragc_btn_all, fragc_btn_choice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment=inflater.inflate(R.layout.fragment_c,container,false);

//
        fragc_btn_all = fragment.findViewById(R.id.fragc_btn_all);
        fragc_btn_choice = fragment.findViewById(R.id.fragc_btn_choice);

        fragc_btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().add(R.id.child_fragment, new Fragment_C()).commit();

                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new Fragment_C_child1()).commit();
            }
        });
        fragc_btn_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().add(R.id.child_fragment, new Fragment_C()).commit();
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new Fragment_C_child2()).commit();
            }
        });
        return fragment;
    }
}