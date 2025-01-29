package IMS;


import java.util.ArrayList;
import java.util.List;

public class Inventory implements Supplier {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = products.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst()
                .orElse(null);

        if (product != null) {
            product.setQuantity(quantity);
            System.out.println("Updated quantity for product: " + product.getName());
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.getProductId() == productId);
        System.out.println("Product removed.");
    }

    public void checkLowStock(int threshold) {
        products.stream()
                .filter(p -> p.getQuantity() < threshold)
                .forEach(p -> System.out.println("Low stock alert: " + p));
    }

    @Override
    public void supplyProduct(Product product, int quantity) {
        product.setQuantity(product.getQuantity() + quantity);
        System.out.println("Supplied " + quantity + " units of: " + product.getName());
    }

    public void viewInventory() {
        products.forEach(System.out::println);
    }
}

