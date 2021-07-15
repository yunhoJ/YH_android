package com.smhrd.team.yh;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Fragment_C_child2 extends Fragment {
    private View fragment;
    private ListView my_policy_listview;
    private CustomPolicyAdapter adapter;
    private ArrayList<JSONObject> dtos=new ArrayList<JSONObject>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment=inflater.inflate(R.layout.fragment_c_child2, container, false);
        my_policy_listview=fragment.findViewById(R.id.my_policy_listview);
        adapter = new CustomPolicyAdapter();

        dtos= PreferenceManager.getStringArrayPref(fragment.getContext(),"my_policy_lisy");

        for (int i = 0; i < dtos.size(); i++) {

            try{
                String a = dtos.get(i).getString("tv_policy_title");
                String b = dtos.get(i).getString("tv_policy_content");
                int c=dtos.get(i).getInt("starList");
                Log.v("asdf", a + b);
                adapter.addItem(a, b);
            }catch (JSONException e){
                e.printStackTrace();
            }
        }my_policy_listview.setAdapter(adapter);

//




        return fragment;
    }
}
