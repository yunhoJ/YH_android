package com.smhrd.team.yh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment_A extends Fragment {
    private MainActivity mainActivity;

    @Override //액티비티에서 A 를실행하는순간 연결
    public void onAttach( Context context) {
        super.onAttach(context);
        mainActivity=(MainActivity)getActivity();//연결된 액티비티
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View fragment=inflater.inflate(R.layout.activity_fragment_a,container,false);



        return fragment;
    }
}