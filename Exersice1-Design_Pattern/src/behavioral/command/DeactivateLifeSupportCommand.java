package behavioral.command;

public class DeactivateLifeSupportCommand implements Command {
    private LifeSupportSystem lifeSupport;

    public DeactivateLifeSupportCommand(LifeSupportSystem lifeSupport) {
        this.lifeSupport = lifeSupport;
    }

    @Override
    public void execute() {
        lifeSupport.deactivate();
    }
}
