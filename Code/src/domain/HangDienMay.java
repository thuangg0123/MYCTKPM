package domain;
import java.util.Date;

public class HangDienMay extends HangHoa {
    private Date thoiGianBH;
    private String congSuat;

    HangDienMay(String maHang, String tenHang, int soLuongTon, int donGia, Date thoiGianBH, int congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBH = thoiGianBH;
        this.congSuat = congSuat+"W";
    }

    @Override
    public double tinhVAT() {
        return 0.1 * donGia;
    }

    public Date getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(Date thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat+"W";
    }
}
