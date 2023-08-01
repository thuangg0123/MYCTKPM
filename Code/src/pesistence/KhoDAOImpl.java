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
    public List<HangHoa> timTTHH(String thongtin) {
        return khoGatewayRemote.timTTHH(thongtin);
    }

    @Override
    public List<HangHoa> xemTTAllHH() {
        return khoGatewayRemote.xemTTAllHH();
    }

    @Override
    public void xoaHang(String maHang) {
        khoGatewayRemote.xoaHang(maHang);
    }
    
    @Override
    public HangHoa getDuLieu(String maHang) {
        return khoGatewayRemote.getDuLieu(maHang);
    }
}
