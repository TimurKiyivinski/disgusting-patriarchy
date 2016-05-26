package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.StudentDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Student form create listener.
 */
public class StudentFormCreateListener implements ActionListener {
    private StudentDatabaseInterface observer;

    /**
     * Instantiates a new Student form create listener.
     *
     * @param observer the observer
     */
    public StudentFormCreateListener(StudentDatabaseInterface observer) {
        this.observer = observer;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        JButton submit = (JButton) e.getSource();
        String id = submit.getClientProperty("id").toString();
        String name = submit.getClientProperty("name").toString();
        String identification = submit.getClientProperty("identification").toString();
        String course = submit.getClientProperty("course").toString();
        if (id.equals("0")) {
            observer.createStudent(name, identification, course);
        } else {
            observer.modifyStudent(id, name, identification, course);
        }
    }
}
