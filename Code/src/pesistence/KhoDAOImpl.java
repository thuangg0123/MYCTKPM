package pesistence;

import java.util.List;

import domain.HangHoa;

public class KhoDAOImpl implements KhoDAO{
    private KhoGateway khoGatewayRemote;
    
    public KhoDAOImpl(KhoGateway khoGatewayRemote) {
        this.khoGatewayRemote = khoGatewayRemote;
    }

    @Override
    public void capnhatHang(int loaiHang, HangHoa hanghoa) {
        khoGatewayRemote.capnhatHang(loaiHang, hanghoa);
    }

    @Override
    public void themHang(int loaiHang, HangHoa hanghoa) {
        khoGatewayRemote.themHang(loaiHang, hanghoa);
    }

    @Override
    public void timTTHH(String thongtin) {
        khoGatewayRemote.timTTHH(thongtin);
    }

    @Override
    public List<HangHoa> xemTTAllHH() {
        return khoGatewayRemote.xemTTAllHH();
    }

    @Override
    public void xemTTHH(String maHang) {
        khoGatewayRemote.xemTTHH(maHang);
    }

    @Override
    public void xoaHang(String maHang) {
        khoGatewayRemote.xoaHang(maHang);
    }
    
}
