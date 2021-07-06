package com.smhrd.team.yh;


import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment_B extends Fragment {

    private ListView happyListView;
    private Button btn;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_b, container, false);

        happyListView.findViewById(R.id.happyListView);



        return fragment;


    }
}
