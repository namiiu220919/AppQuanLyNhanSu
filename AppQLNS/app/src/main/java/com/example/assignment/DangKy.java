package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DangKy extends AppCompatActivity {
//    private final Context context;
//
//    ArrayList<ArrayList<User>> listuser = new ArrayList<ArrayList<User>>();
//
//    public DangKy(Context context) {
//        this.context = context;
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        EditText txtRePassword = findViewById(R.id.txtRePassword);
        Button btnTroVe = findViewById(R.id.btnTroVe);
        Button btnDangKy = findViewById(R.id.btnDangKy);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUsername.getText().toString();
                String pass = txtPassword.getText().toString();
                String rePass = txtRePassword.getText().toString();
                if(TextUtils.isEmpty(user)|TextUtils.isEmpty(pass)|TextUtils.isEmpty(rePass)){
                    Toast.makeText(DangKy.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(rePass)){
                        ArrayList<User> list1 = new ArrayList<>();
                        Toast.makeText(DangKy.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangKy.this,DangNhap.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("user",user);
                        bundle.putString("pass",pass);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else{
                        Toast.makeText(DangKy.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }
                }
//               writeUser(context,"user.txt",listuser);
            }
        });
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKy.this,DangNhap.class);
                startActivity(intent);
            }
        });
    }

//    public void writeUser(Context context, String fileName){
//        try {
//            FileOutputStream fos = context.openFileOutput(fileName,Context.MODE_PRIVATE);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            listuser.add(User);
//            oos.writeObject(User);
//            oos.close();
//            fos.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }


}