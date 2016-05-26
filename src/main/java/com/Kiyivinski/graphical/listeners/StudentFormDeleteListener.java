package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.StudentDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Student form delete listener.
 */
public class StudentFormDeleteListener implements ActionListener {
    private StudentDatabaseInterface observer;

    /**
     * Instantiates a new Student form delete listener.
     *
     * @param observer the observer
     */
    public StudentFormDeleteListener(StudentDatabaseInterface observer) {
        this.observer = observer;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        JButton delete = (JButton) e.getSource();
        delete.setVisible(false);
        String id = delete.getClientProperty("id").toString();
        observer.deleteStudent(id);
    }
}
