package behavioral.command;

public class SpaceStationCommandDemo {
    public static void main(String[] args) {
        LifeSupportSystem lifeSupport = new LifeSupportSystem();
        Command activateLifeSupport = new ActivateLifeSupportCommand(lifeSupport);
        Command deactivateLifeSupport = new DeactivateLifeSupportCommand(lifeSupport);
        
        SpaceStationCommandDispatcher dispatcher = new SpaceStationCommandDispatcher();
        
        dispatcher.executeCommand(activateLifeSupport);
        dispatcher.executeCommand(deactivateLifeSupport);
    }
}
