package org.helal_anwar.task5;

import java.io.*;
import java.util.ArrayList;

public class BankAccount {
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactionHistory;
    protected String filename;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.filename = accountHolder.replaceAll(" ", "_") + "_account.txt";
        transactionHistory.add("Account created with balance: $" + initialBalance);
        saveToFile();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
        } else {
            transactionHistory.add("Failed deposit attempt: $" + amount);
        }
        saveToFile();
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
        } else {
            transactionHistory.add("Failed withdrawal attempt: $" + amount);
        }
        saveToFile();
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountHolder + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(accountHolder + "\n");
            writer.write(balance + "\n");
            for (String transaction : transactionHistory) {
                writer.write(transaction + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving account data: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            accountHolder = reader.readLine();
            balance = Double.parseDouble(reader.readLine());
            transactionHistory.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                transactionHistory.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading account data: " + e.getMessage());
        }
    }
}
