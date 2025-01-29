package wiprotraining;

public class StaticvsNonStatic {
    // Static variable (shared by all objects)
    private static int staticCounter = 0;

    // Non-static (instance) variable (unique to each object)
    private int instanceCounter = 0;

    // Constructor to increment counters
    public StaticvsNonStatic() {
        staticCounter++; // Increments shared static variable
        instanceCounter++; // Increments instance-specific variable
    }

    // Method to display the values of counters
    public void showCounters() {
        System.out.println("Static Counter (shared): " + staticCounter);
        System.out.println("Instance Counter (unique): " + instanceCounter);
    }

    public static void main(String[] args) {
        // Create the first object
        System.out.println("Object 1:");
        StaticvsNonStatic obj1 = new StaticvsNonStatic();
        obj1.showCounters();

        // Create the second object
        System.out.println("\nObject 2:");
        StaticvsNonStatic obj2 = new StaticvsNonStatic();
        obj2.showCounters();

        // Create the third object
        System.out.println("\nObject 3:");
        StaticvsNonStatic obj3 = new StaticvsNonStatic();
        obj3.showCounters();
    }
}
