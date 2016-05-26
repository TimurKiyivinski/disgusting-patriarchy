package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;

import javax.swing.*;
import java.awt.*;

/**
 * The type Database panel.
 */
public class DatabasePanel extends JPanel {
    /**
     * Instantiates a new Database panel.
     *
     * @param observer the observer
     */
    public DatabasePanel(ConnectInterface observer) {
        this.setLayout(new GridLayout());

        JPanel loginPanel = new JPanel();
        LoginForm loginForm = new LoginForm(loginPanel, observer);
        loginPanel.setLayout(loginForm);

        this.add(loginPanel);
    }
}
