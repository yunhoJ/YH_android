package com.smhrd.team.yh;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomPolicyAdapter extends BaseAdapter {
    private     boolean ischecked;
    ArrayList<HomePolisyDTO> arrayList=new ArrayList<HomePolisyDTO>();

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context=parent.getContext();
        if(convertView == null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_policy, parent, false);
        }
        TextView tv_custom_policy_title = convertView.findViewById(R.id.tv_custom_policy_title);
        TextView tv_custom_policy_content = convertView.findViewById(R.id.tv_custom_policy_content);
        Button btn_custom_policy_apply = convertView.findViewById(R.id.btn_custom_policy_apply);
        Button btn_custom_policy_detail = convertView.findViewById(R.id.btn_custom_policy_detail);
        Button btn_custom_star=convertView.findViewById(R.id.btn_custom_star);
        ImageView custom_star=convertView.findViewById(R.id.img_community);
        HomePolisyDTO dto=arrayList.get(position);
        tv_custom_policy_title.setText(dto.getTv_policy_title());
        tv_custom_policy_content.setText(dto.getTv_policy_content());

        custom_star.setImageResource(R.drawable.staroff);

        ArrayList<HomePolisyDTO> list=new ArrayList<HomePolisyDTO>();

        btn_custom_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ischecked==false) {

                    custom_star.setImageResource(R.drawable.star);
                    HomePolisyDTO dto = new HomePolisyDTO(tv_custom_policy_title.getText().toString(), tv_custom_policy_content.getText().toString());
                    list.add(dto);
                    PreferenceManager.setStringArrayPref(context.getApplicationContext(), "my_policy_lisy",list);
                    for (int i = 0; i <list.size() ; i++) {

                        Log.v("asdf", list.get(i).getTv_policy_title());
                    }
                    ischecked=true;
                }else if (ischecked==true) {
                    custom_star.setImageResource(R.drawable.staroff);
                    ischecked = false;
                }
            }
        });

        return convertView;
    }
        public void addItem(String tv_custom_policy_title, String tv_custom_policy_content){
        HomePolisyDTO dto = new HomePolisyDTO(tv_custom_policy_title, tv_custom_policy_content);
        arrayList.add(dto);

    }


}
