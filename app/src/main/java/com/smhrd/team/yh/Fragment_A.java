package com.smhrd.team.yh;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragment_A extends Fragment {
    private MainActivity mainActivity;

    private ListView community_listview;
    @Override //액티비티에서 A 를실행하는순간 연결
    public void onAttach( Context context) {
        super.onAttach(context);
        mainActivity=(MainActivity)getActivity();//연결된 액티비티
    }

    CommunityAdapter adapter=new CommunityAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View fragment=inflater.inflate(R.layout.fragment_a,container,false);
        community_listview=fragment.findViewById(R.id.community_listview);
        adapter.addItem("근로장학금","★★★★","4.0/5.0","1020명");
        adapter.addItem("근로장학금","★★★★","4.0/5.0","1020명");
        adapter.addItem("근로장학금","★★★★","4.0/5.0","1020명");
        community_listview.setAdapter(adapter);



        return fragment;
    }
}