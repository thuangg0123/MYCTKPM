package domain;

import java.util.Date;

public class HangThucPham extends HangHoa {
    private Date ngaySX;
    private Date ngayHH;
    private String nhaCC;

    public HangThucPham(String maHH, String tenHang, int slTon, Double donGia, Date ngaySX, Date ngayHH, String nhaCC) {
        super(maHH, tenHang, slTon, donGia);
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.nhaCC = nhaCC;
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
    public Date getNgayHH() {
        return ngayHH;
    }

    @Override
    public String getNhaCC() {
        return nhaCC;
    }
}
