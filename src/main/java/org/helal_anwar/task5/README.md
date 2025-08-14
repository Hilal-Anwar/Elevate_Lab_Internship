# Task 5: Bank Account Simulation 🏦

A comprehensive banking simulation system demonstrating object-oriented programming principles including inheritance, encapsulation, and polymorphism with persistent data storage and transaction history tracking.

![Language](https://img.shields.io/badge/language-Java-orange.svg)
![OOP](https://img.shields.io/badge/concept-OOP-blue.svg)
![Inheritance](https://img.shields.io/badge/feature-Inheritance-green.svg)
![File Persistence](https://img.shields.io/badge/storage-File%20Based-yellow.svg)
![Status](https://img.shields.io/badge/status-Completed-brightgreen.svg)

## 🎯 Overview

The Bank Account Simulation is a console-based application that models real-world banking operations using advanced object-oriented programming concepts. It features a hierarchical class structure with a base `BankAccount` class and specialized `SavingsAccount` subclass, demonstrating inheritance and polymorphism while providing persistent data storage.

## ✨ Features

### Core Banking Operations
- **💰 Deposit Funds**: Add money to your account with validation
- **💳 Withdraw Money**: Remove funds with balance checking
- **📊 Balance Inquiry**: View current account balance
- **📈 Interest Application**: Earn interest on savings accounts
- **📋 Transaction History**: Complete record of all account activities
- **💾 Data Persistence**: Account data saved between sessions

### Advanced Features
- **🏦 Account Types**: Different account types with specialized features
- **📁 Individual Files**: Each account holder has their own data file
- **🔒 Data Validation**: Input validation and error handling
- **📱 Interactive Menu**: User-friendly console interface
- **🎨 ASCII Art**: Stylized application branding

## 🏗️ Architecture

### Class Hierarchy
```
BankAccount (Base Class)
├── String accountHolder
├── double balance
├── ArrayList<String> transactionHistory
├── String filename
├── deposit(double amount)
├── withdraw(double amount)
├── getBalance()
├── printTransactionHistory()
├── saveToFile()
└── loadFromFile()

SavingsAccount (Derived Class)
├── Inherits all BankAccount features
├── double interestRate
└── applyInterest()
```

### System Components
```
Bank Simulation System
├── BankAccount.java          // Base class with core functionality
├── SavingsAccount.java       // Specialized savings account
├── BankSimulation.java       // Main application controller
└── [AccountName]_account.txt // Generated data files
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven (for build management)
- Terminal or command prompt access
- File system write permissions

### Running the Application

#### Method 1: Using Maven
```bash
# Compile the project
mvn clean compile

# Run the bank simulation
mvn exec:java -Dexec.mainClass="org.helal_anwar.task5.BankSimulation"
```

#### Method 2: Direct Java Execution
```bash
# Navigate to source directory
cd src/main/java

# Compile all classes
javac org/helal_anwar/task5/*.java

# Run the simulation
java org.helal_anwar.task5.BankSimulation
```

## 📱 User Interface

### Welcome Screen
```
__________                __        _________.__              .__          __  .__              
\______   \_____    ____ |  | __   /   _____/|__| _____  __ __|  | _____ _/  |_|__| ____   ____ 
 |    |  _/\__  \  /    \|  |/ /   \_____  \ |  |/     \|  |  \  | \__  \\   __\  |/  _ \ /    \
 |    |   \ / __ \|   |  \    <    /        \|  |  Y Y  \  |  /  |__/ __ \|  | |  (  <_> )   |  \
 |______  /(____  /___|  /__|_ \  /_______  /|__|__|_|  /____/|____(____  /__| |__|\____/|___|  /
        \/      \/     \/     \/          \/          \/                \/                    \/
                                                                                            (v.0.1)
Welcome to the Bank Account Simulation Program!
This application allows you to manage a Savings Account with the following features:
You need $100 to open an account
💾 Persistent Storage
Your account data and transaction history are automatically saved to a file named after your account holder name.
```

### Main Menu
```
--- Bank Menu ---
Menu Options
1. Deposit – Add money to your account.
2. Withdraw – Remove money from your account (if sufficient balance).
3. Apply Interest – Apply interest to your current balance based on your account's interest rate.
4. View Balance – Display your current account balance.
5. View Transaction History – Show all past transactions including deposits, withdrawals, and interest applications.
6. Exit – Save your data and exit the program.
```

### Sample Usage Flow

#### Initial Setup
```
Enter account holder name: John Smith
Enter interest rate (%): 2.5
```

#### Making Transactions
```
--- Bank Menu ---
Enter your choice: 1
Enter deposit amount: 250.00
Current Balance: $350.00

Enter your choice: 3
Interest applied.
Current Balance: $358.75
```

#### Viewing Transaction History
```
Enter your choice: 5
Transaction History for John Smith:
Account created with balance: $100.0
Deposited: $250.0
Interest applied: $8.75
```

## 🔧 Technical Implementation

### Inheritance Structure

#### Base Class: BankAccount
```java
public class BankAccount {
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactionHistory;
    protected String filename;
    
    // Core banking operations
    public void deposit(double amount) { /* Implementation */ }
    public void withdraw(double amount) { /* Implementation */ }
    public void saveToFile() { /* File persistence */ }
}
```

#### Derived Class: SavingsAccount
```java
public class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }
    
    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        transactionHistory.add("Interest applied: $" + interest);
        saveToFile();
    }
}
```

### File Persistence System

#### Data File Format
```
John_Smith_account.txt:
-----------------------
John Smith
358.75
Account created with balance: $100.0
Deposited: $250.0
Interest applied: $8.75
```

#### Automatic File Management
- **File Creation**: Automatic generation based on account holder name
- **Data Loading**: Restore account state on application start
- **Continuous Saving**: Every transaction automatically saved
- **Space Handling**: Underscores replace spaces in filenames

## 📊 Object-Oriented Features

### 1. Inheritance
- **Base Class**: `BankAccount` provides core functionality
- **Derived Class**: `SavingsAccount` extends with interest features
- **Method Inheritance**: All base methods available in derived class
- **Constructor Chaining**: `super()` call in derived constructor

### 2. Encapsulation
- **Protected Members**: Base class members accessible to derived classes
- **Private Data**: Interest rate hidden from external access
- **Public Interface**: Clear API for banking operations
- **Data Validation**: Internal validation of operations

### 3. Polymorphism
- **Method Override**: Potential for specialized behavior
- **Interface Consistency**: Same method signatures across hierarchy
- **Runtime Behavior**: Appropriate method called based on object type

### 4. Abstraction
- **Interface Design**: Simple public methods hide complex operations
- **Implementation Hiding**: File operations abstracted from user
- **Modular Design**: Separate concerns for different functionalities

## 🎨 Code Highlights

### Transaction Validation
```java
public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        transactionHistory.add("Withdrew: $" + amount);
    } else {
        transactionHistory.add("Failed withdrawal attempt: $" + amount);
    }
    saveToFile();
}
```

### Interest Calculation
```java
public void applyInterest() {
    double interest = balance * interestRate / 100;
    balance += interest;
    transactionHistory.add("Interest applied: $" + interest);
    saveToFile();
}
```

### File Persistence
```java
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
```

## 📁 File Structure

### Project Layout
```
task5/
├── BankAccount.java          // Base class implementation
├── SavingsAccount.java       // Derived class with interest features
├── BankSimulation.java       // Main application controller
└── README.md                 // This documentation

