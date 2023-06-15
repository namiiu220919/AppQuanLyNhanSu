//package com.example.assignment.adapter;
//
//import android.app.Activity;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//import com.example.assignment.R;
//import com.example.assignment.model.User;
//
//import java.util.ArrayList;
//
//public class useradapter extends BaseAdapter {
//    private final Context context;
//    private ArrayList<User> list;
//
//    public useradapter(Context context, ArrayList<User> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
////        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
////        convertView = inflater.inflate(R.layout.activity_dang_ky,parent,false);
////        User listuser = list.get(position);
//
//    }
//}
