package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Unit semester form delete listener.
 */
public class UnitSemesterFormDeleteListener implements ActionListener {
    private UnitSemesterDatabaseInterface observer;

    /**
     * Instantiates a new Unit semester form delete listener.
     *
     * @param observer the observer
     */
    public UnitSemesterFormDeleteListener(UnitSemesterDatabaseInterface observer) {
        this.observer = observer;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        JButton delete = (JButton) e.getSource();
        String unit_id = delete.getClientProperty("unit_id").toString();
        String semester_id = delete.getClientProperty("semester_id").toString();
        observer.deleteUnitSemester(unit_id, semester_id);
    }
}
