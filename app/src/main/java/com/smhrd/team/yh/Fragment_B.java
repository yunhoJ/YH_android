package com.smhrd.team.yh;


import androidx.core.content.ContextCompat;
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
    private Button btn_search, btn_enter, btn_more, btn_hamb;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_b, container, false);

        btn_search = fragment.findViewById(R.id.btn_search);

        btn_hamb = fragment.findViewById(R.id.btn_hamb);
        happyListView = fragment.findViewById(R.id.happyListView);

        ListViewAdapter adapter = new ListViewAdapter();

//        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img1),"내용", "댓글내용");

        happyListView.setAdapter(adapter);

return fragment;
    }
}
