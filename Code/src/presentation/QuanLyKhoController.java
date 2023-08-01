package presentation;

import presentation.Command.Command;

//Controller - CommandProsser
public class QuanLyKhoController {
    public void execute(Command command){
        command.execute();
    }
}
