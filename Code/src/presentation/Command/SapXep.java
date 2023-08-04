package presentation.Command;

import domain.HangHoa;
import domain.NguoiQuanLy;

public class SapXep extends Command {
    private int loaiHang;
    private HangHoa hanghoa;
    private String tieuchisapxep;

    public SapXep(NguoiQuanLy modelRemote, int loaiHang, HangHoa hanghoa, String tieuchisapxep) {
        super(modelRemote);
        this.loaiHang = loaiHang;
        this.hanghoa = hanghoa;
        this.tieuchisapxep = tieuchisapxep;
    }

    @Override
    public void execute() {
        modelRemote.sapXepSanPham(tieuchisapxep);

        modelRemote.themHang(loaiHang, hanghoa);
    }
}
