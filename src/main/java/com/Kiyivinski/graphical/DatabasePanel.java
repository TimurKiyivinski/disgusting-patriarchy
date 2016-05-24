package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.LoginInterface;

import javax.swing.*;
import java.awt.*;

public class DatabasePanel extends JPanel {
    public DatabasePanel(LoginInterface observer) {
        this.setLayout(new GridLayout());

        JPanel loginPanel = new JPanel();
        LoginForm loginForm = new LoginForm(loginPanel, observer);
        loginPanel.setLayout(loginForm);

        this.add(loginPanel);
    }
}
