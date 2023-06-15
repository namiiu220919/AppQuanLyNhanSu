package com.example.assignment;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.assignment.adapter.nhanvienadapter;
import com.example.assignment.model.nhanvien;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVien extends AppCompatActivity {
    nhanvienadapter adapter;
    ListView lstNV;
    private ArrayList<nhanvien> list = new ArrayList<nhanvien>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Phòng ban");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lstNV = findViewById(R.id.lstNhanVien);
        themdl();
        if(list != null){
            list = (ArrayList<nhanvien>) Xfile.docFile(NhanVien.this,"nv.txt");
        }
        //đổ dữ liệu
        adapter = new nhanvienadapter(this,list);
        lstNV.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    ActivityResultLauncher<Intent> getdl = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 1){
                Intent intent = result.getData();
                if(intent != null){
                    Bundle bundle = intent.getExtras();
                    String ma = bundle.getString("ma");
                    String ht = bundle.getString("ht");
                    String pb = bundle.getString("pb");
                    list.add(new nhanvien(ma,ht,pb));
                    Xfile.ghiFile(NhanVien.this, "nv1.txt",list);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    });

    public void themdl(){
        list.add(new nhanvien("NV01","Nguyễn Phương Nam","Đào tạo"));
        list.add(new nhanvien("NV02","Lưu Tuấn Quỳnh","Hành chính"));
        list.add(new nhanvien("NV03","Đào Văn Mạnh","Nhân sự"));
        list.add(new nhanvien("NV04","Hoàng Quang Vinh","Nhân sự"));
        list.add(new nhanvien("NV05","Phạm Quang Huy","Đào tạo"));
        list.add(new nhanvien("NV06","Nguyễn Văn Vũ","Nhân sự"));
        list.add(new nhanvien("NV07","Võ Viết Hoài","Hành chính"));
        list.add(new nhanvien("NV08","Lê Quang Sang","Đào tạo"));
        list.add(new nhanvien("NV09","Nguyễn Trung Thực","Hành chính"));
        list.add(new nhanvien("NV010","Nguyễn Duy Luân","Đào tạo"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else if (item.getItemId() == R.id.menu_add) {
            Intent intent = new Intent(NhanVien.this,ThemNV.class);
            getdl.launch(intent);
        } else if (item.getItemId() == R.id.menu_dangXuat) {
            Intent intent = new Intent(NhanVien.this, DangNhap.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}