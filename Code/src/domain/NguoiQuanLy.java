package domain;

import java.util.List;

//Model
public interface NguoiQuanLy {
    void themHang(int loaiHang, HangHoa hanghoa);
    void capnhatHang(int loaiHang, HangHoa hanghoa);
    void xoaHang(String maHang);
    void xemTTHH(String maHang); 
    List<HangHoa> xemTTAllHH(); 
    void timTTHH(String thongtin); 
}
