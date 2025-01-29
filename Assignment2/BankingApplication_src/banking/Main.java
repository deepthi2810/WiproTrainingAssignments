package banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBanking System");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String savingsAccNumber = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double savingsBalance = scanner.nextDouble();
                    System.out.print("Enter interest rate: ");
                    double interestRate = scanner.nextDouble();
                    accounts.add(new SavingsAccount(savingsAccNumber, savingsBalance, interestRate));
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String currentAccNumber = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double currentBalance = scanner.nextDouble();
                    System.out.print("Enter overdraft limit: ");
                    double overdraftLimit = scanner.nextDouble();
                    accounts.add(new CurrentAccount(currentAccNumber, currentBalance, overdraftLimit));
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String depositAccNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    for (Account acc : accounts) {
                        if (acc.getAccountNumber().equals(depositAccNumber)) {
                            acc.deposit(depositAmount);
                            System.out.println("Deposit successful.");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String withdrawAccNumber = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    for (Account acc : accounts) {
                        if (acc.getAccountNumber().equals(withdrawAccNumber)) {
                            acc.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;

                case 5:
                    for (Account acc : accounts) {
                        System.out.println(acc);
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
