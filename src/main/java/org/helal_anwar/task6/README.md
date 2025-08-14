# Task 6: Stylish To-Do GUI Application 📋

A modern, feature-rich graphical user interface to-do list application built with Java Swing, featuring custom fonts, icons, persistent storage, and an intuitive user experience.

![Language](https://img.shields.io/badge/language-Java-orange.svg)
![GUI](https://img.shields.io/badge/interface-Swing%20GUI-blue.svg)
![Features](https://img.shields.io/badge/features-CRUD%20Operations-green.svg)
![Storage](https://img.shields.io/badge/storage-File%20Persistence-yellow.svg)
![Status](https://img.shields.io/badge/status-Completed-brightgreen.svg)

## 🎯 Overview

The Stylish To-Do App is a sophisticated desktop application that revolutionizes task management with a beautiful, intuitive graphical interface. Built using Java Swing with advanced UI components, custom styling, and persistent data storage, it demonstrates professional GUI development practices while delivering practical task management functionality.

## ✨ Features

### Core Functionality
- **➕ Add Tasks**: Create new tasks with a simple text input interface
- **✏️ Edit Tasks**: Modify existing tasks with an intuitive edit dialog
- **🗑️ Delete Tasks**: Remove completed or unwanted tasks
- **💾 Persistent Storage**: Tasks automatically saved to `tasks.txt`
- **🔄 Session Management**: Tasks persist between application sessions

### Visual Design
- **🎨 Custom Styling**: Professional color scheme and modern design
- **🖼️ Icon Integration**: Visual icons for add, edit, and delete operations
- **🔤 Custom Fonts**: Beautiful Roboto Bold typography
- **📱 Responsive Layout**: Clean, organized task display
- **🎯 Intuitive UI**: User-friendly interface with clear visual hierarchy

### Advanced Features
- **🖱️ Interactive Buttons**: Icon-enhanced buttons with tooltips
- **📝 Edit Dialog**: Modal dialog for task editing
- **🔄 Dynamic Refresh**: Real-time UI updates after operations
- **⚡ Event-Driven**: Responsive button click handling
- **🎪 Look & Feel**: Nimbus look and feel for modern appearance

## 🏗️ Architecture

### Class Structure
```
StylishToDoApp
├── JFrame frame                           // Main application window
├── JTextField taskField                   // Task input field
├── JPanel taskPanel                       // Task display container
├── ArrayList<String> tasks                // Task data storage
├── Font customFont                        // Custom Roboto font
├── String FILE_NAME                       // File storage path
├── 
├── StylishToDoApp()                       // Constructor & UI setup
├── refreshTaskPanel()                     // Update task display
├── createIconButton(String, String)      // Create styled buttons
├── showEditDialog(String)                 // Task editing interface
├── loadCustomFont(String, float)         // Font loading utility
├── setLookAndFeel()                       // UI styling setup
├── loadTasks()                            // Load tasks from file
└── saveTasks()                            // Save tasks to file
```

### Component Hierarchy
```
JFrame (Main Window)
├── BorderLayout
├── North: JPanel (Top Panel)
│   ├── JTextField (Task Input)
│   └── JButton (Add Button)
├── Center: JPanel (Task Panel)
│   └── BoxLayout (Vertical)
│       └── Task Rows (Dynamic)
│           ├── JLabel (Task Text)
│           └── JPanel (Button Panel)
│               ├── JButton (Edit)
│               └── JButton (Delete)
```

### Resource Structure
```
task6/
├── StylishToDoApp.java       // Main application class
├── Roboto-Bold.ttf           // Custom font file
├── add.png                   // Add button icon
├── edit.png                  // Edit button icon
├── delete.png                // Delete button icon
└── README.md                 // This documentation

Generated Files:
├── tasks.txt                 // Persistent task storage
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher with Swing support
- Maven (for build management)
- Graphics support for GUI applications
- File system write permissions

### Required Resources
The application requires the following resource files to be in the task6 directory:
- `Roboto-Bold.ttf` - Custom font file
- `add.png` - Add button icon (24x24 pixels recommended)
- `edit.png` - Edit button icon (24x24 pixels recommended) 
- `delete.png` - Delete button icon (24x24 pixels recommended)

### Running the Application

#### Method 1: Using Maven
```bash
# Compile the project
mvn clean compile

# Run the GUI application
mvn exec:java -Dexec.mainClass="org.helal_anwar.task6.StylishToDoApp"
```

#### Method 2: Direct Java Execution
```bash
# Navigate to source directory
cd src/main/java

# Compile the Java file
javac org/helal_anwar/task6/StylishToDoApp.java

# Run the application
java org.helal_anwar.task6.StylishToDoApp
```

#### Method 3: Running the Compiled Class
```bash
# If .class file exists in org/ directory
java org.helal_anwar.task6.StylishToDoApp
```

## 📱 User Interface

### Main Application Window
The application opens in a 500x550 pixel window featuring:
- **Top Section**: Text input field and Add button
- **Main Area**: Scrollable list of tasks with edit/delete buttons
- **Modern Design**: Clean white background with professional styling

### Task Management Workflow

#### Adding a New Task
1. Enter task description in the text field
2. Click the "Add" button (with plus icon)
3. Task appears in the list immediately
4. Text field clears for next entry
5. Task automatically saved to file

#### Editing an Existing Task
1. Click the "Edit" button (with pencil icon) next to any task
2. Edit dialog opens with current task text
3. Modify the text as desired
4. Click "OK" to save changes
5. Task updates in the list and file

#### Deleting a Task
1. Click the "Delete" button (with trash icon) next to any task
2. Task immediately removed from list
3. Changes automatically saved to file

### Visual Elements

#### Color Scheme
- **Background**: Light gray (#F5F5F5) for modern appearance
- **Task Rows**: Pure white (#FFFFFF) for clear separation
- **Add/Edit Buttons**: Cornflower blue (#6495ED) for positive actions
- **Delete Button**: Red (#E10000) for destructive actions
- **Text**: Black for maximum readability

#### Typography
- **Font**: Roboto Bold for professional appearance
- **Size**: 14pt for task text, 13pt for buttons
- **Fallback**: Segoe UI Emoji if custom font unavailable

## 🔧 Technical Implementation

### GUI Components

#### Main Window Setup
```java
frame = new JFrame("Stylish To-Do List");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500, 550);
frame.setLayout(new BorderLayout(10, 10));
frame.getContentPane().setBackground(new Color(245, 245, 245));
```

#### Dynamic Task Display
```java
private void refreshTaskPanel() {
    taskPanel.removeAll();
    for (int i = 0; i < tasks.size(); i++) {
        String task = tasks.get(i);
        JPanel row = new JPanel(new BorderLayout(10, 5));
        // Create task row with label and buttons
    }
    taskPanel.revalidate();
    taskPanel.repaint();
}
```

#### Icon Button Creation
```java
private JButton createIconButton(String iconPath, String tooltip) {
    File iconFile = new File(iconPath);
    JButton button;
    if (iconFile.exists()) {
        ImageIcon icon = new ImageIcon(iconPath);
        Image scaledImage = icon.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
        button = new JButton(tooltip, new ImageIcon(scaledImage));
    } else {
        button = new JButton(tooltip); // fallback to text
    }
    // Additional styling...
}
```

### Data Persistence

#### File Storage Format
```
tasks.txt:
---------
Complete project documentation
Review code for Task 6
Test GUI application thoroughly
Update README files
```

#### Automatic Saving
```java
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
```

#### Data Loading
```java
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
```

### Custom Font Integration

#### Font Loading
```java
private Font loadCustomFont(String path, float size) {
    try {
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
        return font.deriveFont(size);
    } catch (Exception e) {
        System.out.println("Failed to load custom font. Using default.");
        return new Font("Segoe UI Emoji", Font.PLAIN, (int) size);
    }
}
```

## 🎨 Design Features

### Visual Enhancements
- **Custom Icons**: 24x24 pixel PNG icons for all buttons
- **Button Styling**: Color-coded buttons with rounded appearance
- **Font Integration**: Professional Roboto Bold typography
- **Layout Management**: BorderLayout and BoxLayout for responsive design
- **Empty Border**: Proper spacing around task rows

### User Experience
- **Immediate Feedback**: Tasks appear/update instantly
- **Error Handling**: Graceful fallbacks for missing resources
- **Intuitive Controls**: Clear visual indicators for all actions
- **Consistent Styling**: Uniform appearance across all components
- **Accessibility**: Tooltip text for all interactive elements

### Modern UI Patterns
- **Card Design**: Each task displayed as a clean white card
- **Icon Integration**: Visual icons enhance usability
- **Color Psychology**: Blue for positive actions, red for destructive
- **Responsive Layout**: Components adjust to content
- **Modal Dialogs**: Non-intrusive task editing

## 📁 Project Structure

### Source Files
```
task6/
├── StylishToDoApp.java       // Main application logic
├── README.md                 // This documentation

Resources:
├── Roboto-Bold.ttf           // Custom font (146KB)
├── add.png                   // Add icon (7.4KB)
├── edit.png                  // Edit icon (17KB)
└── delete.png                // Delete icon (8.6KB)

Generated:
└── tasks.txt                 // Persistent storage
```

### Dependencies
- **Java Swing**: Core GUI framework
- **AWT**: Graphics and event handling
- **I/O Classes**: File reading and writing
- **Collections**: ArrayList for task storage

## 🧪 Testing Scenarios

### Basic Functionality
1. **Application Startup**: Verify window opens correctly
2. **Task Addition**: Add various types of tasks
3. **Task Editing**: Modify existing tasks through edit dialog
4. **Task Deletion**: Remove tasks and verify updates
5. **Data Persistence**: Close and reopen to verify saved data

### Resource Handling
1. **Font Loading**: Test with and without custom font file
2. **Icon Loading**: Test with and without icon files
3. **File Permissions**: Test in directories with restricted access
4. **Large Task Lists**: Verify performance with many tasks

### Edge Cases
1. **Empty Tasks**: Handle empty text input
2. **Very Long Tasks**: Test with extensive text
3. **Special Characters**: Unicode and emoji support
4. **Rapid Operations**: Quick successive add/edit/delete actions

### Error Scenarios
1. **Missing Resources**: Application runs without fonts/icons
2. **File I/O Errors**: Handle read/write permission issues
3. **Invalid Characters**: Special characters in task text
4. **Memory Constraints**: Large numbers of tasks

## 🚀 Advanced Features

### Event-Driven Architecture
- **Action Listeners**: Button clicks trigger appropriate methods
- **Lambda Expressions**: Modern Java syntax for event handling
- **Index Management**: Proper handling of task positions
- **UI Refresh**: Automatic interface updates after operations

### Resource Management
- **Fallback Mechanisms**: Graceful degradation without resources
- **File Existence Checks**: Verify resource availability
- **Error Recovery**: Continue operation despite missing files
- **Memory Efficiency**: Optimal resource loading and usage

### User Interface Polish
- **Consistent Spacing**: Proper margins and padding
- **Visual Hierarchy**: Clear distinction between elements
- **Color Coordination**: Professional color palette
- **Icon Scaling**: Automatic icon resizing for consistency

## 🎯 Learning Outcomes

### Java Swing Mastery
- **Layout Managers**: BorderLayout, BoxLayout, and FlowLayout
- **Component Hierarchy**: Container and component relationships
- **Event Handling**: Action listeners and lambda expressions
- **Custom Styling**: Fonts, colors, and visual enhancements

### GUI Development Principles
- **User Experience**: Intuitive interface design
- **Visual Design**: Color theory and typography
- **Resource Integration**: External files and assets
- **Error Handling**: Graceful degradation and fallbacks

### Software Architecture
- **MVC Patterns**: Separation of data and presentation
- **File I/O Integration**: Persistent data storage
- **Resource Management**: External file handling
- **Event-Driven Programming**: Responsive user interfaces

## 🔮 Potential Enhancements

### Short-term Improvements
- [ ] **Task Priorities**: High, medium, low priority levels
- [ ] **Due Dates**: Calendar integration for task deadlines  
- [ ] **Task Categories**: Color-coded task organization
- [ ] **Search Functionality**: Find tasks by keyword
- [ ] **Task Completion**: Mark tasks as done with checkboxes

### Advanced Features
- [ ] **Drag and Drop**: Reorder tasks by dragging
- [ ] **Keyboard Shortcuts**: Hotkeys for common operations
- [ ] **Task Export**: Export tasks to various formats
- [ ] **Backup System**: Automatic task backups
- [ ] **Multi-language**: Internationalization support

### Professional Features
- [ ] **Database Storage**: Replace file storage with database
- [ ] **Cloud Sync**: Synchronize tasks across devices
- [ ] **Team Collaboration**: Shared task lists
- [ ] **Mobile App**: Companion mobile application
- [ ] **Web Interface**: Browser-based version

## 💡 Key Design Decisions

### Why Java Swing?
- **Native Look**: Platform-appropriate appearance
- **Rich Components**: Comprehensive UI component library
- **Mature Framework**: Stable, well-documented API
- **Desktop Integration**: Full desktop application capabilities

### Icon Integration
- **Visual Clarity**: Icons improve user understanding
- **Professional Appearance**: Modern application aesthetics
- **Accessibility**: Visual cues for different actions
- **Scalability**: Consistent sizing across components

### File-Based Storage
- **Simplicity**: No external database dependencies
- **Portability**: Easy backup and transfer
- **Human Readable**: Plain text for easy inspection
- **Reliability**: Immediate data persistence

### Custom Font Usage
- **Professional Appearance**: Modern, clean typography
- **Brand Consistency**: Unified visual identity
- **Readability**: Optimized for screen display
- **Fallback Support**: Graceful degradation

## 📈 Performance Considerations

- **Efficient Redraws**: Selective component updates
- **Memory Management**: Proper resource cleanup
- **Event Optimization**: Minimal processing in event handlers
- **File I/O Efficiency**: Buffered reading and writing
- **UI Responsiveness**: Non-blocking user interface

## 🔧 Troubleshooting

### Common Issues
1. **Application Won't Start**: Check Java version and classpath
2. **Missing Icons**: Verify icon files are in correct location
3. **Font Not Loading**: Check font file path and permissions
4. **Tasks Not Saving**: Verify write permissions in application directory

### Resource Requirements
- **Java Runtime**: JRE 8 or higher with Swing support
- **Graphics**: GUI-enabled environment (not headless)
- **Memory**: Minimal RAM requirements for small task lists
- **Storage**: Few KB for task storage and resources

---

**Author**: Hilal Anwar  
**Project**: Elevate Lab Internship - Task 6  
**Date**: August 2025  

*This Stylish To-Do Application demonstrates advanced GUI development with Java Swing, showcasing modern UI design principles, resource management, and user experience optimization.*
