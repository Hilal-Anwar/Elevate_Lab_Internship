package org.helal_anwar.task5;

import java.util.Scanner;

public class BankSimulation {
    public static void main(String[] args) {
        String info = """
                __________                __        _________.__              .__          __  .__              \s
                \\______   \\_____    ____ |  | __   /   _____/|__| _____  __ __|  | _____ _/  |_|__| ____   ____ \s
                 |    |  _/\\__  \\  /    \\|  |/ /   \\_____  \\ |  |/     \\|  |  \\  | \\__  \\\\   __\\  |/  _ \\ /    \\\s
                 |    |   \\ / __ \\|   |  \\    <    /        \\|  |  Y Y  \\  |  /  |__/ __ \\|  | |  (  <_> )   |  \\
                 |______  /(____  /___|  /__|_ \\  /_______  /|__|__|_|  /____/|____(____  /__| |__|\\____/|___|  /
                        \\/      \\/     \\/     \\/          \\/          \\/                \\/                    \\/\s
                                                                                                                       (v.0.1)
                 Welcome to the Bank Account Simulation Program!
                 This application allows you to manage a Savings Account with the following features:
                 You need $100 to open an account
                 💾 Persistent Storage
                 Your account data and transaction history are automatically saved to a file named after your account holder name. This ensures your data is preserved between sessions.                                                                                                   
                """;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter interest rate (%): ");
        double interestRate = scanner.nextDouble();
        SavingsAccount account = new SavingsAccount(name, 100, interestRate);
        account.loadFromFile(); // Load previous data if available

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("""
                 Menu Options
                 1. Deposit – Add money to your account.
                 2. Withdraw – Remove money from your account (if sufficient balance).
                 3. Apply Interest – Apply interest to your current balance based on your account's interest rate.
                 4. View Balance – Display your current account balance.
                 5. View Transaction History – Show all past transactions including deposits, withdrawals, and interest applications.
                 6. Exit – Save your data and exit the program.""");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.applyInterest();
                    System.out.println("Interest applied.");
                    break;
                case 4:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 5:
                    account.printTransactionHistory();
                    break;
                case 6:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

