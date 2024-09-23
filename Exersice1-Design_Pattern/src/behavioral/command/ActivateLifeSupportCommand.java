package behavioral.command;

public class ActivateLifeSupportCommand implements Command {
    private LifeSupportSystem lifeSupport;

    public ActivateLifeSupportCommand(LifeSupportSystem lifeSupport) {
        this.lifeSupport = lifeSupport;
    }

    @Override
    public void execute() {
        lifeSupport.activate();
    }
}