Generated Files:
├── [Name]_account.txt        // Individual account data files
```

### Data Persistence
- **Individual Files**: Each account holder gets a unique file
- **Automatic Naming**: Files named after account holder
- **Complete History**: All transactions preserved
- **Load on Startup**: Previous session data restored

## 🧪 Testing Scenarios

### Basic Operations Testing
1. **Account Creation**: Open new account with initial balance
2. **Deposit Operations**: Add various amounts to account
3. **Withdrawal Testing**: Valid and invalid withdrawal attempts
4. **Balance Verification**: Confirm balance accuracy after operations
5. **Interest Application**: Verify correct interest calculations

### Persistence Testing
1. **Data Saving**: Confirm transactions save to file
2. **Session Recovery**: Exit and restart to verify data loading
3. **File Integrity**: Check file format and content accuracy
4. **Multiple Sessions**: Multiple program runs with same account

### Edge Cases
1. **Zero/Negative Deposits**: Validate input restrictions
2. **Overdraft Protection**: Prevent withdrawals exceeding balance
3. **File Permissions**: Handle file access issues gracefully
4. **Invalid Interest Rates**: Test with various interest rate values

## 🚀 Advanced Features

### Inheritance Benefits
- **Code Reusability**: Base functionality shared across account types
- **Maintainability**: Changes in base class affect all derived classes
- **Extensibility**: Easy to add new account types
- **Consistency**: Uniform interface across all account types

### Transaction History
- **Complete Audit Trail**: Every operation recorded
- **Success and Failure Tracking**: Both valid and invalid attempts logged
- **Persistent History**: Transaction records survive program restarts
- **Chronological Order**: Operations listed in sequence

### Data Integrity
- **Automatic Saves**: Every operation triggers file update
- **Error Handling**: File I/O errors handled gracefully
- **Data Validation**: Input validation prevents invalid operations
- **Recovery Mechanisms**: Graceful handling of missing files

## 🎯 Learning Outcomes

### Object-Oriented Programming Concepts
- **Inheritance**: Creating class hierarchies and code reuse
- **Encapsulation**: Data hiding and controlled access
- **Polymorphism**: Method overriding and dynamic behavior
- **Abstraction**: Simplifying complex operations

### Advanced Java Features
- **Collections Framework**: ArrayList for dynamic data storage
- **File I/O Operations**: Reading from and writing to files
- **Exception Handling**: Try-catch blocks and resource management
- **String Processing**: Filename generation and data formatting

### Software Design Principles
- **Separation of Concerns**: Different classes handle different responsibilities
- **Data Persistence**: Reliable data storage between sessions
- **User Interface Design**: Clear and intuitive console interface
- **Error Recovery**: Graceful handling of exceptional conditions

## 🔮 Potential Enhancements

### Short-term Improvements
- [ ] **Multiple Account Types**: Checking, Savings, and Investment accounts
- [ ] **Account Numbers**: Unique identifiers for each account
- [ ] **Transfer Operations**: Move money between accounts
- [ ] **Interest Compounding**: Different compounding frequencies

### Advanced Features
- [ ] **Multi-User System**: Support multiple account holders
- [ ] **Account Statements**: Generate detailed account reports
- [ ] **Transaction Limits**: Daily/monthly transaction restrictions
- [ ] **Account Fees**: Service charges and maintenance fees
- [ ] **Security Features**: PIN-based authentication
- [ ] **Database Integration**: Replace file storage with database

### Enterprise Features
- [ ] **Web Interface**: Browser-based banking system
- [ ] **REST API**: Web services for banking operations
- [ ] **Real-time Processing**: Immediate transaction processing
- [ ] **Audit Logging**: Comprehensive system audit trails

## 💡 Key Design Decisions

### Why Inheritance?
- **Code Reuse**: Avoid duplicating common banking functionality
- **Consistency**: Ensure all account types have basic operations
- **Extensibility**: Easy to add new specialized account types
- **Maintainability**: Single location for core functionality updates

### File-Based Storage
- **Simplicity**: No external dependencies or database setup
- **Portability**: Files can be easily backed up or transferred
- **Individual Accounts**: Each user has their own data file
- **Human Readable**: Plain text format for easy inspection

### Protected Members
- **Inheritance Access**: Derived classes can access base class data
- **Encapsulation**: External classes cannot access internal data
- **Flexibility**: Derived classes can extend base functionality
- **Security**: Controlled access to sensitive account information

## 📈 Performance Considerations

- **Memory Efficient**: Transaction history stored in ArrayList
- **File I/O Optimized**: Minimal file operations with buffered writers
- **Automatic Saving**: Ensures data consistency without manual intervention
- **Scalable Design**: Easy to extend for additional account types

---

**Author**: Hilal Anwar  
**Project**: Elevate Lab Internship - Task 5  
**Date**: August 2025  

*This Bank Account Simulation demonstrates advanced object-oriented programming principles including inheritance, polymorphism, and data persistence in a practical banking context.*
