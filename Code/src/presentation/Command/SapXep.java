package presentation.Command;

public class SapXep extends Command {
    private String tieuchi;

    public SapXep(String tieuchi) {
        this.tieuchi = tieuchi;
    }

    @Override
    public void execute() {
        facadeRemote.sapXepHH(tieuchi);
    }
}
