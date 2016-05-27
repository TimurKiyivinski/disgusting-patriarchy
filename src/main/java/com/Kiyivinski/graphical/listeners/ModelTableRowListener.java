package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.ModelTable;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * The type Model table row listener.
 */
public class ModelTableRowListener implements ListSelectionListener {
    private ModelTable table;
    private ModelTableInterface observer;

    /**
     * Instantiates a new Model table row listener.
     *
     * @param table    the table
     * @param observer the observer
     */
    public ModelTableRowListener(ModelTable table, ModelTableInterface observer) {
        this.table = table;
        this.observer = observer;
    }

    /**
     * Called whenever the value of the selection changes.
     *
     * @param e the event that characterizes the change.
     */
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String id = table.getValueAt(table.getSelectedRow(), 0).toString();
            observer.updateModelForm(id);
        }
    }
}
