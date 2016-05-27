package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Unit semester form create listener.
 */
public class UnitSemesterFormCreateListener implements ActionListener {
    private UnitSemesterDatabaseInterface observer;

    /**
     * Instantiates a new Unit semester form create listener.
     *
     * @param observer the observer
     */
    public UnitSemesterFormCreateListener(UnitSemesterDatabaseInterface observer) {
        this.observer = observer;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        JButton submit = (JButton) e.getSource();
        String unit_id = submit.getClientProperty("unit_id").toString();
        String semester_id = submit.getClientProperty("semester_id").toString();
        observer.createUnitSemester(unit_id, semester_id);
    }
}
