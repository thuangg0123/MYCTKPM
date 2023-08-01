package presentation.Command;

import domain.HangHoa;
import domain.NguoiQuanLy;

public class CapNhat extends Command{
    private int loaiHang;
    private HangHoa hanghoa;

    public CapNhat(NguoiQuanLy modelRemote, int loaiHang, HangHoa hanghoa) {
        super(modelRemote);
        this.loaiHang = loaiHang;
        this.hanghoa = hanghoa;
    }

    @Override
    public void execute() {
        modelRemote.capnhatHang(loaiHang, hanghoa);
    }
    
}
