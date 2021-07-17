package com.smhrd.team.yh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class HomePolisyAdapter extends BaseAdapter {

    private ArrayList<HomePolisyDTO> homepolisyDTO = new ArrayList<HomePolisyDTO>();

    @Override
    public int getCount() {
        return homepolisyDTO.size();
    }

    @Override
    public Object getItem(int position) {
        return homepolisyDTO.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.policy, parent, false);
        }
        TextView tv_policy_title = convertView.findViewById(R.id.tv_custom_policy_title);
        TextView tv_policy_content = convertView.findViewById(R.id.tv_custom_policy_content);
        TextView tv_policy_apply = convertView.findViewById(R.id.tv_policy_apply);
        TextView tv_policy_detail = convertView.findViewById(R.id.tv_policy_detail);
        Button btn_policy_apply = convertView.findViewById(R.id.btn_custom_policy_apply);
        Button btn_policy_detail = convertView.findViewById(R.id.btn_custom_policy_detail);


        HomePolisyDTO dto = homepolisyDTO.get(position);
        tv_policy_title.setText(dto.getTv_policy_title());
        tv_policy_content.setText(dto.getTv_policy_content());
        tv_policy_apply.setText(dto.getTv_policy_apply());
        tv_policy_detail.setText(dto.getTv_policy_detail());

        btn_policy_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Apply_page apply_page = new Apply_page();
                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.child_fragment,apply_page).commit();
//                Intent intent=new Intent(context,MainActivity.class);
//                context.startActivity(intent);
                ((MainActivity)((MainActivity)context).my_context).url=tv_policy_apply.getText().toString();

            }
        });
        btn_policy_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Apply_page apply_page = new Apply_page();
                FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.child_fragment,apply_page).commit();
                ((MainActivity)((MainActivity)context).my_context).content=tv_policy_detail.getText().toString();
            }
        });

        return convertView;
    }
    public void addItem(String tv_policy_title, String tv_policy_content){
        HomePolisyDTO dto = new HomePolisyDTO(tv_policy_title, tv_policy_content);
        homepolisyDTO.add(dto);
    }
    public void addItem(String tv_policy_title, String tv_policy_content, String tv_policy_apply, String tv_policy_detail){
        HomePolisyDTO dto = new HomePolisyDTO(tv_policy_title, tv_policy_content,tv_policy_apply,tv_policy_detail);
        homepolisyDTO.add(dto);
    }
}
