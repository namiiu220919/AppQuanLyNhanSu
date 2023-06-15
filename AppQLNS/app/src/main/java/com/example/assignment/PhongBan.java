package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.SearchView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;



import com.example.assignment.adapter.phongbanadapter;
import com.example.assignment.model.phongban;

import java.util.ArrayList;

public class PhongBan extends AppCompatActivity {
    phongbanadapter adapter;
    ListView lstPhongBan;
    private ArrayList<phongban> list = new ArrayList<phongban>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Phòng ban");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ánh xạ
        lstPhongBan = findViewById(R.id.lstPhongBan);

        list.add(new phongban("Nhân sự"));
        list.add(new phongban("Hành chính"));
        list.add(new phongban("Đào tạo"));

        adapter = new phongbanadapter(this,list);
        lstPhongBan.setAdapter(adapter);

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

        } else if (item.getItemId() == R.id.menu_dangXuat) {
            Intent intent = new Intent(PhongBan.this, DangNhap.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}