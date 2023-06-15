package com.example.assignment.model;

import java.io.Serializable;

public class nhanvien implements Serializable {
    private String ma;
    private String ten;
    private String phongBan;

    public nhanvien() {
    }

    public nhanvien(String ma, String ten, String phongBan) {
        this.ma = ma;
        this.ten = ten;
        this.phongBan = phongBan;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
}
