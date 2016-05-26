package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.UnitDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitFormCreateListener implements ActionListener {
    private UnitDatabaseInterface observer;

    public UnitFormCreateListener(UnitDatabaseInterface observer) {
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
        String code = submit.getClientProperty("code").toString();
        if (id.equals("0")) {
            observer.createUnit(name, code);
        } else {
            observer.modifyUnit(id, name, code);
        }
    }
}
