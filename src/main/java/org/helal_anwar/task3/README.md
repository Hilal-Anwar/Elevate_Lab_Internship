# Library Management System 📚

A comprehensive console-based library management system that enables efficient management of books, users, and book borrowing/returning operations with an intuitive menu-driven interface.

![Java](https://img.shields.io/badge/language-Java%2024-orange.svg)
![Status](https://img.shields.io/badge/status-Completed-brightgreen.svg)
![Version](https://img.shields.io/badge/version-0.1-blue.svg)

## 📖 Overview

This Library Management System provides a complete solution for managing library operations including book inventory, user registration, and borrowing/returning transactions. The system features elegant ASCII art branding and emoji-enhanced user interaction.

## ✨ Features

- **Book Management**: Add books with title and author information
- **User Registration**: Register library users for book borrowing
- **Book Issuing**: Issue available books to registered users
- **Book Returns**: Process book returns from users
- **Book Search**: Find books by title (case-insensitive)
- **User Search**: Locate users by name (case-insensitive)
- **Status Tracking**: Track book availability (Available/Issued)
- **Complete Inventory**: Display all books with their current status
- **User-Friendly Interface**: Emoji-enhanced menu with clear options

## 🏗️ Architecture

### Class Structure

1. **Main Class**
   - Entry point with ASCII art header
   - Menu-driven interface with user input handling
   - Application flow control

2. **Library Class**
   - Central management system for books and users
   - Core business logic for all operations
   - Search and validation functionality

3. **Book Class**
   - Book entity with title, author, and status
   - Issue/return status management
   - String representation with status indicators

4. **User Class**
   - User entity with name and borrowed books list
   - Book borrowing and returning operations
   - Personal library tracking

### Data Structure

- **ArrayList<Book>**: Stores all library books
- **ArrayList<User>**: Manages registered users
- **List<Book>**: Tracks individual user's borrowed books

## 🚀 How to Run

```bash
# Navigate to the project root directory
cd Elevate_Lab_Internship

# Compile with Maven
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="org.helal_anwar.task3.Main"
```

## 📋 Usage Guide

When you run the application, you'll see the main interface:

```
___________         .____    ._____.                             
\_   _____/         |    |   |__\_ |______________ _______ ___.__.
 |    __)_   ______ |    |   |  || __ \_  __ \__  \\_  __ <   |  |
 |        \ /_____/ |    |___|  || \_\ \  | \// __ \|  | \/\___  |
/_______  /         |_______ \__||___  /__|  (____  /__|   / ____|
        \/                  \/       \/           \/       \/    
                                                                v.0.1

📚 Welcome to the Library Management System!

Choose an option:
1. Add Book
2. Register User
3. Issue Book
4. Return Book
5. Display All Books
6. Exit
```

### Menu Options

#### 1. Add Book
- Enter book title and author name
- Book is automatically marked as available
- Confirmation message displays success

#### 2. Register User
- Enter user name for registration
- User is added to the system database
- Success confirmation provided

#### 3. Issue Book
- Enter user name and book title
- System validates user existence and book availability
- Updates book status to issued and adds to user's borrowed list
- Handles error cases (user not found, book unavailable)

#### 4. Return Book
- Enter user name and book title to return
- Validates book is actually borrowed by the user
- Updates book status to available and removes from user's list
- Error handling for invalid returns

#### 5. Display All Books
- Shows complete library inventory
- Format: "Title by Author [Status]"
- Status indicators: [Available] or [Issued]

#### 6. Exit
- Graceful application termination

## 🔧 Technical Implementation

### Object-Oriented Design
- **Encapsulation**: Private fields with public methods
- **Single Responsibility**: Each class has a specific purpose
- **Data Hiding**: Internal state managed through controlled access

### Search Algorithm
- **Linear Search**: O(n) time complexity for book and user lookup
- **Case-Insensitive**: Uses `equalsIgnoreCase()` for flexible searching
- **Null Safety**: Proper handling of not-found scenarios

### State Management
- **Book Status**: Boolean flag for issued/available state
- **User Borrowing**: Dynamic list management for borrowed books
- **Bidirectional Updates**: Status changes reflected in both book and user objects

### Error Handling
- User not found validation
- Book availability checking
- Duplicate prevention measures
- Graceful error messages with emoji indicators

## 👨‍💻 Code Highlights

### Smart Book Issuing
```java
public void issueBook(String title, User user) {
    Book book = findBook(title);
    if (book != null && !book.isIssued()) {
        user.borrowBook(book);
        System.out.println("Book issued successfully.");
    } else {
        System.out.println("Book is not available.");
    }
}
```

### Robust Book Return
```java
public void returnBook(String title, User user) {
    Book book = findBook(title);
    if (book != null && user.getBorrowedBooks().contains(book)) {
        user.returnBook(book);
        System.out.println("Book returned successfully.");
    } else {
        System.out.println("Book not found in user's borrowed list.");
    }
}
```

## 🔮 Future Enhancements

- **Persistent Storage**: File-based or database storage for data persistence
- **Due Date Management**: Track loan periods and overdue books
- **Fine Calculation**: Automatic fine calculation for late returns
- **Book Categories**: Genre-based book classification
- **Search Filters**: Advanced search by author, genre, or availability
- **User History**: Complete borrowing history for each user
- **Book Reservations**: Allow users to reserve issued books
- **Admin Panel**: Separate administrator functionality
- **Multi-copy Support**: Handle multiple copies of the same book
- **Statistics Dashboard**: Library usage and popular books analytics

## 📊 System Capabilities

- **Concurrent Users**: Unlimited user registration
- **Book Capacity**: Unlimited book inventory
- **Search Performance**: O(n) linear search (suitable for small-medium libraries)
- **Memory Efficiency**: Dynamic ArrayList sizing
- **Data Integrity**: Proper state synchronization between objects

## 🧪 Sample Workflow

1. **Setup Phase**: Register users and add books to library
2. **Operation Phase**: Issue books to users for borrowing
3. **Tracking Phase**: Monitor book availability and user borrowings
4. **Return Phase**: Process book returns and update availability
5. **Reporting Phase**: View complete library status

## 📝 Author

**Hilal Anwar** - *Library Management System Developer*

---

*A robust foundation for digital library management with room for extensive feature expansion.*
