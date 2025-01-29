package wiprotraining;

public class Varaibles {
    // Instance variable
    private int instanceVariable = 10;

    // Static variable
    private static int staticVariable = 20;

    public void displayVariables() {
        // Local variable
        int localVariable = 30;

        System.out.println("Local Variable: " + localVariable);
        System.out.println("Instance Variable: " + instanceVariable);
        System.out.println("Static Variable: " + staticVariable);
    }

    public static void main(String[] args) {
        // Create an object of the class
        Varaibles demo1 = new Varaibles();
        Varaibles demo2 = new Varaibles();

        // Display variables using demo1
        System.out.println("Demo1:");
        demo1.displayVariables();

        // Modify instance and static variables
        demo1.instanceVariable = 50;
        Varaibles.staticVariable = 100;

        // Display variables using demo2
        System.out.println("\nDemo2:");
        demo2.displayVariables();

        // Display static variable using class name
        System.out.println("\nStatic Variable Access via Class Name: " + Varaibles.staticVariable);
    }
}
