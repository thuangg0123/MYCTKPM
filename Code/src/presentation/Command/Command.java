package presentation.Command;

import domain.NguoiQuanLy;

public abstract class Command {
    NguoiQuanLy modelRemote;
    abstract void execute();
}
