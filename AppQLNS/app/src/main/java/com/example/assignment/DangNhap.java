package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DangNhap extends AppCompatActivity {
    EditText txtUser,txtPass;
    Button btnDangNhap,btnDangKy;
    CheckBox chkRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        //ánh xạ
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKy = findViewById(R.id.btnDangKy);
        chkRemember = findViewById(R.id.chkRemember);


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Bundle bundle = i.getExtras();
                if(bundle!=null){
                    String username = bundle.getString("user");
                    String password = bundle.getString("pass");
                    Boolean u = username.equals(txtUser.getText().toString());
                    Boolean p = password.equals(txtPass.getText().toString());
                    if(u&&p){
                        Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(DangNhap.this, "Kiểm tra lại tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }else{
                    Toast.makeText(DangNhap.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(DangNhap.this,Menu.class);
                startActivity(intent);

            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, DangKy.class);
                startActivity(intent);
            }
        });


    }
    public void remember(String user, String pass, boolean chkRemember){
        SharedPreferences sharedPreferences = getSharedPreferences("remember",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user",user);
        editor.putString("pass",pass);
        editor.putBoolean("chkRemember",chkRemember);
        editor.apply();
    }

    public void checkRemember(){
        SharedPreferences sharedPreferences = getSharedPreferences("remember",MODE_PRIVATE);
        String user = sharedPreferences.getString("user","");
        String pass = sharedPreferences.getString("pass","");
        boolean chkRemember1 = sharedPreferences.getBoolean("chkRemember",false);
        chkRemember.setChecked(chkRemember1);
        if (chkRemember.isChecked()){
            txtUser.setText(user);
            txtPass.setText(pass);
        }
    }




//    public List<User> readUser(Context context, String fileName){
//        List<User> objectList = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = context.openFileInput(fileName);
//            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
//            objectList = (List<User>) ois.readObject();
//            ois.close();
//            fileInputStream.close();
//        }catch (IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        return objectList;
//    }


}