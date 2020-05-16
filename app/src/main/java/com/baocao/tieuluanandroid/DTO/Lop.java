package com.baocao.tieuluanandroid.DTO;

public class Lop {
    private int maLop;
    private String tenLop;

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Lop(int maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public Lop() {
    }

    @Override
    public String toString() {
        return tenLop;
    }
}
