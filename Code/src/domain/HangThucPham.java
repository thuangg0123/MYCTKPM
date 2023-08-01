package domain;
import java.util.Date;

public class HangThucPham extends HangHoa {
    private Date ngaySX;
    private Date ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int soLuongTon, Double donGia, Date ngaySX, Date ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySX = ngaySX;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public double tinhVAT() {
        return 0.05 * donGia;
    }

    @Override
    public Date getNgaySX() {
        return ngaySX;
    }

    @Override
    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    @Override
    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    @Override
    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    @Override
    public String getNhaCungCap() {
        return nhaCungCap;
    }

    @Override
    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}
