package ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nE-commerce Product Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Add Customer");
            System.out.println("4. Create Order");
            System.out.println("5. View Orders");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();
                    products.add(new Product(productId, productName, productPrice, productQuantity));
                    break;

                case 2: 
                    System.out.print("Enter product ID to remove: ");
                    int productIdToRemove = scanner.nextInt();
                    products.removeIf(product -> product.getProductId() == productIdToRemove);
                    System.out.println("Product removed successfully.");
                    break;

                case 3: 
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String customerEmail = scanner.nextLine();
                    customers.add(new Customer(customerId, customerName, customerEmail));
                    break;

                case 4: 
                    System.out.print("Enter order ID: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    int customerIdForOrder = scanner.nextInt();
                    scanner.nextLine();
                    Customer customer = customers.stream()
                            .filter(c -> c.getCustomerId() == customerIdForOrder)
                            .findFirst()
                            .orElse(null);
                    if (customer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }
                    Order order = new Order(orderId, customer);
                    System.out.print("Enter product ID to add to order (or 0 to finish): ");
                    while (true) {
                        int prodId = scanner.nextInt();
                        if (prodId == 0) break;
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        Product product = products.stream()
                                .filter(p -> p.getProductId() == prodId)
                                .findFirst()
                                .orElse(null);
                        if (product != null) {
                            order.addProduct(product, quantity);
                        } else {
                            System.out.println("Product not found!");
                        }
                        System.out.print("Enter next product ID (or 0 to finish): ");
                    }
                    order.saveOrderHistory();
                    orders.add(order);
                    System.out.println("Order created successfully.");
                    break;

                case 5: 
                    if (orders.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        orders.forEach(System.out::println);
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
