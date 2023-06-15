package com.example.assignment.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.NhanVien;
import com.example.assignment.R;
import com.example.assignment.Xfile;
import com.example.assignment.model.nhanvien;

import java.util.ArrayList;
import java.util.List;

public class nhanvienadapter extends BaseAdapter implements Filterable {
    private final Context context;

    private ArrayList<nhanvien> list,listOld;

    public nhanvienadapter(Context context, ArrayList<nhanvien> list) {
        this.context = context;
        this.list = list;
        this.listOld = list;
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
        convertView = inflater.inflate(R.layout.item_nhanvien,parent,false);
        nhanvien listnv = list.get(position);
        TextView tvMa = convertView.findViewById(R.id.txtMa);
        TextView tvHoTen = convertView.findViewById(R.id.txtHoTen);
        TextView tvPb = convertView.findViewById(R.id.txtPhongBan);

        tvMa.setText(listnv.getMa());
        tvHoTen.setText(listnv.getTen());
        tvPb.setText(listnv.getPhongBan());

        Button btnRemove = convertView.findViewById(R.id.btnxoa);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
                Xfile.ghiFile(context,"nv.txt",list);
                Toast.makeText(context, "Đã xoá", Toast.LENGTH_SHORT).show();
            }
        });
        nhanvien nv = list.get(position);
        Button btnUpdate = convertView.findViewById(R.id.btnupdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openDialog(nv);
            }
        });
        return convertView;
    }

    public void openDialog(nhanvien nv){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_listnhanvien_update,null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        //ánh xạ
        EditText txtMa = view.findViewById(R.id.txtMa_ud);
        EditText txtHoTen = view.findViewById(R.id.txtHoTen_ud);
        EditText txtPb = view.findViewById(R.id.txtPb_ud);
        Button btnSua = view.findViewById(R.id.btnud);
        txtMa.setText(nv.getMa());
        txtHoTen.setText(nv.getTen());
        txtPb.setText(nv.getPhongBan());

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv.setMa(txtMa.getText().toString());
                nv.setTen(txtHoTen.getText().toString());
                nv.setPhongBan(txtPb.getText().toString());
                dialog.dismiss();
                Xfile.ghiFile(context,"nv.txt",list);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String s = constraint.toString();
                if (s.isEmpty()){
                    list = (ArrayList<nhanvien>) listOld;
                }else {
                    List<nhanvien> lists = new ArrayList<>();
                    for (nhanvien nv: listOld) {
                        if (nv.getTen().toLowerCase().contains(s.toLowerCase())){
                            lists.add(nv);
                        }

                    }
                    list = (ArrayList<nhanvien>) lists;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = list;
                return  filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (ArrayList<nhanvien>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
