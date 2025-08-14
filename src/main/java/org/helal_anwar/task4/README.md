# Task 4: Notes Manager 📝

A comprehensive console-based notes management application that allows users to create, read, edit, and organize their notes with persistent file storage.

![Language](https://img.shields.io/badge/language-Java-orange.svg)
![File I/O](https://img.shields.io/badge/feature-File%20I%2FO-blue.svg)
![Console](https://img.shields.io/badge/interface-Console-green.svg)
![Status](https://img.shields.io/badge/status-Completed-brightgreen.svg)

## 🎯 Overview

The Notes Manager is a command-line application that provides a simple yet powerful interface for managing personal notes. It demonstrates fundamental Java concepts including file I/O operations, exception handling, and user input processing while offering practical note-taking functionality.

## ✨ Features

### Core Functionality
- **📝 Write Notes**: Create multi-line notes with unlimited content
- **📖 Read Notes**: Display all notes with numbered lines for easy reference
- **✏️ Edit Notes**: Modify existing notes by line number
- **📌 Insert Notes**: Add new notes between existing lines
- **💾 Persistent Storage**: Automatic saving to `notes.txt` file
- **🔄 Session Management**: Notes persist between application sessions

### User Experience
- **Interactive Menu**: Clear, numbered menu options
- **Line Numbering**: All notes displayed with line numbers for easy editing
- **Input Validation**: Robust error handling for invalid inputs
- **Multi-line Support**: Write notes spanning multiple lines
- **Exit Command**: Type 'e' to finish writing a note

## 🏗️ Architecture

### Class Structure
```
NotesManager
├── main(String[] args)                    // Application entry point
├── writeNote(Scanner scanner)             // Create new notes
├── readNotes()                           // Display all notes
├── editNote(Scanner scanner)             // Modify existing notes
├── insertNote(Scanner scanner)           // Insert notes between lines
├── readAllNotes()                        // Helper: Load notes into memory
└── writeAllNotes(List<String> notes)     // Helper: Save notes to file
```

### Data Flow
1. **Startup** → Load existing notes from `notes.txt`
2. **User Input** → Process menu selections
3. **Note Operations** → Perform CRUD operations
4. **File Updates** → Save changes to persistent storage
5. **Exit** → Clean resource closure

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Terminal or command prompt access
- Write permissions in the application directory

### Running the Application

#### Method 1: Using Maven
```bash
# Compile the project
mvn clean compile

# Run the specific class
mvn exec:java -Dexec.mainClass="org.helal_anwar.task4.NotesManager"
```

#### Method 2: Direct Java Execution
```bash
# Navigate to the source directory
cd src/main/java

# Compile the Java file
javac org/helal_anwar/task4/NotesManager.java

# Run the application
java org.helal_anwar.task4.NotesManager
```

## 📱 User Interface

### Main Menu
```
--- Notes Manager ---
1. Write a note
2. Read notes
3. Edit a note
4. Insert a note between lines
5. Exit
Enter your choice:
```

### Sample Usage Flow

#### Writing a Note
```
Enter your choice: 1
Enter your note:
Enter 'e' to exit:
This is my first note
It spans multiple lines
e
Note saved successfully.
```

#### Reading Notes
```
Enter your choice: 2

--- Your Notes ---
1: This is my first note
2: It spans multiple lines
3: 
4: Another important note
5: Meeting at 3 PM tomorrow
```

#### Editing a Note
```
Enter your choice: 3

--- Your Notes ---
1: This is my first note
2: It spans multiple lines
3: Another important note

Enter the line number to edit: 2
Enter the new content: It spans multiple lines with updated content
Note updated successfully.
```

#### Inserting a Note
```
Enter your choice: 4

--- Your Notes ---
1: This is my first note
2: It spans multiple lines with updated content
3: Another important note

Enter the line number after which to insert: 1
Enter the note to insert: This is an inserted note
Note inserted successfully.
```

## 🔧 Technical Implementation

### File I/O Operations
- **FileWriter**: Appending new notes and overwriting entire file
- **BufferedReader**: Efficient reading of note files
- **FileNotFoundException**: Graceful handling of missing files
- **IOException**: Comprehensive error handling for file operations

### Data Structures
- **ArrayList<String>**: In-memory storage for note editing operations
- **Scanner**: User input processing with newline handling
- **StringBuilder**: Efficient string building for multi-line notes

### Error Handling
```java
try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
    writer.write(note + System.lineSeparator());
    System.out.println("Note saved successfully.");
} catch (IOException e) {
    System.out.println("Error writing to file: " + e.getMessage());
}
```

## 📁 File Structure

### Project Layout
```
task4/
├── NotesManager.java          // Main application class
└── README.md                  // This documentation file

Generated Files:
├── notes.txt                  // Persistent note storage
```

### File Format
The `notes.txt` file stores notes in plain text format:
```
This is my first note
It spans multiple lines

Another important note
Meeting at 3 PM tomorrow
```

## 🎨 Code Highlights

### Multi-line Input Handling
```java
while (!line.equals("e")) {
    line = scanner.nextLine();
    if (!line.equals("e"))
        note.append(line).append("\n");
}
```

### Dynamic List Operations
```java
// Editing existing note
notes.set(lineNumber - 1, newContent);

// Inserting new note
notes.add(lineNumber, newNote);
```

### Resource Management
```java
// Try-with-resources for automatic resource cleanup
try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
    // File operations
}
```

## 📊 Features Demonstration

### Input Validation
- ✅ Line number bounds checking
- ✅ Empty note handling
- ✅ File existence validation
- ✅ Menu choice validation

### Error Recovery
- ✅ Graceful handling of missing files
- ✅ Recovery from invalid user inputs
- ✅ Automatic file creation
- ✅ Resource cleanup on errors

## 🧪 Testing Scenarios

### Basic Operations
1. **First Run**: Application creates new notes.txt
2. **Write Multiple Notes**: Add several notes with different content
3. **Read Verification**: Confirm all notes display correctly
4. **Edit Operations**: Modify existing notes and verify changes
5. **Insert Operations**: Add notes between existing lines

### Edge Cases
1. **Empty Notes**: Handle empty input gracefully
2. **Invalid Line Numbers**: Test bounds checking
3. **File Permissions**: Handle read/write permission issues
4. **Large Notes**: Test with extensive multi-line content

## 🚀 Potential Enhancements

### Short-term Improvements
- [ ] **Note Categories**: Organize notes by categories or tags
- [ ] **Search Functionality**: Find notes by keyword
- [ ] **Date Stamps**: Add creation and modification timestamps
- [ ] **Note Priorities**: Mark notes as high/medium/low priority

### Advanced Features
- [ ] **Multiple File Support**: Manage multiple note files
- [ ] **Backup System**: Automatic backup of notes
- [ ] **Encryption**: Secure sensitive notes
- [ ] **Export Options**: Export to different formats (PDF, HTML)

## 🎯 Learning Outcomes

### Java Concepts Demonstrated
- **File I/O Operations**: Reading from and writing to files
- **Exception Handling**: Try-catch blocks and resource management
- **Collections Framework**: ArrayList operations and manipulation
- **String Processing**: StringBuilder and string operations
- **Scanner Usage**: Console input with different data types

### Programming Principles
- **Modular Design**: Separate methods for different operations
- **Error Handling**: Comprehensive exception management
- **User Experience**: Clear menu system and feedback
- **Data Persistence**: Reliable file-based storage

## 💡 Key Features Explained

### Persistent Storage
All notes are automatically saved to `notes.txt`, ensuring data persists between sessions.

### Line-based Operations
Notes are managed line by line, allowing precise editing and insertion operations.

### User-Friendly Interface
Clear menu options and helpful prompts guide users through all operations.

### Robust Error Handling
The application gracefully handles file errors, invalid inputs, and edge cases.

## 📈 Performance Considerations

- **Memory Efficient**: Notes loaded into memory only during editing operations
- **File I/O Optimized**: Minimal file operations with buffered readers/writers
- **Scalable**: Handles large numbers of notes efficiently

---

**Author**: Hilal Anwar  
**Project**: Elevate Lab Internship - Task 4  
**Date**: August 2025  

*This Notes Manager demonstrates practical application of Java file I/O operations and user interface design principles.*
