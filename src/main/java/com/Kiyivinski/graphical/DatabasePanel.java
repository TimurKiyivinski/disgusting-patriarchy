package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;

import javax.swing.*;
import java.awt.*;

public class DatabasePanel extends JPanel {
    public DatabasePanel(ConnectInterface observer) {
        this.setLayout(new GridLayout());

        JPanel loginPanel = new JPanel();
        LoginForm loginForm = new LoginForm(loginPanel, observer);
        loginPanel.setLayout(loginForm);

        this.add(loginPanel);
    }
}
