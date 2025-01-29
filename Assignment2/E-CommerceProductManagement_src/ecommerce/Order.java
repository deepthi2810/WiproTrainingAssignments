package ecommerce;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalCost;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalCost = 0.0;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            products.add(new Product(product.getProductId(), product.getName(), product.getPrice(), quantity));
            totalCost += product.getPrice() * quantity;
            product.setQuantity(product.getQuantity() - quantity);
        } else {
            System.out.println("Insufficient stock for product: " + product.getName());
        }
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void saveOrderHistory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order_history.txt", true))) {
            writer.write("Order ID: " + orderId + "\n");
            writer.write("Customer: " + customer.getName() + "\n");
            writer.write("Products:\n");
            for (Product product : products) {
                writer.write(product + "\n");
            }
            writer.write("Total Cost: " + totalCost + "\n");
            writer.write("---------------------------\n");
        } catch (IOException e) {
            System.out.println("Error saving order history: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Order [ID=" + orderId + ", Customer=" + customer.getName() + ", Total Cost=" + totalCost + "]";
    }
}
