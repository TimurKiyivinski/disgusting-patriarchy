package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.StudentTable;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StudentTableRowListener implements ListSelectionListener {
    private StudentTable table;
    private StudentTableInterface observer;

    public StudentTableRowListener(StudentTable table, StudentTableInterface observer) {
        this.table = table;
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
