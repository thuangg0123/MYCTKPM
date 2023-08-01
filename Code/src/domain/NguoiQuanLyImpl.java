package domain;

import java.util.List;

import pesistence.KhoDAO;
import pesistence.KhoDAOImpl;
import pesistence.KhoGatewayImpl;
import presentation.Subscriber;

public class NguoiQuanLyImpl implements NguoiQuanLy {
    private KhoDAO khoRemote;
    private List<HangHoa> hanghoaList;

    public NguoiQuanLyImpl() {
        khoRemote = new KhoDAOImpl(new KhoGatewayImpl());
    }

    @Override
    public void themHang(int loaiHang, HangHoa hanghoa) {
        khoRemote.themHang(loaiHang, hanghoa);
        xemTTAllHH();
    }

    @Override
    public void capnhatHang(int loaiHang, HangHoa hanghoa) {
        khoRemote.capnhatHang(loaiHang, hanghoa);
        xemTTAllHH();
    }

    @Override
    public void xoaHang(String maHang) {
        khoRemote.xoaHang(maHang);
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
	    }
    }

    @Override
    public HangHoa getDuLieu(String maHang) {
        return khoRemote.getDuLieu(maHang);
    }

    @Override
    public double tinhVAT(HangHoa hanghoa) {
        return hanghoa.tinhVAT();
    }
}
