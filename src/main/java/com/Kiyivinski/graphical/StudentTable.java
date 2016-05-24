package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.StudentTableInterface;
import com.Kiyivinski.graphical.listeners.StudentTableRowListener;
import com.Kiyivinski.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentTable extends JTable {
    private DefaultTableModel model;

    StudentTable(StudentTableInterface observer) {
        this.model = new DefaultTableModel();
        this.model.addColumn("ID");
        this.model.addColumn("Name");
        this.model.addColumn("Student ID");
        this.model.addColumn("Course");

        this.getSelectionModel().addListSelectionListener(new StudentTableRowListener(this, observer));

        this.setModel(this.model);

        Object [] row = new Object[]{
                "0", "Create Student", "000000", ""
        };
        this.model.addRow(row);
    }

    public void addRow(Student student) {
        Object [] row = new Object[]{
                student.getID(),
                student.getName(),
                student.getIdentification(),
                student.getCourse().getName()
        };
        this.model.addRow(row);
    }
}
