package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonListener implements ActionListener {
    private JTextField inputDatabase;
    private JTextField inputUser;
    private JTextField inputPassword;
    private ConnectInterface observer;

    public LoginButtonListener(JTextField inputDatabase, JTextField inputUser, JTextField inputPassword, ConnectInterface observer) {
        this.inputDatabase = inputDatabase;
        this.inputUser= inputUser;
        this.inputPassword = inputPassword;
        this.observer = observer;
    }

    public void actionPerformed(ActionEvent e) {
        JButton submit = (JButton) e.getSource();

        submit.setText("Connecting");

        Runnable tryLogin = new login(submit, inputDatabase, inputUser, inputPassword, observer);
        new Thread(tryLogin).start();
    }

    private class login implements Runnable {
        private JButton submit;
        private JTextField inputDatabase;
        private JTextField inputUser;
        private JTextField inputPassword;
        private ConnectInterface observer;

        login(JButton submit,JTextField inputDatabase, JTextField inputUser, JTextField inputPassword, ConnectInterface observer) {
            this.submit = submit;
            this.inputDatabase = inputDatabase;
            this.inputUser= inputUser;
            this.inputPassword = inputPassword;
            this.observer = observer;
        }

        public void run() {
            String database = submit.getClientProperty("database").toString();
            String user = submit.getClientProperty("user").toString();
            String password = submit.getClientProperty("password").toString();
            try {
                Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
                this.observer.setConnect(database, user, password);
            } catch (Exception exception) {
                this.inputDatabase.setForeground(Color.RED);
                this.inputUser.setForeground(Color.RED);
                this.inputPassword.setForeground(Color.RED);
                submit.setText("Retry Connection");
            }
        }
    }
}
