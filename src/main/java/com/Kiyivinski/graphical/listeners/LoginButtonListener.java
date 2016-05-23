package com.Kiyivinski.graphical.listeners;

import org.javalite.activejdbc.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonListener implements ActionListener {
    private JTextField inputDatabase;
    private JTextField inputUser;
    private JTextField inputPassword;
    private LoginInterface observer;

    public LoginButtonListener(JTextField inputDatabase, JTextField inputUser, JTextField inputPassword, LoginInterface observer) {
        this.inputDatabase = inputDatabase;
        this.inputUser= inputUser;
        this.inputPassword = inputPassword;
        this.observer = observer;
    }

    public void actionPerformed(ActionEvent e) {
        JButton submit = (JButton) e.getSource();
        String database = submit.getClientProperty("database").toString();
        String user = submit.getClientProperty("user").toString();
        String password = submit.getClientProperty("password").toString();
        try {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
            this.observer.login();
        } catch (Exception exception) {
            this.inputDatabase.setForeground(Color.RED);
            this.inputUser.setForeground(Color.RED);
            this.inputPassword.setForeground(Color.RED);
            submit.setText("Retry Connection");
        }
    }
}
