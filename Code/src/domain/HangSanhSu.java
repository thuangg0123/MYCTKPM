package domain;
import java.util.Date;

public class HangSanhSu extends HangHoa {
    private Date ngayNK;
    private String nhaSX;

    public HangSanhSu(String maHH, String tenHH, int slTon, Double donGia, Date ngayNK, String nhaSX) {
        super(maHH, tenHH, slTon, donGia);
        this.ngayNK = ngayNK;
        this.nhaSX = nhaSX;
    }

    @Override
    double tinhVAT() {
        return 0.1 * donGia;
    }

    @Override
    public Date getNgayNK() {
        return ngayNK;
    }

    @Override
    public String getNhaSX() {
        return nhaSX;
    }
}
