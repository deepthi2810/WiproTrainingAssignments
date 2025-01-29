package vrs;


public abstract class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentalRatePerDay;
    private boolean isRented;

    public Vehicle(String vehicleId, String brand, String model, double rentalRatePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentalRatePerDay = rentalRatePerDay;
        this.isRented = false;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentVehicle() {
        this.isRented = true;
    }

    public void returnVehicle() {
        this.isRented = false;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (ID: " + vehicleId + ") - ₹" + rentalRatePerDay + "/day";
    }
}
