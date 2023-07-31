import java.util.Date;

public class HangDienMay extends HangHoa {
    private Date thoiGianBH;
    private int congSuat;

    HangDienMay(String maHang, String tenHang, int soLuongTon, int donGia, Date thoiGianBH, int congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBH = thoiGianBH;
        this.congSuat = congSuat;
    }

    @Override
    public void tinhVAT() {
        double tinhVAT = 0.1 * (double) this.donGia;
        System.out.println(">>>> VAT của Hang Dien May: " + tinhVAT);
    }

    public Date getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(Date thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }
}
