package vrs;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public Rental(Customer customer, Vehicle vehicle, LocalDate rentalDate, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.returnDate = rentalDate.plusDays(rentalDays);
        vehicle.rentVehicle(); // Mark vehicle as rented
    }

    public long calculateRentalCost() {
        long daysRented = ChronoUnit.DAYS.between(rentalDate, returnDate);
        return (long) (daysRented * vehicle.getRentalRatePerDay());
    }

    public void returnVehicle() {
        vehicle.returnVehicle(); // Mark vehicle as returned
    }

    @Override
    public String toString() {
        return customer.getName() + " rented " + vehicle.getBrand() + " " + vehicle.getModel() +
                " from " + rentalDate + " to " + returnDate + " - Cost: ₹" + calculateRentalCost();
    }
}

