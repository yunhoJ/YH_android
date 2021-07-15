package com.smhrd.team.yh;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

public class Fragment_C extends Fragment {

    private Button fragc_btn_all, fragc_btn_choice, btn_happyham;
    private ImageView imghappyham;
    private TextView mainview, happytitle, happysub;
    private MainActivity mainActivity;
    private BottomNavigationView navi;
    private String id;
    @Override //액티비티에서 A 를실행하는순간 연결
    public void onAttach( Context context) {
        super.onAttach(context);
        mainActivity=(MainActivity)getActivity();//연결된 액티비티
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment=inflater.inflate(R.layout.fragment_c,container,false);

        navi=fragment.findViewById(R.id.policy_navi);
        imghappyham = fragment.findViewById(R.id.imghappyham);
        btn_happyham = fragment.findViewById(R.id.btn_happyham);
        mainview = fragment.findViewById(R.id.mainview);
        happytitle = fragment.findViewById(R.id.tv_community_person);
        happysub = fragment.findViewById(R.id.happysub);


        getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new Fragment_C_child1()).commit();
       String happysuble =PreferenceManager.getString(fragment.getContext(),"happysuble");
       String Login=PreferenceManager.getString(fragment.getContext(),"Login");
        try {
            JSONObject jsonObject=new JSONObject(Login);
            id=jsonObject.getString("users_id");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        happysub.setText(id+" 님의 맞춤 정책은"+happysuble+"개입니다. ");
      navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected( MenuItem item) {

              int selectItem = item.getItemId();
              if(selectItem==R.id.page5)
              {
                  getChildFragmentManager().beginTransaction().add(R.id.child_fragment, new Fragment_C()).commit();
                  getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new Fragment_C_child1()).commit();


              }
              else if(selectItem==R.id.page6){
                  getChildFragmentManager().beginTransaction().add(R.id.child_fragment, new Fragment_C()).commit();
                  getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new Fragment_C_child2()).commit();
              }
              return false;
          }
      });

        return fragment;
    }
}