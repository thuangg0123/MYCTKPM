package presentation.Command;

import domain.NguoiQuanLy;

public class TimKiem extends Command{
    private String tuKhoa;
    
    public TimKiem(NguoiQuanLy modelRemote, String tuKhoa) {
        super(modelRemote);
        this.tuKhoa = tuKhoa;
    }

    @Override
    public void execute() {
        modelRemote.timTTHH(tuKhoa);
    }
    
}
