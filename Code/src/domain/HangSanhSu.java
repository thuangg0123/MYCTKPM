package domain;
import java.util.Date;

public class HangSanhSu extends HangHoa {
    protected Date ngayNhapKho;
    protected String nhaSanXuat;

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, int donGia, Date ngayNhapKho, String nhaSanXuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngayNhapKho = ngayNhapKho;
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    double tinhVAT() {
        return 0.1 * donGia;
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}
