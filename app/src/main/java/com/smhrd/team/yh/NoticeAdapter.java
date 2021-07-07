package com.smhrd.team.yh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoticeAdapter extends BaseAdapter {
    private ArrayList<ListViewNotice> listViewNoticeList = new ArrayList<ListViewNotice>();

    @Override
    public int getCount() {
        return listViewNoticeList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewNoticeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.notice,parent,false);
        }

        TextView title = convertView.findViewById(R.id.tv_notice_title);
        TextView date = convertView.findViewById(R.id.tv_notice_date);

        ListViewNotice listViewNotice = listViewNoticeList.get(position);
        title.setText(listViewNotice.getTitle());
        date.setText(listViewNotice.getDate());

        return convertView;
    }
    public void addNotice(String title, String date){
        ListViewNotice listViewNotice = new ListViewNotice();
        listViewNotice.setTitle(title);
        listViewNotice.setDate(date);
        listViewNoticeList.add(listViewNotice);
    }
}
