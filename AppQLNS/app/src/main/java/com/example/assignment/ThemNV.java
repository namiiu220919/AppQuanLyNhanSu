package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.assignment.adapter.spphongbanadapter;
import com.example.assignment.model.nhanvien;
import com.example.assignment.model.spphongban;

import java.util.ArrayList;

public class ThemNV extends AppCompatActivity {
    Spinner spinnerPb;
    String phongBan;
    private ArrayList<spphongban> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);
        //ánh xạ
        spinnerPb = findViewById(R.id.spinnerPb);
        //thêm đối tượng
        list.add(new spphongban(R.drawable.people,"Nhân sự"));
        list.add(new spphongban(R.drawable.laptop,"Đào tạo"));
        list.add(new spphongban(R.drawable.book,"Hành chính"));
        //đổ dữ liệu lên sp
        spphongbanadapter adapter = new spphongbanadapter(this,list);
        spinnerPb.setAdapter(adapter);

        //ánh xạ
        EditText txtMa = findViewById(R.id.txtMa);
        EditText txtHoTen = findViewById(R.id.txtHoTen);
        Button btnAdd = findViewById(R.id.btnAdd);

        //xử lý khi ấn add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemNV.this,NhanVien.class);
                Bundle bundle = new Bundle();
                //
                String ma = txtMa.getText().toString();
                String ht = txtHoTen.getText().toString();
                //gửi dl đi
                bundle.putString("ma",ma);
                bundle.putString("ht",ht);
                bundle.putString("pb",phongBan);
                //
                intent.putExtras(bundle);
                setResult(1,intent);
                finish();
            }
        });
        //Lấy giá trị tên cs khi chọn item trên spinner
        spinnerPb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                phongBan = list.get(position).getTenpb();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}