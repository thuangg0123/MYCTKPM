package domain;

import java.util.List;

import pesistence.KhoDAO;
import pesistence.KhoDAOImpl;
import pesistence.KhoGatewayImpl;
import presentation.Subscriber;

public class NguoiQuanLyImpl implements NguoiQuanLy {
    private KhoDAO khoRemote;
    private List<HangHoa> hanghoaList;
    private String[] tongTonKho = new String[3];

    public NguoiQuanLyImpl() {
        khoRemote = new KhoDAOImpl(new KhoGatewayImpl());
    }

    @Override
    public void themHang(int loaiHang, HangHoa hanghoa) {
        khoRemote.themHang(loaiHang, hanghoa);
        tongTonKho();
        xemTTAllHH();
    }

    @Override
    public void capnhatHang(int loaiHang, HangHoa hanghoa) {
        khoRemote.capnhatHang(loaiHang, hanghoa);
        tongTonKho();
        xemTTAllHH();
    }

    @Override
    public void xoaHang(String maHang) {
        khoRemote.xoaHang(maHang);
        tongTonKho();
        xemTTAllHH();
    }

    @Override
    public void xemTTAllHH() {
        hanghoaList = khoRemote.xemTTAllHH();
        notifySubscribers();
    }

    @Override
    public void timTTHH(String thongtin) {
        hanghoaList = khoRemote.timTTHH(thongtin);
        notifySubscribers();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber); 

    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber); 
    }

    @Override
    public void notifySubscribers() {
		for(Subscriber s: subscribers) {
            s.update(hanghoaList);
            s.update(tongTonKho);
	    }
    }

    @Override
    public HangHoa xemThongTin1HH(String maHang) {
        return khoRemote.xemThongTin1HH(maHang);
    }

    @Override
    public double tinhVAT(HangHoa hanghoa) {
        return hanghoa.tinhVAT();
    }

    @Override
    public void tongTonKho() {
        tongHangThucPham();
        tongHangDienMay();
        tongHangSanhSu();
        notifySubscribers();
    }

    public void tongHangThucPham() {
        tongTonKho[0] = Integer.toString(khoRemote.tongHangThucPham()) ;
    }

    public void tongHangDienMay() {
        tongTonKho[1] = Integer.toString(khoRemote.tongHangDienMay()) ;
    }

    public void tongHangSanhSu() {
        tongTonKho[2] = Integer.toString(khoRemote.tongHangSanhSu()) ;
    }

    @Override
    public void xemDSHetHan() {
        hanghoaList = khoRemote.xemDSHetHan();
        notifySubscribers();        
    }
}
