package domain;

import java.util.Date;

public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;

    HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.maHang = maHang;
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

    public Date getThoiGianBH(HangDienMay hangDienMay) {
        return hangDienMay.getThoiGianBH();
    }

    public String getCongSuat(HangDienMay hangDienMay) {
        return hangDienMay.getCongSuat();
    }
}
