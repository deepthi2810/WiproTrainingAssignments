package wiprotraining;

public class Calculator {
    // Static variable
    private static int count = 0;

    // Method with return type and static variable
    public static int add(int a, int b) {
        count++;
        return a + b;
    }

    public static int subtract(int a, int b) {
        count++;
        return a - b;
    }

    public static int multiply(int a, int b) {
        count++;
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        count++;
        return (double) a / b;
    }

    // Non-static methods without return type
    public void addAndPrint(int a, int b) {
        count++;
        System.out.println("Addition Result: " + (a + b));
    }

    public void subtractAndPrint(int a, int b) {
        count++;
        System.out.println("Subtraction Result: " + (a - b));
    }

    public void multiplyAndPrint(int a, int b) {
        count++;
        System.out.println("Multiplication Result: " + (a * b));
    }

    public void divideAndPrint(int a, int b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed.");
        } else {
            count++;
            System.out.println("Division Result: " + ((double) a / b));
        }
    }

    // Method without return type and non-static variable
    public void printCounter() {
        System.out.println("Number of operations performed: " + count);
    }

    public static void main(String[] args) {
        // Using static methods with return type
        System.out.println("Addition: " + Calculator.add(10, 5));
        System.out.println("Subtraction: " + Calculator.subtract(10, 5));
        System.out.println("Multiplication: " + Calculator.multiply(10, 5));
        System.out.println("Division: " + Calculator.divide(10, 5));

        // Using non-static methods without return type
        Calculator calc = new Calculator();
        calc.addAndPrint(15, 7);
        calc.subtractAndPrint(15, 7);
        calc.multiplyAndPrint(15, 7);
        calc.divideAndPrint(15, 7);

        // Using non-static method to print counter
        calc.printCounter();
    }
}
