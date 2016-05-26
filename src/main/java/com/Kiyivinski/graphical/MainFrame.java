package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import org.javalite.activejdbc.Base;

import javax.swing.*;

public class MainFrame extends JFrame implements ConnectInterface {
    private JTabbedPane layout;
    private String database;
    private String user;
    private String password;

    public MainFrame() {
        this.setTitle("Java Assignment 2 - 4316886 Timothy Kiyui");
        this.setSize(1024, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.layout = new JTabbedPane();
        this.add(layout);

        this.createLoginLayout();
        this.setVisible(true);
    }

    private void createLoginLayout() {

        JPanel databasePanel = new DatabasePanel(this);
        this.layout.addTab("Database", databasePanel);
        this.layout.setTabPlacement(SwingConstants.LEFT);

    }

    private void createMainLayout() {
        StudentPanel studentPanel = new StudentPanel();
        studentPanel.setConnect(this.database, this.user, this.password);

        UnitPanel unitPanel = new UnitPanel();
        unitPanel.setConnect(this.database, this.user, this.password);

        SemesterPanel semesterPanel = new SemesterPanel();
        semesterPanel.setConnect(this.database, this.user, this.password);

        CoursePanel coursePanel = new CoursePanel();
        coursePanel.setConnect(this.database, this.user, this.password);

        JPanel assessmentPanel = new AssessmentPanel();

        this.layout.addTab("Student", studentPanel);
        this.layout.addTab("Units", unitPanel);
        this.layout.addTab("Semesters", semesterPanel);
        this.layout.addTab("Courses", coursePanel);
        this.layout.addTab("Assessment", assessmentPanel);
    }

    public void setConnect(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;

        this.layout.removeTabAt(0);
        this.createMainLayout();
    }

    public void connect() {
        if (! Base.hasConnection()) {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
        }
    }
}
