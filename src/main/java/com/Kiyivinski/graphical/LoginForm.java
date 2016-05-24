package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.LoginButtonListener;
import com.Kiyivinski.graphical.listeners.LoginInputListener;
import com.Kiyivinski.graphical.listeners.LoginInterface;

import javax.swing.*;

public class LoginForm extends SpringLayout {
    private final int TEXT_LENGTH = 48;

    public LoginForm(JPanel parent, LoginInterface observer) {
        JLabel labelDatabase = new JLabel("Database Address:");
        JTextField inputDatabase = new JTextField("192.168.99.100:3306/java", this.TEXT_LENGTH);
        JLabel labelUser = new JLabel("Username:");
        JTextField inputUser = new JTextField("root", this.TEXT_LENGTH);
        JLabel labelPassword = new JLabel("Password:");
        JTextField inputPassword = new JTextField("password", this.TEXT_LENGTH);
        JButton submit = new JButton("Connect");

        parent.add(labelDatabase);
        parent.add(inputDatabase);
        parent.add(labelUser);
        parent.add(inputUser);
        parent.add(labelPassword);
        parent.add(inputPassword);
        parent.add(submit);

        this.putConstraint(SpringLayout.WEST, labelDatabase, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelDatabase, 25, SpringLayout.NORTH, parent);
        this.putConstraint(SpringLayout.WEST, inputDatabase, 5, SpringLayout.EAST, labelDatabase);
        this.putConstraint(SpringLayout.NORTH, inputDatabase, -2, SpringLayout.NORTH, labelDatabase);

        this.putConstraint(SpringLayout.WEST , labelUser, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelUser, 30, SpringLayout.NORTH, labelDatabase);
        this.putConstraint(SpringLayout.WEST , inputUser, 0, SpringLayout.WEST, inputDatabase);
        this.putConstraint(SpringLayout.NORTH, inputUser, 28, SpringLayout.NORTH, inputDatabase);

        this.putConstraint(SpringLayout.WEST , labelPassword, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelPassword, 30, SpringLayout.NORTH, labelUser);
        this.putConstraint(SpringLayout.WEST , inputPassword, 0, SpringLayout.WEST, inputUser);
        this.putConstraint(SpringLayout.NORTH, inputPassword, 28, SpringLayout.NORTH, inputUser);

        this.putConstraint(SpringLayout.EAST, submit, 0, SpringLayout.EAST, inputPassword);
        this.putConstraint(SpringLayout.NORTH, submit, 28, SpringLayout.NORTH, inputPassword);

        submit.putClientProperty("database", inputDatabase.getText());
        submit.putClientProperty("user", inputUser.getText());
        submit.putClientProperty("password", inputPassword.getText());

        inputDatabase.getDocument().addDocumentListener(
                new LoginInputListener("database", inputDatabase, submit)
        );
        inputUser.getDocument().addDocumentListener(
                new LoginInputListener("user", inputUser, submit)
        );
        inputPassword.getDocument().addDocumentListener(
                new LoginInputListener("password", inputPassword, submit)
        );

        submit.addActionListener(new LoginButtonListener(inputDatabase, inputUser, inputPassword, observer));

    }
}
