package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.StudentForm;
import com.Kiyivinski.graphical.StudentTable;
import com.Kiyivinski.models.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StudentTableRowListener implements ListSelectionListener {
    private StudentTable table;
    private JPanel updatePanel;
    private StudentTableInterface observer;

    public StudentTableRowListener(StudentTable table, JPanel updatePanel, StudentTableInterface observer) {
        this.table = table;
        this.updatePanel = updatePanel;
        this.observer = observer;
    }

    /**
     * Called whenever the value of the selection changes.
     *
     * @param e the event that characterizes the change.
     */
    public void valueChanged(ListSelectionEvent e) {
        if (! e.getValueIsAdjusting()) {
            String identification = table.getValueAt(table.getSelectedRow(), 1).toString();
            observer.updateStudentForm(identification);
        }
    }
}
