package com.example.assignment.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.spphongban;

import java.util.ArrayList;

public class spphongbanadapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<spphongban> list;

    public spphongbanadapter(Context context, ArrayList<spphongban> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_phongban,parent,false);
        //ánh xạ
        ImageView imgHinh = convertView.findViewById(R.id.imgHinh);
        TextView txtCoSo = convertView.findViewById(R.id.txtPhongBan);
        //cập nhật dữ liệu (gán dữ liệu)
        imgHinh.setImageResource(list.get(position).getHinh());
        txtCoSo.setText(list.get(position).getTenpb());
        return convertView;
    }
}
