package presentation.Command;

import domain.HangHoa;
import domain.NguoiQuanLy;

public class Them extends Command{
    private int loaiHang;
    private HangHoa hanghoa;

    public Them(NguoiQuanLy modelRemote, int loaiHang, HangHoa hanghoa) {
        super(modelRemote);
        this.loaiHang = loaiHang;
        this.hanghoa = hanghoa;
    }
    @Override
    public void execute() {
        modelRemote.themHang(loaiHang, hanghoa);
    }
    
}
