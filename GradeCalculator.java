import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GradeCalculator extends JFrame implements ActionListener {
    private JTextField[] subjectFields;
    private JLabel totalLabel, averageLabel, gradeLabel;
    private JButton calculateButton;

    public GradeCalculator() {
        // Frame settings
        setTitle("Grade Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create labels and text fields for subjects
        JLabel subjectLabel = new JLabel("Enter marks for 5 subjects:");
        subjectLabel.setBounds(20, 20, 200, 30);
        add(subjectLabel);

        subjectFields = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(20, 60 + i * 30, 100, 25);
            add(subjectFields[i]);
        }

        // Calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 220, 100, 30);
        
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Labels for displaying results
        totalLabel = new JLabel("Total Marks: ");
        totalLabel.setBounds(20, 260, 300, 30);
        add(totalLabel);

        averageLabel = new JLabel("Average Percentage: ");
        averageLabel.setBounds(20, 290, 300, 30);
        add(averageLabel);

        gradeLabel = new JLabel("Grade: ");
        gradeLabel.setBounds(20, 320, 300, 30);
        add(gradeLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            int total = 0;
            for (int i = 0; i < 5; i++) {
                total += Integer.parseInt(subjectFields[i].getText());
            }

            double average = total / 5.0;
            String grade;

            if (average >= 90) {
                grade = "A+";
            } else if (average >= 80) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B+";
            } else if (average >= 60) {
                grade = "B";
            } else if (average >= 50) {
                grade = "C";
            } else if (average >= 40) {
                grade = "D";
            } else {
                grade = "F";
            }

            totalLabel.setText("Total Marks: " + total);
            averageLabel.setText("Average Percentage: " + average + "%");
            gradeLabel.setText("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeCalculator calculator = new GradeCalculator();
            calculator.setVisible(true);
        });
    }
}

