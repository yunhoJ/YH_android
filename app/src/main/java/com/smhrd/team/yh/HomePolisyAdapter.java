package com.smhrd.team.yh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
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
        TextView tv_policy_title = convertView.findViewById(R.id.tv_policy_title);
        TextView tv_policy_content = convertView.findViewById(R.id.tv_policy_content);
        Button btn_policy_apply = convertView.findViewById(R.id.btn_policy_apply);
        Button btn_policy_detail = convertView.findViewById(R.id.btn_policy_detail);

        HomePolisyDTO dto = homepolisyDTO.get(position);
        tv_policy_title.setText(dto.getTv_policy_title());
        tv_policy_content.setText(dto.getTv_policy_content());

        return convertView;
    }
    public void addItem(String tv_policy_title, String tv_policy_detail){
        HomePolisyDTO dto = new HomePolisyDTO(tv_policy_title, tv_policy_detail);
        homepolisyDTO.add(dto);
    }
}
