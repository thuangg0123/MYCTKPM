package pesistence;

import java.util.List;
import domain.HangHoa;

public interface KhoGateway {
    void themHang(int loaiHang, HangHoa hanghoa);
    void capnhatHang(int loaiHang, HangHoa hanghoa);
    void xoaHang(String maHang);
    List<HangHoa> xemTTAllHH(); 
    HangHoa getDuLieu(String maHang);
    List<HangHoa> timTTHH(String thongtin); 
}
