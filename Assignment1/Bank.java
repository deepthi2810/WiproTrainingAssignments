package wiprotraining;

public class Bank {
    // Instance variables
    private String accountHolderName;
    private int balance;

    // Constructor
    public Bank(String accountHolderName, int initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully. Current balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a new bank account
        Bank account = new Bank("Deepthi Lochana", 5000);

        // Perform operations
        account.checkBalance();    // Check initial balance
        account.deposit(2000);     // Deposit money
        account.withdraw(1500);    // Withdraw money
        account.withdraw(7000);    // Attempt to withdraw more than balance
        account.checkBalance();    // Check final balance
    }
}
