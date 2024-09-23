package creational.factory;

public class VehicleFactoryDemo {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.createVehicle("suv");
        vehicle.getDescription();
    }
}
