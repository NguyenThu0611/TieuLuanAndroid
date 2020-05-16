package com.baocao.tieuluanandroid.DTO;

public class SinhVien {
    private String ten;
    private int tuoi;
    private int lop;

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public SinhVien(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.lop = -1;
    }

    public SinhVien(String ten, int tuoi, int lop){
        this.ten = ten;
        this.tuoi = tuoi;
        this.lop = lop;
    }

    public SinhVien() {
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                '}';
    }
}
