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
    //position에 위치한 데이터를 화면에 출력하는데 사용될 View 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //notice.xml 가져와서 내 ViewGroup 넣어주기
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.notice,parent,false);
        }
        // View 객체들 찾기
        TextView title = convertView.findViewById(R.id.tv_notice_title);
        TextView date = convertView.findViewById(R.id.tv_notice_date);
        // View 해당위치 아이템 넣기
        ListViewNotice listViewNotice = listViewNoticeList.get(position);
        title.setText(listViewNotice.getTitle());
        date.setText(listViewNotice.getDate());
        //해당 위치 View 리턴
        return convertView;
    }
    public void addNotice(String title, String date){    //추가하는 메소드생성
        ListViewNotice listViewNotice = new ListViewNotice();
        listViewNotice.setTitle(title);
        listViewNotice.setDate(date);
        listViewNoticeList.add(listViewNotice);
    }
}
