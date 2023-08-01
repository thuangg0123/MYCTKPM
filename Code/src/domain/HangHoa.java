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
    
    public Date getThoiGianBH() {
        return null;
    }

    public void setThoiGianBH(Date date) {
    }

    public String getCongSuat() {
        return null;
    }

    public void setCongSuat(int i) {
    }
    
    public Date getNgayNhapKho() {
        return null;
    }

    public void setNgayNhapKho(Date date) {
    }

    public String getNhaSanXuat() {
        return null;
    }

    public void setNhaSanXuat(String string) {
    }

    public Date getNgaySX() {
        return null;
    }

    public void setNgaySX(Date date) {
    }

    public Date getNgayHetHan() {
        return null;
    }

    public void setNgayHetHan(Date date) {
    }

    public String getNhaCungCap() {
        return null;
    }

    public void setNhaCungCap(String string) {
    }
}
