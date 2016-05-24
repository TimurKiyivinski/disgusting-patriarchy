package com.Kiyivinski.graphical.listeners;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InputFieldButtonListener implements DocumentListener {
    private String key;
    private JTextField field;
    private JButton update;

    public InputFieldButtonListener(String key, JTextField field, JButton update) {
        this.key = key;
        this.field = field;
        this.update = update;
    }

    public void insertUpdate(DocumentEvent e) {
        this.update();
    }

    public void removeUpdate(DocumentEvent e) {
        this.update();
    }

    public void changedUpdate(DocumentEvent e) {
        this.update();
    }

    private void update() {
        this.update.putClientProperty(key, field.getText());
    }
}
