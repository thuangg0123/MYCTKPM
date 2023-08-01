package domain;

import java.util.Date;

public class HangDienMay extends HangHoa {
    private Date thoiGianBH;
    private String congSuat;

    public HangDienMay(String maHang, String tenHang, int soLuongTon, int donGia, Date thoiGianBH, int congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBH = thoiGianBH;
        this.congSuat = congSuat + "W";
    }

    @Override
    public double tinhVAT() {
        return 0.1 * donGia;
    }

    @Override
    public Date getThoiGianBH() {
        return thoiGianBH;
    }

    @Override
    public void setThoiGianBH(Date thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    @Override
    public String getCongSuat() {
        return congSuat;
    }

    @Override
    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }
}
