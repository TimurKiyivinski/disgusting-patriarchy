package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.StudentTableInterface;
import com.Kiyivinski.graphical.listeners.StudentTableRowListener;
import com.Kiyivinski.models.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentTable extends JTable {
    private DefaultTableModel model;
    private JPanel updatePanel;

    StudentTable(StudentTableInterface observer) {
        this.model = new DefaultTableModel();
        this.model.addColumn("Name");
        this.model.addColumn("Student ID");
        this.model.addColumn("Course");

        this.getSelectionModel().addListSelectionListener(new StudentTableRowListener(this, updatePanel, observer));

        this.setModel(this.model);
    }

    public void addRow(Student student) {
        Object [] row = new Object[]{
                student.getName(),
                student.getIdentification(),
                student.getCourse().getName()
        };
        this.model.addRow(row);
    }

    public void setUpdatePanel(JPanel updatePanel) {
        this.updatePanel = updatePanel;
    }
}
