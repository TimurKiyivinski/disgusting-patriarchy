package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ConnectInterface;
import com.Kiyivinski.graphical.listeners.StudentTableInterface;
import com.Kiyivinski.models.Student;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class StudentPanel extends JPanel implements ConnectInterface, StudentTableInterface {
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

        SpringLayout studentForm = new StudentForm(panelRight);
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

    public void updateStudentForm(String identification) {
        if (! Base.hasConnection()) {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
        }
        panelRight.removeAll();
        SpringLayout rightPane;
        if (identification == "000000") {
            rightPane = new StudentForm(panelRight, null);
        } else {
            Student student = Student.whereIdentification(identification).get(0);
            rightPane = new StudentForm(panelRight, student);
        }
        panelRight.setLayout(rightPane);
    }
}
