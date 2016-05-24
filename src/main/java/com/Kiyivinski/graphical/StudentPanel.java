package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import com.Kiyivinski.graphical.listeners.interfaces.StudentTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.StudentDatabaseInterface;
import com.Kiyivinski.models.Course;
import com.Kiyivinski.models.Student;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class StudentPanel extends JPanel implements ConnectInterface, StudentTableInterface, StudentDatabaseInterface {
    private JScrollPane panelLeft;
    private JPanel panelRight;
    private String database;
    private String user;
    private String password;

    public StudentPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridLayout layout = new GridLayout(1, 2, 25, 25);
        this.setLayout(layout);

        StudentTable studentTable = new StudentTable(this);
        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.panelLeft = new JScrollPane(studentTable);
        this.panelRight = new JPanel();

        SpringLayout studentForm = new StudentForm(panelRight, this);
        panelRight.setLayout(studentForm);

        List<Student> students = Student.all();
        for (Student s: students) {
            studentTable.addRow(s);
        }

        this.add(panelLeft);
        this.add(panelRight);
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

    public void updateStudentForm(String id) {
        this.connect();
        panelRight.removeAll();
        SpringLayout rightPane;
        if (id.equals("0")) {
            rightPane = new StudentForm(panelRight, this);
        } else {
            Student student = Student.find(id);
            rightPane = new StudentForm(panelRight, student, this);
        }
        panelRight.setLayout(rightPane);
    }

    public void createStudent(String name, String identification, String course) {
        this.connect();
        String course_id = Course.whereName(course).get(0).getID();
        Student.create(name, identification, course_id);
    }

    public void modifyStudent(String id, String name, String identification, String course) {
        this.connect();
        String course_id = Course.whereName(course).get(0).getID();
        Student modifyStudent = Student.find(id);
        modifyStudent.setName(name);
        modifyStudent.setIdentification(identification);
        modifyStudent.setCourse(course_id);
    }
}
