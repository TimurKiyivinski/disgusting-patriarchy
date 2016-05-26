package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.UnitDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitSemesterFormCreateListener implements ActionListener {
    private UnitDatabaseInterface observer;

    public UnitSemesterFormCreateListener(UnitDatabaseInterface observer) {
        this.observer = observer;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        JButton submit = (JButton) e.getSource();
        String id = submit.getClientProperty("id").toString();
        String unit_id = submit.getClientProperty("unit_id").toString();
        String semester_id = submit.getClientProperty("semester_id").toString();
        if (id.equals("0")) {
            observer.createUnit(unit_id, semester_id);
        } else {
            observer.modifyUnit(id, unit_id, semester_id);
        }
    }
}
