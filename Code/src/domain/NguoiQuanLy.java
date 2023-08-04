package domain;

//Model
public interface NguoiQuanLy extends Publisher {

    void sapXepSanPham(String tieuchisapxep);

    void xuatFileTxt();

    void themHang(int loaiHang, HangHoa hanghoa);

    void capnhatHang(int loaiHang, HangHoa hanghoa);

    void xoaHang(String maHang);

    void xemTTAllHH();

    HangHoa xemThongTin1HH(String maHang);

    void timTTHH(String thongtin);

    double tinhVAT(HangHoa hanghoa);

    int tongHangThucPham();

    int tongHangDienMay();

    int tongHangSanhSu();
}
