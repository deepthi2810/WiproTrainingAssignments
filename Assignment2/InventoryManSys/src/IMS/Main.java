package IMS;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Check Low Stock");
            System.out.println("6. Supply Product");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    inventory.addProduct(new Product(productId, name, quantity, price));
                    break;

                case 2: 
                    System.out.print("Enter product ID to update: ");
                    int updateProductId = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();
                    inventory.updateProduct(updateProductId, newQuantity, newPrice);
                    break;

                case 3: 
                    System.out.print("Enter product ID to remove: ");
                    int removeProductId = scanner.nextInt();
                    scanner.nextLine();
                    inventory.removeProduct(removeProductId);
                    break;

                case 4:
                    System.out.println("Inventory Details:");
                    inventory.viewInventory();
                    break;

                case 5: 
                    System.out.print("Enter low stock threshold: ");
                    int threshold = scanner.nextInt();
                    scanner.nextLine();
                    inventory.checkLowStock(threshold);
                    break;

                case 6: 
                    System.out.print("Enter product ID to supply: ");
                    int supplyProductId = scanner.nextInt();
                    System.out.print("Enter quantity to supply: ");
                    int supplyQuantity = scanner.nextInt();
                    scanner.nextLine();
                    Product product = inventory.products.stream()
                            .filter(p -> p.getProductId() == supplyProductId)
                            .findFirst()
                            .orElse(null);
                    if (product != null) {
                        inventory.supplyProduct(product, supplyQuantity);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 7: 
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
