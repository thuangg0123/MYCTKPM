package domain;

public class HangDienMay extends HangHoa {
    private String thoiGianBH;
    private String congSuat;

    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, String thoiGianBH, String congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBH = thoiGianBH;
        this.congSuat = congSuat;
    }

    @Override
    public double tinhVAT() {
        return 0.1 * donGia;
    }

    @Override
    public String getThoiGianBH() {
        return thoiGianBH;
    }

    @Override
    public void setThoiGianBH(Double thoiGianBH) {
        this.thoiGianBH = thoiGianBH + "tháng";
    }

    @Override
    public String getCongSuat() {
        return congSuat;
    }

    @Override
    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat+"KW";
    }
}
