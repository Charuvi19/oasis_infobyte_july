import java.util.ArrayList;
import java.util.Scanner;

public class task3 {
    private static ArrayList<String> transactionHistory = new ArrayList<>();
    private static double balance = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the ATM!");

            boolean quit = false;
            while (!quit) {
                System.out.println("\nPlease select an option:");
                System.out.println("1. View transaction history");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                int option = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character from the input buffer

                switch (option) {
                    case 1:
                        viewTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); // Clear the newline character from the input buffer
                        withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); // Clear the newline character from the input buffer
                        deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter the amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        scanner.nextLine(); // Clear the newline character from the input buffer
                        System.out.print("Enter the recipient's account number: ");
                        String recipientAccount = scanner.nextLine();
                        transfer(transferAmount, recipientAccount);
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }

        System.out.println("Thank you for using the ATM!");
    }

    private static void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdraw: " + amount);
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private static void deposit(double amount) 
    {
        balance += amount;
        transactionHistory.add("Deposit: " + amount);
        System.out.println("Deposit successful. Current balance: " + balance);
    }


    private static void transfer(double amount, String recipientAccount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Transfer: " + amount + " to account " + recipientAccount);
            System.out.println("Transfer successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}
