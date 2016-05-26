package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.listeners.interfaces.CourseDatabaseInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseFormCreateListener implements ActionListener {
    private CourseDatabaseInterface observer;

    public CourseFormCreateListener(CourseDatabaseInterface observer) {
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
        if (id.equals("0")) {
            observer.createCourse(name);
        } else {
            observer.modifyCourse(id, name);
        }
    }
}
