package domain;

import java.util.List;

import pesistence.KhoDAO;
import pesistence.KhoDAOImpl;
import pesistence.KhoGatewayImpl;

public class NguoiQuanLyImpl extends Publisher implements NguoiQuanLy {
    private KhoDAO khoRemote;

    public NguoiQuanLyImpl() {
        khoRemote = new KhoDAOImpl(new KhoGatewayImpl());
    }

    @Override
    public void themHang(int loaiHang, HangHoa hanghoa) {
        khoRemote.themHang(loaiHang, hanghoa);
        notifySubscribers(xemTTAllHH());
    }

    @Override
    public void capnhatHang(int loaiHang, HangHoa hanghoa) {
        khoRemote.capnhatHang(loaiHang, hanghoa);
        notifySubscribers(xemTTAllHH());
    }

    @Override
    public void xoaHang(String maHang) {
        khoRemote.xoaHang(maHang);
        notifySubscribers(xemTTAllHH());
    }

    @Override
    public void xemTTHH(String maHang) {
        khoRemote.xemTTAllHH();
        notifySubscribers(xemTTAllHH());

    }

    @Override
    public List<HangHoa> xemTTAllHH() {
        return khoRemote.xemTTAllHH();
    }

    @Override
    public List<HangHoa> timTTHH(String thongtin) {
        return khoRemote.timTTHH(thongtin);
    }
}
