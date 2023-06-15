package com.example.assignment.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.phongban;

import java.util.ArrayList;
import java.util.List;

public class phongbanadapter extends BaseAdapter implements Filterable {

    Activity activity;
    private final ArrayList<phongban> listOld;
    private ArrayList<phongban> list;

    public phongbanadapter(Activity activity,ArrayList<phongban> list) {
        this.activity = activity;
        this.listOld = list;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_listphongban, parent, false);
        phongban listpb = list.get(position);
        TextView txtPhongBan = convertView.findViewById(R.id.txtPhongBan);
        txtPhongBan.setText(listpb.getTenPhongBan());
    return convertView;
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String s = constraint.toString();
                if (s.isEmpty()) {
                    list = listOld;
                } else {
                    List<phongban> listS = new ArrayList<>();
                    for (phongban pb : listOld) {
                        if (pb.getTenPhongBan().toLowerCase().contains(s.toLowerCase())) {
                            listS.add(pb);
                        }
                    }
                    list = (ArrayList<phongban>) listS;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (ArrayList<phongban>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}


