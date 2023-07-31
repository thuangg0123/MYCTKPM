import java.util.Date;

public class HangThucPham extends HangHoa {
    private Date ngaySX;
    private Date ngayHetHan;
    private String nhaCungCap;

    HangThucPham(String maHang, String tenHang, int soLuongTon, int donGia, Date ngaySX, Date ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySX = ngaySX;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public void tinhVAT() {
        double tinhVAT = 0.05 * (double) this.donGia;
        System.out.println(">>>> VAT của Hang Dien May: " + tinhVAT);
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}
