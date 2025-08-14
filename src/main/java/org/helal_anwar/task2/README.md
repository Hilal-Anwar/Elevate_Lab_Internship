# Student CRUD Management System 👨‍🎓

A console-based student management system that allows users to perform CRUD (Create, Read, Update, Delete) operations on student records with a user-friendly interface and efficient data handling.

![Java](https://img.shields.io/badge/language-Java%2024-orange.svg)
![Status](https://img.shields.io/badge/status-Completed-brightgreen.svg)
![Version](https://img.shields.io/badge/version-0.1-blue.svg)

## 📚 Overview

This application provides a complete solution for managing student records through a text-based interface. It features a stylish ASCII art header, intuitive menu navigation, and robust data management capabilities.

## ✨ Features

- **Create**: Add new students with name and marks
- **Read**: View all students in a formatted table display
- **Update**: Modify existing student information (name or marks)
- **Delete**: Remove students with automatic ID recycling
- **Data Structures**: Uses TreeMap for efficient ID-based lookup
- **ID Management**: Auto-incrementing IDs with recycling of deleted IDs
- **Formatting**: Dynamic table formatting based on longest name
- **User Interface**: Clean ASCII art interface with intuitive menu

## 🔍 Implementation Details

### Classes

1. **Student Class**
   - Properties: id, name, marks
   - Methods: getters/setters, toString()

2. **CRUD Class**
   - Core functionality for all CRUD operations
   - TreeMap data structure for student storage
   - Abandoned ID tracking for efficient ID reuse
   - Dynamic table formatting for better display

### Key Components

- **TreeMap<Long, Student>**: Primary storage of student records with ID as key
- **ArrayList<Long>**: Stores abandoned IDs for recycling
- **Automatic ID Generation**: Increments IDs automatically or reuses abandoned ones
- **Dynamic Formatting**: Adjusts table display based on longest student name

## 🚀 How to Run

```bash
# Navigate to the project root directory
cd Elevate_Lab_Internship

# Compile with Maven
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="org.helal_anwar.task2.CRUD"
```

## 📋 Usage Guide

When you run the application, you'll see the main menu:

```
  ________  __  _____
 / ___/ _ \/ / / / _ \
/ /__/ , _/ /_/ / // /
\___/_/|_|\____/____/
                 (v.0.1)
Welcome to crud app.
Enter 1 - to add new student
Enter 2 - to update student
Enter 3 - to delete student
Enter 4 - to view students
Enter 5 - exit
```

### Menu Options

1. **Add Student**
   - Enter student name and marks
   - System assigns ID automatically (either new or recycled)

2. **Update Student**
   - Enter the ID of the student to update
   - Choose to update either name or marks
   - Enter new value for the selected field

3. **Delete Student**
   - Enter the ID of the student to delete
   - System confirms deletion and recycles the ID for future use

4. **View Students**
   - Displays all students in a formatted table
   - Shows ID, Name, and Marks in aligned columns

5. **Exit**
   - Terminates the application

## 🔧 Technical Implementation

### Data Structure

- **TreeMap**: Provides O(log n) access time for student lookup by ID
- **ArrayList**: Stores abandoned IDs for efficient reuse

### ID Management System

The application implements a sophisticated ID management system:
- Auto-increments global ID counter for new students
- Recycles deleted student IDs to avoid ID gaps
- Maintains ID uniqueness for data integrity

### Dynamic Formatting

The table display dynamically adjusts column width based on the longest student name, ensuring consistent and readable output regardless of data content.

### Error Handling

Includes basic error handling for:
- Invalid user input
- Student not found scenarios
- Menu navigation errors

## 👨‍💻 Code Structure

- **Constructor**: Initializes the application and displays the welcome message
- **init()**: Main application loop that handles user input and menu navigation
- **addStudent()**: Creates and stores new student records
- **removeStudent()**: Deletes student records and recycles IDs
- **updateStudent()**: Updates either name or marks of existing students
- **viewStudents()**: Displays all students in a formatted table
- **space()**: Utility method for table formatting

## 🔮 Future Enhancements

Potential improvements for future versions:
- Persistent storage with file I/O
- Search functionality
- Sorting options (by name, marks, etc.)
- Enhanced data validation
- Additional student attributes
- Statistics calculation (average marks, highest/lowest scores)

## 📝 Author

**Hilal Anwar** - *Initial work*
