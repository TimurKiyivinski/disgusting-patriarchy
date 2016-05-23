package com.Kiyivinski.graphical;

import javax.swing.*;
import java.awt.*;

public class DatabasePanel extends JPanel {
    DatabasePanel() {
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        JLabel labelDatabase = new JLabel("Database Address:");
        JTextField inputDatabase = new JTextField("192.168.99.100:3306/java", 32);
        JLabel labelUser = new JLabel("Username:");
        JTextField inputUser = new JTextField("root", 32);
        JLabel labelPassword = new JLabel("Password:");
        JPasswordField inputPassword = new JPasswordField("password", 32);
        JButton submit = new JButton("Connect");

        this.add(labelDatabase);
        this.add(inputDatabase);
        this.add(labelUser);
        this.add(inputUser);
        this.add(labelPassword);
        this.add(inputPassword);
        this.add(submit);

        layout.putConstraint(SpringLayout.WEST, labelDatabase, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelDatabase, 25, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, inputDatabase, 5, SpringLayout.EAST, labelDatabase);
        layout.putConstraint(SpringLayout.NORTH, inputDatabase, -2, SpringLayout.NORTH, labelDatabase);

        layout.putConstraint(SpringLayout.WEST , labelUser, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelUser, 30, SpringLayout.NORTH, labelDatabase);
        layout.putConstraint(SpringLayout.WEST , inputUser, 0, SpringLayout.WEST, inputDatabase);
        layout.putConstraint(SpringLayout.NORTH, inputUser, 28, SpringLayout.NORTH, inputDatabase);

        layout.putConstraint(SpringLayout.WEST , labelPassword, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelPassword, 30, SpringLayout.NORTH, labelUser);
        layout.putConstraint(SpringLayout.WEST , inputPassword, 0, SpringLayout.WEST, inputUser);
        layout.putConstraint(SpringLayout.NORTH, inputPassword, 28, SpringLayout.NORTH, inputUser);

        layout.putConstraint(SpringLayout.EAST, submit, 0, SpringLayout.EAST, inputPassword);
        layout.putConstraint(SpringLayout.NORTH, submit, 28, SpringLayout.NORTH, inputPassword);
    }
}
