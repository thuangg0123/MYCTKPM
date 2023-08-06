package domain;

import java.util.Date;

public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public HangHoa(String tenHang, int soLuongTon, double donGia) {
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    abstract double tinhVAT();

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getThoiGianBH() {
        return null;
    }

    public String getCongSuat() {
        return null;
    }

    public Date getNgayNhapKho() {
        return null;
    }

    public String getNhaSanXuat() {
        return null;
    }

    public Date getNgaySX() {
        return null;

        // if (ngaySX == null) {
        // // Return a default value or handle the case when ngaySX is null
        // // For example, you can return the minimum possible date value as a sentinel.
        // return new Date(Long.MIN_VALUE);
        // } else {
        // return ngaySX;
        // }
    }

    public Date getNgayHetHan() {
        return null;
    }

    public String getNhaCungCap() {
        return null;
    }
}
