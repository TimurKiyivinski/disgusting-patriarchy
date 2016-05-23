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

    public StudentTableRowListener(StudentTable table, JPanel updatePanel) {
        this.table = table;
        this.updatePanel = updatePanel;
    }

    /**
     * Called whenever the value of the selection changes.
     *
     * @param e the event that characterizes the change.
     */
    public void valueChanged(ListSelectionEvent e) {
        if (! e.getValueIsAdjusting()) {
            String identification = table.getValueAt(table.getSelectedRow(), 0).toString();
            Student student = Student.whereIdentification(identification).get(0);
            updatePanel.setLayout(new StudentForm(updatePanel, student));
        }
    }
}
