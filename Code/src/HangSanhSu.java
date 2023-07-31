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
    void tinhVAT() {
        double tinhVAT = 0.1 * (double) this.donGia;
        System.out.println(">>>> VAT của Hang Dien May: " + tinhVAT);
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
