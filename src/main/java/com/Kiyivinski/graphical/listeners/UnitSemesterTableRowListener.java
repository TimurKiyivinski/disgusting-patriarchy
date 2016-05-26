package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.ModelTable;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterTableInterface;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UnitSemesterTableRowListener implements ListSelectionListener {
    private ModelTable table;
    private UnitSemesterTableInterface observer;

    public UnitSemesterTableRowListener(ModelTable table, UnitSemesterTableInterface observer) {
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
            String id = table.getValueAt(table.getSelectedRow(), 1).toString();
            System.out.println(id);
            //observer.updateUnitSemesterForm(id);
        }
    }
}
