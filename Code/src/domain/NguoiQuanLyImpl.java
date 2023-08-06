package domain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

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
        for (Subscriber s : subscribers) {
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
        tongTonKho[0] = Integer.toString(khoRemote.tongHangThucPham());
    }

    public void tongHangDienMay() {
        tongTonKho[1] = Integer.toString(khoRemote.tongHangDienMay());
    }

    public void tongHangSanhSu() {
        tongTonKho[2] = Integer.toString(khoRemote.tongHangSanhSu());
    }

    @Override
    public void xemDSHetHan() {
        hanghoaList = khoRemote.xemDSHetHan();
        notifySubscribers();
    }

    @Override
    public void xuatFileTxt() {
        String tenFile = "danh_sach_hang_hoa";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile + ".txt"))) {
            for (HangHoa hangHoa : hanghoaList) {
                writer.write(hangHoa.getMaHang() + "\t" + hangHoa.getTenHang() + "\t" + hangHoa.getSoLuongTon() + "\t"
                        + hangHoa.getDonGia() + "\t" + hangHoa.getNgaySX() + "\t" + hangHoa.getNgayHetHan() + "\t"
                        + hangHoa.getNhaCungCap() + "\t" + hangHoa.getThoiGianBH() + "\t" + hangHoa.getCongSuat()
                        + "\t" + hangHoa.getNgayNhapKho() + "\t" + hangHoa.getNhaSanXuat() + "\n");
            }
            JOptionPane.showMessageDialog(null, "Xuất file thành công!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất file: " + e.getMessage(), "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void sapXepSanPham(String tieuchisapxep) {
        Collections.sort(hanghoaList, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa hh1, HangHoa hh2) {
                if (tieuchisapxep.equals("maHang")) {
                    return hh1.getMaHang().compareTo(hh2.getMaHang());
                } else if (tieuchisapxep.equals("tenHang")) {
                    return hh1.getTenHang().compareTo(hh2.getTenHang());
                } else if (tieuchisapxep.equals("soLuongTon")) {
                    return Integer.compare(hh1.getSoLuongTon(), hh2.getSoLuongTon());
                } else if (tieuchisapxep.equals("donGia")) {
                    return Double.compare(hh1.getDonGia(), hh2.getDonGia());
                } else {
                    return hh1.getMaHang().compareTo(hh2.getMaHang());
                }
            }
        });
        notifySubscribers();
    }
}
