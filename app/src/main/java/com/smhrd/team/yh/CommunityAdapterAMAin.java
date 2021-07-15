package com.smhrd.team.yh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CommunityAdapterAMAin extends BaseAdapter {

    ArrayList<CommunityAMainDTO> communityDTO=new ArrayList<CommunityAMainDTO>();
    @Override
    public int getCount() {
        return communityDTO.size();
    }

    @Override
    public Object getItem(int position) {
        return communityDTO.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if (convertView == null)
        {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.communitylist,parent, false);
        }

        TextView tv_community_title= convertView.findViewById(R.id.tv_community_title);
        TextView tv_community_star= convertView.findViewById(R.id.tv_community_star);
        TextView tv_community_rating= convertView.findViewById(R.id.tv_comm_policy);
        TextView tv_community_person= convertView.findViewById(R.id.tv_community_person);
        CommunityAMainDTO community=communityDTO.get(position);
        tv_community_title.setText(community.getTv_community_title());
        tv_community_star.setText(community.getTv_community_star());
        tv_community_rating.setText(community.getTv_community_rating());
        tv_community_person.setText(community.getTv_community_person());



        return convertView;
    }
    public void addItem(String tv_community_title, String tv_community_star, String tv_community_rating, String tv_community_person) {
        CommunityAMainDTO community=new CommunityAMainDTO(tv_community_title,tv_community_star,tv_community_rating,tv_community_person);
        communityDTO.add(community);

    }
}
