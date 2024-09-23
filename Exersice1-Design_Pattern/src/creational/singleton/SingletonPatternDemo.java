package creational.singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        SpaceStationManager stationManager = SpaceStationManager.getInstance();
        stationManager.monitorSystems();
    }
}