package com.smhrd.team.yh;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment_C extends Fragment {

    private Button fragc_btn_all, fragc_btn_choice, btn_happyham;
    private ImageView imghappyham;
    private TextView mainview, happytitle, happysub;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment=inflater.inflate(R.layout.fragment_c,container,false);

        imghappyham = fragment.findViewById(R.id.imghappyham);
        btn_happyham = fragment.findViewById(R.id.btn_happyham);
        mainview = fragment.findViewById(R.id.mainview);
        happytitle = fragment.findViewById(R.id.happytitle);
        happysub = fragment.findViewById(R.id.happysub);
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