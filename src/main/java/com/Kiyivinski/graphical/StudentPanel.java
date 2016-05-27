package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.StudentDatabaseInterface;
import com.Kiyivinski.models.Course;
import com.Kiyivinski.models.Student;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * The type Student panel.
 */
public class StudentPanel extends JPanel implements ConnectInterface, ModelTableInterface, StudentDatabaseInterface {
    private JScrollPane panelLeft;
    private JPanel panelRight;
    private String database;
    private String user;
    private String password;
    private StudentTable studentTable;

    /**
     * Instantiates a new Student panel.
     */
    public StudentPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridLayout layout = new GridLayout(1, 2, 25, 25);
        this.setLayout(layout);

        this.studentTable = new StudentTable(this);

        this.panelLeft = new JScrollPane(studentTable);
        this.panelRight = new JPanel();

        SpringLayout studentForm = new StudentForm(panelRight, this);
        panelRight.setLayout(studentForm);

        this.initializeLeftTable();

        this.add(panelLeft);
        this.add(panelRight);
    }

    /**
     * Initialize left table.
     */
    public void initializeLeftTable() {
        this.connect();
        DefaultTableModel model = (DefaultTableModel) this.studentTable.getModel();

        try {
            model.setRowCount(0);
        } catch (Exception e) {
            // Do not fail
        }

        this.studentTable.addCreate();
        List<Student> students = Student.all();
        for (Student s : students) {
            this.studentTable.addRow(s);
        }
        this.studentTable.setRowSelectionInterval(0, 0);
    }

    public void setConnect(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public void connect() {
        if (!Base.hasConnection()) {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
        }
    }

    public void updateModelForm(String id) {
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
        panelRight.revalidate();
    }

    public void createStudent(String name, String identification, String course) {
        this.connect();
        String course_id = Course.whereName(course).get(0).getID();
        try {
            Student student = Student.create(name, identification, course_id);
            studentTable.addRow(student);
        } catch (Exception e) {
            System.out.println("Fail");
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public void modifyStudent(String id, String name, String identification, String course) {
        this.connect();
        String course_id = Course.whereName(course).get(0).getID();
        Student modifyStudent = Student.find(id);
        try {
            modifyStudent.setName(name);
            modifyStudent.setIdentification(identification);
            modifyStudent.setCourse(course_id);
            this.initializeLeftTable();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public void deleteStudent(String id) {
        this.connect();
        Student deleteStudent = Student.find(id);
        try {
            deleteStudent.delete();
            this.initializeLeftTable();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }
}
