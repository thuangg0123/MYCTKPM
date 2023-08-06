package presentation.Command;

import domain.NguoiQuanLy;

public class SapXep extends Command {
    private String tieuchisapxep;

    public SapXep(NguoiQuanLy modelRemote, String tieuchisapxep) {
        super(modelRemote);
        this.tieuchisapxep = tieuchisapxep;
    }

    @Override
    public void execute() {
        modelRemote.sapXepHH(tieuchisapxep);
    }
}
