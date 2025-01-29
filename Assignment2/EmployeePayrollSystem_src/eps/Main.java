package eps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nEmployee Payroll System");
            System.out.println("1. Add Permanent Employee");
            System.out.println("2. Add Contractual Employee");
            System.out.println("3. Generate Payroll Report");
            System.out.println("4. Calculate Salary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int permId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String permName = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String permDept = scanner.nextLine();
                    System.out.print("Enter basic salary: ");
                    double permSalary = scanner.nextDouble();
                    System.out.print("Enter bonus: ");
                    double permBonus = scanner.nextDouble();
                    payroll.addEmployee(new PermanentEmployee(permId, permName, permDept, permSalary, permBonus));
                    break;

                case 2:
                    System.out.print("Enter employee ID: ");
                    int contractId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String contractName = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String contractDept = scanner.nextLine();
                    System.out.print("Enter basic salary: ");
                    double contractSalary = scanner.nextDouble();
                    System.out.print("Enter contract duration (in months): ");
                    int duration = scanner.nextInt();
                    payroll.addEmployee(new ContractualEmployee(contractId, contractName, contractDept, contractSalary, duration));
                    break;

                case 3:
                    payroll.generateReport();
                    break;

                case 4:
                    System.out.print("Enter employee ID to calculate salary: ");
                    int empId = scanner.nextInt();
                    Employee found = null;
                    for (Employee emp : payroll.getEmployees()) {
                        if (emp.getEmployeeId() == empId) {
                            found = emp;
                            break;
                        }
                    }
                    if (found != null) {
                        double salary = payroll.calculateSalary(found);
                        System.out.println("Total Salary: " + salary);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

