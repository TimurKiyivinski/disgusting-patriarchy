package com.Kiyivinski.graphical;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTabbedPane layout;

    public MainFrame() {
        this.setTitle("Java Assignment 2 - 4316886 Timothy Kiyui");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.layout = new JTabbedPane();
        this.add(layout);

        this.createLoginLayout();
        this.setVisible(true);
    }

    private void createLoginLayout() {

        JPanel databasePanel = new DatabasePanel();
        this.layout.addTab("Database", databasePanel);
        this.layout.setTabPlacement(SwingConstants.LEFT);

    }

    private void createMainLayout() {
        JPanel studentPanel = new StudentPanel();
        JPanel assessmentPanel = new AssessmentPanel();
        JPanel unitPanel = new UnitPanel();
        JPanel semesterPanel = new SemesterPanel();
        JPanel coursePanel = new CoursePanel();

        this.layout.addTab("Student", studentPanel);
        this.layout.addTab("Assessment", assessmentPanel);
        this.layout.addTab("Units", unitPanel);
        this.layout.addTab("Semesters", semesterPanel);
        this.layout.addTab("Courses", coursePanel);
    }
}
