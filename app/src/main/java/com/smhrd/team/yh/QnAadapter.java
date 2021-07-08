package com.smhrd.team.yh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QnAadapter extends BaseAdapter {
    private ArrayList<ListViewQnA> listViewQnAList = new ArrayList<ListViewQnA>();

    @Override
    public int getCount() {
        return listViewQnAList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewQnAList.get(position);
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
            convertView = inflater.inflate(R.layout.qna,parent,false);
        }

        TextView q = convertView.findViewById(R.id.tv_q);
        Button open = convertView.findViewById(R.id.btn_open);

        ListViewQnA listViewQnA= listViewQnAList.get(position);
        q.setText(listViewQnA.getQ());
        open.setOnClickListener((View.OnClickListener) listViewQnA.getOpen());

        return convertView;

    }
    public void addQnA(String q, Button open){
        ListViewQnA listViewQnA = new ListViewQnA();
        listViewQnA.setQ(q);
        listViewQnA.setOpen(open);
        listViewQnAList.add(listViewQnA);
    }
}
