package creational.factory;

public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "economy":
                return new EconomyCar();
            case "luxury":
                return new LuxuryCar();
            case "suv":
                return new SUV();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
