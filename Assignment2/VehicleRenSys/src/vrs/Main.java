package vrs;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Rental> rentals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nVehicle Rental System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Vehicle");
            System.out.println("4. Return Vehicle");
            System.out.println("5. View Rentals");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Vehicle
                    System.out.print("Enter vehicle type (Car/Bike): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter vehicle ID: ");
                    String vehicleId = scanner.nextLine();
                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter rental rate per day: ");
                    double rate = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    if (type.equalsIgnoreCase("Car")) {
                        System.out.print("Enter seating capacity: ");
                        int seatingCapacity = scanner.nextInt();
                        scanner.nextLine();
                        vehicles.add(new Car(vehicleId, brand, model, rate, seatingCapacity));
                    } else if (type.equalsIgnoreCase("Bike")) {
                        System.out.print("Does it have a carrier (true/false): ");
                        boolean hasCarrier = scanner.nextBoolean();
                        scanner.nextLine();
                        vehicles.add(new Bike(vehicleId, brand, model, rate, hasCarrier));
                    } else {
                        System.out.println("Invalid vehicle type!");
                    }
                    System.out.println("Vehicle added successfully!");
                    break;

                case 2: // Add Customer
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    customers.add(new Customer(customerId, name, contactNumber));
                    System.out.println("Customer added successfully!");
                    break;

                case 3: // Rent Vehicle
                    System.out.print("Enter customer ID: ");
                    String rentCustomerId = scanner.nextLine();
                    Customer rentingCustomer = findCustomer(rentCustomerId);

                    System.out.print("Enter vehicle ID: ");
                    String rentVehicleId = scanner.nextLine();
                    Vehicle rentingVehicle = findVehicle(rentVehicleId);

                    System.out.print("Enter rental days: ");
                    int rentalDays = scanner.nextInt();
                    scanner.nextLine();

                    rentals.add(new Rental(rentingCustomer, rentingVehicle, LocalDate.now(), rentalDays));
                    System.out.println("Vehicle rented successfully!");
                    break;

                case 4:
                    System.out.println("Feature not implemented yet!");
                    break;

                case 5:
                    for (Rental rental : rentals) {
                        System.out.println(rental);
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;
            }
        } while (choice != 6);
        scanner.close();
    }

    private static Vehicle findVehicle(String vehicleId) {
        return vehicles.stream().filter(v -> v.getVehicleId().equals(vehicleId)).findFirst().orElse(null);
    }

    private static Customer findCustomer(String customerId) {
        return customers.stream().filter(c -> c.getCustomerId().equals(customerId)).findFirst().orElse(null);
    }
}
