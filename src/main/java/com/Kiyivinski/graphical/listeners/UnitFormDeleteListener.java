package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.UnitDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Unit form delete listener.
 */
public class UnitFormDeleteListener implements ActionListener {
    private UnitDatabaseInterface observer;

    /**
     * Instantiates a new Unit form delete listener.
     *
     * @param observer the observer
     */
    public UnitFormDeleteListener(UnitDatabaseInterface observer) {
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
        observer.deleteUnit(id);
    }
}
