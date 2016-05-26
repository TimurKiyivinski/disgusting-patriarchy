package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.SemesterDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SemesterFormCreateListener implements ActionListener {
    private SemesterDatabaseInterface observer;

    public SemesterFormCreateListener(SemesterDatabaseInterface observer) {
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
        String name = submit.getClientProperty("name").toString();
        if (id.equals("0")) {
            observer.createSemester(name);
        } else {
            observer.modifySemester(id, name);
        }
    }
}
