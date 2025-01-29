package hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        rooms.add(new StandardRoom(101, 1000));
        rooms.add(new DeluxeRoom(201, 2000));
        rooms.add(new StandardRoom(102, 1100));
        rooms.add(new DeluxeRoom(202, 2200));

        do {
            System.out.println("\nHotel Room Booking System");
            System.out.println("1. Add Customer");
            System.out.println("2. View Available Rooms");
            System.out.println("3. Book Room");
            System.out.println("4. View Bookings");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    customers.add(new Customer(customerId, customerName, contactNumber));
                    break;

                case 2: 
                    System.out.println("Available Rooms:");
                    rooms.stream()
                            .filter(room -> !room.isBooked())
                            .forEach(System.out::println);
                    break;

                case 3: 
                    System.out.print("Enter customer ID: ");
                    int customerForBooking = scanner.nextInt();
                    scanner.nextLine();
                    Customer customer = customers.stream()
                            .filter(c -> c.getCustomerId() == customerForBooking)
                            .findFirst()
                            .orElse(null);
                    if (customer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }

                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    Room room = rooms.stream()
                            .filter(r -> r.getRoomNumber() == roomNumber && !r.isBooked())
                            .findFirst()
                            .orElse(null);
                    if (room == null) {
                        System.out.println("Room not available!");
                        break;
                    }

                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    Date checkInDate = new Date(); 
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    Date checkOutDate = new Date(); 
                    bookings.add(new Booking(bookings.size() + 1, customer, room, checkInDate, checkOutDate));
                    System.out.println("Room booked successfully!");
                    break;

                case 4: 
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings found.");
                    } else {
                        bookings.forEach(System.out::println);
                    }
                    break;

                case 5: 
                    System.out.print("Enter booking ID to checkout: ");
                    int bookingId = scanner.nextInt();
                    scanner.nextLine();
                    Booking booking = bookings.stream()
                            .filter(b -> b.getBookingId() == bookingId)
                            .findFirst()
                            .orElse(null);
                    if (booking != null) {
                        booking.checkout();
                        System.out.println("Checked out successfully!");
                    } else {
                        System.out.println("Booking not found!");
                    }
                    break;

                case 6: 
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
