package org.helal_anwar.task2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class CRUD {
    private final TreeMap<Long, Student> students = new TreeMap<>();
    private int MAX_LENGTH_NAME = 0;
    private long globalId = 1;
    private final ArrayList<Long> abandonedIds = new ArrayList<>();

    private CRUD() throws IOException {
        String info = """
                
                   __________  __  ______\s
                  / ____/ __ \\/ / / / __ \\
                 / /   / /_/ / / / / / / /
                / /___/ _, _/ /_/ / /_/ /\s
                \\____/_/ |_|\\____/_____/ \s
                
                                           (v.0.1)
                Welcome to crud app.
                Enter 1 - to add new student
                Enter 2 - to update student
                Enter 3 - to delete student
                Enter 4 - to view students
                Enter 5 - exit
                """;
        System.out.println(info);
        init();
    }

    public void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Input your choice");
            int choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("Add a student");
                    System.out.println("Enter name of student");
                    String name = in.readLine();
                    System.out.println("Enter marks of student");
                    int marks = Integer.parseInt(in.readLine());
                    addStudent(name, marks);
                }
                case 2 -> {
                    System.out.println("Enter Id of student");
                    long id = Long.parseLong(in.readLine());
                    System.out.println("You can edit mark and name");
                    System.out.println("Enter 1 for name\nEnter 2 for marks");
                    System.out.println("Enter your choice");
                    int choice2 = Integer.parseInt(in.readLine());
                    switch (choice2) {
                        case 1 -> {
                            System.out.println("Enter name of student");
                            String name = in.readLine();
                            updateStudent(id, name);
                        }
                        case 2 -> {
                            System.out.println("Enter marks of student");
                            int marks = Integer.parseInt(in.readLine());
                            updateStudent(id, marks);
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Enter id of student");
                    long id = Long.parseLong(in.readLine());
                    removeStudent(id);
                }
                case 4 -> viewStudents();
                case 5 -> {
                    System.out.println("Goodbye :)");
                    System.exit(0);
                }
            }
        }
    }

    public void addStudent(String name, int marks) {
        MAX_LENGTH_NAME = Math.max(MAX_LENGTH_NAME, name.length());
        Student st;
        if (!abandonedIds.isEmpty()) {
            long ab = abandonedIds.removeFirst();
            st = new Student(ab, name, marks);
            students.put(ab, st);
        } else {
            st = new Student(globalId, name, marks);
            students.put(globalId, st);
            globalId++;
        }
        System.out.println("Successfully added student :" + st);
    }

    public void removeStudent(long id) {
        if (students.get(id) != null) {
            System.out.println("Successfully deleted student :" + students.remove(id));
            abandonedIds.add(id);
        } else {
            System.err.println("Student not found");
        }
    }

    public void updateStudent(long id, int marks) {
        students.get(id).setMarks(marks);
        System.out.println("Successfully updated student :" + students.get(id));
    }

    public void updateStudent(long id, String name) {
        students.get(id).setName(name);
        System.out.println("Successfully updated student :" + students.get(id));
    }

    public void viewStudents() {
        StringBuilder info = new StringBuilder("ID" + space(5) + "Name" + space(MAX_LENGTH_NAME - 4 + 5) + "Marks\n");
        for (Long id : students.keySet()) {
            info.append(students.get(id).getId()).append(space(6)).append(students.get(id).getName()).append(space(MAX_LENGTH_NAME - students.get(id).getName().length() + 5)).append(students.get(id).getMarks()).append("\n");
        }
        System.out.println(info);
    }

    private String space(int size) {
        return " ".repeat(Math.max(0, size));
    }

    public static void main(String[] args) throws IOException {
        CRUD crud = new CRUD();
        crud.init();
    }
}
