import java.awt.*;
import javax.swing.*;

public class ToDoApp {
    private JFrame frame;
    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public ToDoApp() {
        frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Top panel with input field and add button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        taskField = new JTextField();
        JButton addButton = new JButton("Add Task");

        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        // Task list with scroll pane
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom panel with delete button
        JButton deleteButton = new JButton("Delete Selected");

        // Add components to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        // Event listeners
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());

        frame.setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskField.setText("");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
