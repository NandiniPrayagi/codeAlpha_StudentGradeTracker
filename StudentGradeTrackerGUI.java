
import java.util.ArrayList;
import javax.swing.*;

public class StudentGradeTrackerGUI {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        JFrame frame = new JFrame("Student Grade Tracker");
        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(20, 20, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 20, 150, 25);
        frame.add(nameField);

        JLabel gradeLabel = new JLabel("Student Grade:");
        gradeLabel.setBounds(20, 60, 100, 25);
        frame.add(gradeLabel);

        JTextField gradeField = new JTextField();
        gradeField.setBounds(130, 60, 150, 25);
        frame.add(gradeField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(50, 100, 100, 30);
        frame.add(addButton);

        JButton reportButton = new JButton("Show Report");
        reportButton.setBounds(180, 100, 130, 30);
        frame.add(reportButton);

        JTextArea output = new JTextArea();
        output.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setBounds(20, 150, 440, 180);
        frame.add(scrollPane);

        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double grade = Double.parseDouble(gradeField.getText());

                names.add(name);
                grades.add(grade);

                JOptionPane.showMessageDialog(frame,
                        "Student Added Successfully!");

                nameField.setText("");
                gradeField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter valid data.");
            }
        });

        reportButton.addActionListener(e -> {

            if (grades.isEmpty()) {
                output.setText("No student data entered.");
                return;
            }

            double total = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            String report = "===== STUDENT REPORT =====\n\n";

            for (int i = 0; i < names.size(); i++) {

                report += "Student " + (i + 1)
                        + " : "
                        + names.get(i)
                        + " - "
                        + grades.get(i)
                        + "\n";

                total += grades.get(i);

                if (grades.get(i) > highest) {
                    highest = grades.get(i);
                }

                if (grades.get(i) < lowest) {
                    lowest = grades.get(i);
                }
            }

            double average = total / grades.size();

            report += "\nNumber of Students : " + grades.size();
            report += "\nAverage Score : " + average;
            report += "\nHighest Score : " + highest;
            report += "\nLowest Score : " + lowest;

            output.setText(report);
        });

        frame.setVisible(true);
    }
}
