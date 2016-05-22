package com.Kiyivinski.graphical;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.createLayout();
    }

    private void createLayout() {
        JTabbedPane layout = new JTabbedPane();

        JPanel studentPanel = new StudentPanel();
        JPanel assessmentPanel = new AssessmentPanel();
        JPanel unitPanel = new UnitPanel();
        JPanel semesterPanel = new SemesterPanel();
        JPanel coursePanel = new CoursePanel();

        layout.addTab("Student", studentPanel);
        layout.addTab("Assessment", assessmentPanel);
        layout.addTab("Units", unitPanel);
        layout.addTab("Semesters", semesterPanel);
        layout.addTab("Courses", coursePanel);

        layout.setTabPlacement(SwingConstants.LEFT);

        this.add(layout);
    }
}
