package org.helal_anwar.task3;

import java.util.Scanner;

public class Main {
    static String info = """
            ___________         .____    ._____.                             \s
            \\_   _____/         |    |   |__\\_ |______________ _______ ___.__.
             |    __)_   ______ |    |   |  || __ \\_  __ \\__  \\\\_  __ <   |  |
             |        \\ /_____/ |    |___|  || \\_\\ \\  | \\// __ \\|  | \\/\\___  |
            /_______  /         |_______ \\__||___  /__|  (____  /__|   / ____|
                    \\/                  \\/       \\/           \\/       \\/    \s
                                                                                v.0.1
            """;

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        System.out.println("📚 Welcome to the Library Management System!");
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("✅ Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    library.registerUser(new User(userName));
                    System.out.println("✅ User registered successfully.");
                    break;

                case 3:
                    System.out.print("Enter user name: ");
                    String borrower = scanner.nextLine();
                    System.out.print("Enter book title to issue: ");
                    String bookToIssue = scanner.nextLine();
                    User userToIssue = library.findUser(borrower);
                    if (userToIssue != null) {
                        library.issueBook(bookToIssue, userToIssue);
                    } else {
                        System.out.println("❌ User not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter user name: ");
                    String returner = scanner.nextLine();
                    System.out.print("Enter book title to return: ");
                    String bookToReturn = scanner.nextLine();
                    User userToReturn = library.findUser(returner);
                    if (userToReturn != null) {
                        library.returnBook(bookToReturn, userToReturn);
                    } else {
                        System.out.println("❌ User not found.");
                    }
                    break;

                case 5:
                    library.displayBooks();
                    break;

                case 6:
                    System.out.println("👋 Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
            }
        }
    }
}

