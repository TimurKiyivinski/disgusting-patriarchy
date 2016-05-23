package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.LoginInputListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabasePanel extends JPanel {
    private final int TEXT_LENGTH = 48;

    private String database;
    private String user;
    private String password;

    DatabasePanel() {
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        JLabel labelDatabase = new JLabel("Database Address:");
        final JTextField inputDatabase = new JTextField("192.168.99.100:3306/java", this.TEXT_LENGTH);
        final JLabel labelUser = new JLabel("Username:");
        JTextField inputUser = new JTextField("root", this.TEXT_LENGTH);
        JLabel labelPassword = new JLabel("Password:");
        JPasswordField inputPassword = new JPasswordField("password", this.TEXT_LENGTH);
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

        submit.putClientProperty("database", inputDatabase.getText());
        submit.putClientProperty("user", inputUser.getText());
        submit.putClientProperty("password", inputPassword.getPassword());

        inputDatabase.getDocument().addDocumentListener(
                new LoginInputListener("database", inputDatabase, submit)
        );
        inputUser.getDocument().addDocumentListener(
                new LoginInputListener("user", inputUser, submit)
        );
        inputPassword.getDocument().addDocumentListener(
                new LoginInputListener("password", inputPassword, submit)
        );

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JButton) e.getSource()).getClientProperty("database"));
            }
        });
    }
}