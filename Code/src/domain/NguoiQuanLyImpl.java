package domain;

import java.util.List;

import pesistence.KhoDAO;
import pesistence.KhoDAOImpl;
import pesistence.KhoGatewayImpl;

public class NguoiQuanLyImpl extends Publisher implements NguoiQuanLy {
    private KhoDAO KhoRemote;

    public NguoiQuanLyImpl() {
        KhoRemote = new KhoDAOImpl(new KhoGatewayImpl());
    }

    @Override
    public void themHang(int loaiHang, HangHoa hanghoa) {
        KhoRemote.themHang(loaiHang, hanghoa);
    }

    @Override
    public void capnhatHang(int loaiHang, HangHoa hanghoa) {
        KhoRemote.capnhatHang(loaiHang, hanghoa);
    }

    @Override
    public void xoaHang(String maHang) {
        KhoRemote.xoaHang(maHang);
    }

    @Override
    public void xemTTHH(String maHang) {
        KhoRemote.xemTTAllHH();
    }

    @Override
    public List<HangHoa> xemTTAllHH() {
        return KhoRemote.xemTTAllHH();
    }

    @Override
    public void timTTHH(String thongtin) {
        KhoRemote.timTTHH(thongtin);
    }
}
