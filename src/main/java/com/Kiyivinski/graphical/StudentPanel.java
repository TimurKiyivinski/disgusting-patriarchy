package com.Kiyivinski.graphical;

import com.Kiyivinski.models.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class StudentPanel extends JPanel {
    StudentPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridLayout layout = new GridLayout(1, 2, 25, 25);
        this.setLayout(layout);

        StudentTable studentPane = new StudentTable();
        studentPane.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane panelLeft = new JScrollPane(studentPane);
        JPanel panelRight = new JPanel();
        studentPane.setUpdatePanel(panelRight);

        SpringLayout rightPane = new StudentForm(panelRight);
        panelRight.setLayout(rightPane);

        List<Student> students = Student.all();
        for (Student s: students) {
            studentPane.addRow(s);
        }

        this.add(panelLeft);
        this.add(panelRight);
    }
}
