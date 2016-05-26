package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.models.Unit;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UnitSemesterComboBoxButtonListener implements ItemListener {
    private String key;
    private JButton update;

    public UnitSemesterComboBoxButtonListener(String key, JButton update) {
        this.key = key;
        this.update = update;
    }

    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations
     * that need to occur when an item is selected (or deselected).
     *
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox comboBox = (JComboBox) e.getSource();
            Unit u = (Unit) comboBox.getSelectedItem();
            this.update.putClientProperty(key, u.getID());
        }
    }
}
