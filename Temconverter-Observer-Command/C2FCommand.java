package tuan7;

public class C2FCommand extends Command{

    public C2FCommand(TempConverter modelRemote){
        super(modelRemote);
    }

    @Override
    public void execute() {
        modelRemote.c2f();
        //test github
        
    }
    
}
