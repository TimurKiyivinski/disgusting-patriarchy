package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitSemesterFormDeleteListener implements ActionListener {
    private UnitSemesterDatabaseInterface observer;

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
        delete.setVisible(false);
        String id = delete.getClientProperty("id").toString();
        observer.deleteUnitSemester(id);
    }
}
