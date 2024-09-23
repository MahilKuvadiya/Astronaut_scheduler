package creational.singleton;

public class SpaceStationManager {
    private static SpaceStationManager instance;

    private SpaceStationManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized SpaceStationManager getInstance() {
        if (instance == null) {
            instance = new SpaceStationManager();
        }
        return instance;
    }

    public void monitorSystems() {
        System.out.println("Monitoring space station systems.");
    }
}