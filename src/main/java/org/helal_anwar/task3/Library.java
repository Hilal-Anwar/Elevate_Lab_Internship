package org.helal_anwar.task3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void issueBook(String title, User user) {
        Book book = findBook(title);
        if (book != null && !book.isIssued()) {
            user.borrowBook(book);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(String title, User user) {
        Book book = findBook(title);
        if (book != null && user.getBorrowedBooks().contains(book)) {
            user.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found in user's borrowed list.");
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public User findUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

}

