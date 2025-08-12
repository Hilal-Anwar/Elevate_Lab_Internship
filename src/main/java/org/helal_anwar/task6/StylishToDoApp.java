package org.helal_anwar.task6;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class StylishToDoApp {
    private JFrame frame;
    private JTextField taskField;
    private JPanel taskPanel;
    private final String FILE_NAME = "tasks.txt";
    private ArrayList<String> tasks = new ArrayList<>();
    private Font customFont;

    public StylishToDoApp() {
        setLookAndFeel();
        customFont = loadCustomFont("src/main/java/org/helal_anwar/task6/Roboto-Bold.ttf", 14f);

        frame = new JFrame("Stylish To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(new Color(245, 245, 245));

        // Top panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setBackground(new Color(245, 245, 245));
        taskField = new JTextField(20);
        taskField.setFont(customFont);
        JButton addButton = createIconButton("src/main/java/org/helal_anwar/task6/add.png", "Add");
        topPanel.add(taskField);
        topPanel.add(addButton);

        // Task container panel
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBackground(new Color(245, 245, 245));

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(taskPanel, BorderLayout.CENTER);

        // Load tasks
        loadTasks();
        refreshTaskPanel();

        // Add task
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskField.setText("");
                saveTasks();
                refreshTaskPanel();
            }
        });

        frame.setVisible(true);
    }

    private void refreshTaskPanel() {
        taskPanel.removeAll();
        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            JPanel row = new JPanel(new BorderLayout(10, 5));
            row.setBackground(new Color(255, 255, 255));
            row.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            JLabel taskLabel = new JLabel(task);
            taskLabel.setFont(customFont);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
            buttonPanel.setBackground(new Color(255, 255, 255));

            JButton editButton = createIconButton("src/main/java/org/helal_anwar/task6/edit.png", "Edit");
            int index = i;
            editButton.addActionListener(e -> {
                String newTask = showEditDialog(task);
                if (newTask != null && !newTask.trim().isEmpty()) {
                    tasks.set(index, newTask.trim());
                    saveTasks();
                    refreshTaskPanel();
                }
            });

            JButton deleteButton = createIconButton("src/main/java/org/helal_anwar/task6/delete.png", "Delete");
            deleteButton.addActionListener(e -> {
                tasks.remove(index);
                saveTasks();
                refreshTaskPanel();
            });

            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);

            row.add(taskLabel, BorderLayout.CENTER);
            row.add(buttonPanel, BorderLayout.EAST);
            taskPanel.add(row);
        }
        taskPanel.revalidate();
        taskPanel.repaint();
    }


    private JButton createIconButton(String iconPath, String tooltip) {
        File iconFile = new File(iconPath);
        JButton button;
        if (iconFile.exists()) {
            ImageIcon icon = new ImageIcon(iconPath);
            Image scaledImage = icon.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT); // Set width & height
            button = new JButton(tooltip, new ImageIcon(scaledImage));
        } else {
            button = new JButton(tooltip); // fallback to text
        }
        button.setToolTipText(tooltip);
        button.setFocusPainted(false);
        button.setFont(customFont.deriveFont(Font.BOLD, 13f));
        switch (tooltip) {
            case "Add", "Edit" -> button.setBackground(new Color(100, 149, 237));
            case "Delete" -> button.setBackground(new Color(225, 0, 0));
        }

        button.setForeground(Color.WHITE);

        return button;
    }

    private String showEditDialog(String currentTask) {
        JTextField editField = new JTextField(currentTask, 20);
        editField.setFont(customFont);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Edit Task:"));
        panel.add(Box.createVerticalStrut(5));
        panel.add(editField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Edit Task",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            return editField.getText();
        }
        return null;
    }

    private Font loadCustomFont(String path, float size) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            return font.deriveFont(size);
        } catch (Exception e) {
            System.out.println("Failed to load custom font. Using default.");
            return new Font("Segoe UI Emoji", Font.PLAIN, (int) size);
        }
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {
        }
    }

    private void loadTasks() {
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.out.println("No existing task file found. Starting fresh.");
        }
    }

    private void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving tasks!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StylishToDoApp::new);
    }
}
