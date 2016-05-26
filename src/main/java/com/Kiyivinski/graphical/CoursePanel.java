package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.CourseDatabaseInterface;
import com.Kiyivinski.models.Course;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CoursePanel extends JPanel implements ConnectInterface, ModelTableInterface, CourseDatabaseInterface {
    private JScrollPane panelLeft;
    private JPanel panelRight;
    private String database;
    private String user;
    private String password;
    private CourseTable courseTable;

    public CoursePanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridLayout layout = new GridLayout(1, 2, 25, 25);
        this.setLayout(layout);

        this.courseTable = new CourseTable(this);
        this.courseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.panelLeft = new JScrollPane(courseTable);
        this.panelRight = new JPanel();

        SpringLayout courseForm = new CourseForm(panelRight, this);
        panelRight.setLayout(courseForm);

        this.initializeLeftTable();

        this.add(panelLeft);
        this.add(panelRight);
    }

    public void initializeLeftTable() {
        this.connect();
        DefaultTableModel model = (DefaultTableModel) this.courseTable.getModel();

        try {
            model.setRowCount(0);
        } catch (Exception e) {
            // Do not fail
        }

        this.courseTable.addCreate();
        List<Course> courses = Course.all();
        for (Course s : courses) {
            this.courseTable.addRow(s);
        }
        this.courseTable.setRowSelectionInterval(0, 0);
    }

    public void setConnect(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public void connect() {
        if (! Base.hasConnection()) {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
        }
    }

    public void updateModelForm(String id) {
        this.connect();
        panelRight.removeAll();
        SpringLayout rightPane;
        if (id.equals("0")) {
            rightPane = new CourseForm(panelRight, this);
        } else {
            Course course = Course.find(id);
            rightPane = new CourseForm(panelRight, course, this);
        }
        panelRight.setLayout(rightPane);
        panelRight.revalidate();
    }

    public void createCourse(String name) {
        this.connect();
        try {
            Course course = Course.create(name);
            courseTable.addRow(course);
        } catch (Exception e) {
            System.out.println("Fail");
        }
    }

    public void modifyCourse(String id, String name) {
        this.connect();
        Course modifyCourse = Course.find(id);
        try {
            modifyCourse.setName(name);
            this.initializeLeftTable();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCourse(String id) {
        this.connect();
        Course deleteCourse = Course.find(id);
        try {
            deleteCourse.delete();
            this.initializeLeftTable();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
