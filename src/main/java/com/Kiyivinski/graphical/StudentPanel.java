package com.Kiyivinski.graphical;

import com.Kiyivinski.models.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentPanel extends JPanel {
    StudentPanel() {
        GridLayout layout = new GridLayout(1, 2, 25, 25);
        this.setLayout(layout);

        StudentTable studentPane = new StudentTable();

        List<Student> students = Student.all();
        for (Student s: students) {
            studentPane.addRow(s);
        }

        this.add(studentPane);
    }
}
