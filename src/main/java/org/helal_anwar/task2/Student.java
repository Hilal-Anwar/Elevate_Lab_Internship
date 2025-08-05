package org.helal_anwar.task2;

public class Student {
    // Unique identifier for each student
    private final long id;

    // Name of the student
    private String name;

    // Marks obtained by the student
    private int marks;

    // Constructor to initialize student object
    public Student(long id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getter for student ID
    public long getId() {
        return id;
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Setter for student name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for student marks
    public int getMarks() {
        return marks;
    }

    // Setter for student marks
    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Returns a string representation of the student object
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
