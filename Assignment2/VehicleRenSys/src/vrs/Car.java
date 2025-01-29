package vrs;

public class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String vehicleId, String brand, String model, double rentalRatePerDay, int seatingCapacity) {
        super(vehicleId, brand, model, rentalRatePerDay);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public String toString() {
        return "Car: " + super.toString() + ", Seats: " + seatingCapacity;
    }
}
