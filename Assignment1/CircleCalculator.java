package wiprotraining;

public class CircleCalculator {
    // Constant variable for PI
    private static final double PI = 3.14159;

    // Method to calculate area of a circle
    public static double calculateArea(double radius) {
        return PI * radius * radius; // Area = πr²
    }

    // Method to calculate circumference of a circle
    public static double calculateCircumference(double radius) {
        return 2 * PI * radius; // Circumference = 2πr
    }

    public static void main(String[] args) {
        double radius = 5.0; // Example radius

        // Calculate area and circumference
        double area = calculateArea(radius);
        double circumference = calculateCircumference(radius);

        // Display results
        System.out.println("For a circle with radius " + radius + ":");
        System.out.println("Area = " + area);
        System.out.println("Circumference = " + circumference);
    }
}

