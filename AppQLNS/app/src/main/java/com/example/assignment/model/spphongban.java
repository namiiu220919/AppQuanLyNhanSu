package com.example.assignment.model;

public class spphongban {
    private int hinh;
    private String tenpb;

    public spphongban() {
    }

    public spphongban(int hinh, String tenpb) {
        this.hinh = hinh;
        this.tenpb = tenpb;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }
}
