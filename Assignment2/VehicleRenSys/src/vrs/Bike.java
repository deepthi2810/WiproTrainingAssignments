package vrs;


public class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String vehicleId, String brand, String model, double rentalRatePerDay, boolean hasCarrier) {
        super(vehicleId, brand, model, rentalRatePerDay);
        this.hasCarrier = hasCarrier;
    }

    public boolean hasCarrier() {
        return hasCarrier;
    }

    @Override
    public String toString() {
        return "Bike: " + super.toString() + ", Carrier: " + (hasCarrier ? "Yes" : "No");
    }
}
