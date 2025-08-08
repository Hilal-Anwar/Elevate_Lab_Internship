package org.helal_anwar.task4;

import java.io.*;
import java.util.*;

public class NotesManager {
    // File where notes will be stored
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main menu loop
        do {
            System.out.println("\n--- Notes Manager ---");
            System.out.println("1. Write a note");
            System.out.println("2. Read notes");
            System.out.println("3. Edit a note");
            System.out.println("4. Insert a note between lines");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Handle user choice
            switch (choice) {
                case 1:
                    writeNote(scanner);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    editNote(scanner);
                    break;
                case 4:
                    insertNote(scanner);
                    break;
                case 5:
                    System.out.println("Exiting Notes Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Function to write a new note to the file
    private static void writeNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String line = "";
        System.out.println("Enter 'e' to exit:");
        StringBuilder note = new StringBuilder();

        // Read multiple lines until user enters 'e'
        while (!line.equals("e")) {
            line = scanner.nextLine();
            if (!line.equals("e"))
                note.append(line).append("\n");
        }

        // Append the note to the file
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Function to read and display all notes with line numbers
    private static void readNotes() {
        System.out.println("\n--- Your Notes ---");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int lineNumber = 1;

            // Read each line and print with line number
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Start by writing one!");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    // Function to edit a specific line in the notes
    private static void editNote(Scanner scanner) {
        List<String> notes = readAllNotes();
        if (notes.isEmpty()) {
            System.out.println("No notes to edit.");
            return;
        }

        readNotes(); // Show current notes
        System.out.print("Enter the line number to edit: ");
        int lineNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Validate line number
        if (lineNumber < 1 || lineNumber > notes.size()) {
            System.out.println("Invalid line number.");
            return;
        }

        // Get new content and update the line
        System.out.print("Enter the new content: ");
        String newContent = scanner.nextLine();
        notes.set(lineNumber - 1, newContent);
        writeAllNotes(notes);
        System.out.println("Note updated successfully.");
    }

    // Function to insert a note between two lines
    private static void insertNote(Scanner scanner) {
        List<String> notes = readAllNotes();
        if (notes.size() < 2) {
            System.out.println("Need at least two notes to insert between.");
            return;
        }

        readNotes(); // Show current notes
        System.out.print("Enter the line number after which to insert: ");
        int lineNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Validate line number
        if (lineNumber < 1 || lineNumber >= notes.size()) {
            System.out.println("Invalid line number.");
            return;
        }

        // Get new note and insert it
        System.out.print("Enter the note to insert: ");
        String newNote = scanner.nextLine();
        notes.add(lineNumber, newNote);
        writeAllNotes(notes);
        System.out.println("Note inserted successfully.");
    }

    // Helper function to read all notes into a list
    private static List<String> readAllNotes() {
        List<String> notes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
        return notes;
    }

    // Helper function to overwrite the file with updated notes
    private static void writeAllNotes(List<String> notes) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (String note : notes) {
                writer.write(note + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error writing notes: " + e.getMessage());
        }
    }
}
