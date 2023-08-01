package domain;
import java.util.Date;

public class HangSanhSu extends HangHoa {
    private Date ngayNhapKho;
    private String nhaSanXuat;

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, int donGia, Date ngayNhapKho, String nhaSanXuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngayNhapKho = ngayNhapKho;
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    double tinhVAT() {
        return 0.1 * donGia;
    }

    @Override
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

    @Override
    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }
    
    @Override
    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}
