package com.smhrd.team.yh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QnAadapter extends BaseAdapter { //어댑터 클래스 상속
    private ArrayList<ListViewQnA> listViewQnAList = new ArrayList<ListViewQnA>();

    @Override
    public int getCount() {
        return listViewQnAList.size();
    } //listViewQnAList 갯수만큼

    @Override
    public Object getItem(int position) {
        return listViewQnAList.get(position);
    } // 포지션

    @Override
    public long getItemId(int position) {
        return position;
    } // 포지션으로 리턴
      //position에 위치한 데이터를 화면에 출력하는데 사용될 View 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //qna.xml 가져와서 내 ViewGroup 넣어주기
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.qna,parent,false);
        }
        // View 객체들 찾기
        TextView q = convertView.findViewById(R.id.tv_q);
        Button open = convertView.findViewById(R.id.btn_open);

        // View 해당위치 아이템 넣기
        ListViewQnA listViewQnA= listViewQnAList.get(position);
        q.setText(listViewQnA.getQ());
        open.setOnClickListener((View.OnClickListener) listViewQnA.getOpen());

        //해당 위치 View 리턴
        return convertView;

    }
    public void addQnA(String q, Button open){      //add 메소드 생성
        ListViewQnA listViewQnA = new ListViewQnA();
        listViewQnA.setQ(q);
        listViewQnA.setOpen(open);
        listViewQnAList.add(listViewQnA);
    }
}
