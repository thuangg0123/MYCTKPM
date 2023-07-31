package domain;

import java.util.List;

import pesistence.KhoDAO;

public class NguoiQuanLyImpl implements NguoiQuanLy{
    private KhoDAO KhoRemote;

    @Override
    public void themHang(int loaiHang, HangHoa hanghoa) {
    }

    @Override
    public void capnhatHang(int loaiHang, HangHoa hanghoa) {

    }

    @Override
    public void xoaHang(String maHang) {

    }

    @Override
    public void xemTTHH(String maHang) {

    }

    @Override
    public List<HangHoa> xemTTAllHH() {
        return null;
    }

    @Override
    public void timTTHH(String thongtin) {

    }


}
