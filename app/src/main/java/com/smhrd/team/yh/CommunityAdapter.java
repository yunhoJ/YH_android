package com.smhrd.team.yh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CommunityAdapter extends BaseAdapter {
    ArrayList<CommunityDTO> list = new ArrayList<CommunityDTO>();

    @Override
    public int getCount() {
        return list.size();

    ArrayList<CommunityDTO> communityDTO=new ArrayList<CommunityDTO>();
    @Override
    public int getCount() {
        return communityDTO.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
        return communityDTO.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.comu_content_list, parent, false);
        }

        TextView comm_tv_id = convertView.findViewById(R.id.comm_tv_id);
        TextView comm_tv_date = convertView.findViewById(R.id.comm_tv_date);
        TextView comm_tv_content = convertView.findViewById(R.id.comm_tv_content);
        //TextView comm_tv_policy = convertView.findViewById(R.id.comm_tv_policy);

        CommunityDTO dto = list.get(position);
        comm_tv_id.setText(dto.getUsers_id());
        comm_tv_date.setText(dto.getCommunity_date());
        comm_tv_content.setText(dto.getCommunity_content());
        //comm_tv_policy.setText(dto.getCommunity_policy());
        Context context = parent.getContext();
        if (convertView == null)
        {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.communitylist,parent, false);
        }

        TextView tv_community_title= convertView.findViewById(R.id.tv_community_title);
        TextView tv_community_star= convertView.findViewById(R.id.tv_community_star);
        TextView tv_community_rating= convertView.findViewById(R.id.tv_community_rating);
        TextView tv_community_person= convertView.findViewById(R.id.tv_community_person);
        CommunityDTO community=communityDTO.get(position);
        tv_community_title.setText(community.getTv_community_title());
        tv_community_star.setText(community.getTv_community_star());
        tv_community_rating.setText(community.getTv_community_rating());
        tv_community_person.setText(community.getTv_community_person());



        return convertView;
    }
    public void addItem(String comm_tv_id, String comm_tv_date, String comm_tv_content){
        CommunityDTO dto = new CommunityDTO(comm_tv_id,comm_tv_date,comm_tv_content);
        list.add(dto);
    public void addItem(String tv_community_title, String tv_community_star, String tv_community_rating, String tv_community_person) {
        CommunityDTO community=new CommunityDTO(tv_community_title,tv_community_star,tv_community_rating,tv_community_person);
        communityDTO.add(community);

    }
}
