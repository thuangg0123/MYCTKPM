package tuan7;

public abstract class Command {

    protected TempConverter modelRemote;

    public abstract void execute();

    public void setModelRemote(TempConverter modelRemote) {
        this.modelRemote = modelRemote;
    }

    public Command(){}

    public Command(TempConverter modelRemote) {
        this.modelRemote = modelRemote;
    }

    
    
}
