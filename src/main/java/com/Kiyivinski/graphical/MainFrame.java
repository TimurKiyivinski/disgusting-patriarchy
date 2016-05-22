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

        JPanel panelStudents = new JPanel();
        panelStudents.add(new JButton("Students"));

        JPanel panelAssessments = new JPanel();
        panelAssessments.add(new JButton("Assessments"));

        JPanel panelUnits = new JPanel();
        panelUnits.add(new JButton("Units"));

        JPanel panelCourses = new JPanel();
        panelCourses.add(new JButton("Courses"));

        JPanel panelSemesters = new JPanel();
       panelSemesters.add(new JButton("Semesters"));

        layout.addTab("Students", panelStudents);
        layout.addTab("Assessments", panelAssessments);
        layout.addTab("Units", panelUnits);
        layout.addTab("Courses", panelCourses);
        layout.addTab("Semesters", panelSemesters);

        this.add(layout);
    }
}
