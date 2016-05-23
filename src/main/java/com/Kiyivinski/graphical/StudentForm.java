package com.Kiyivinski.graphical;

import javax.swing.*;

public class StudentForm extends SpringLayout {
    private final int TEXT_LENGTH = 14;

    StudentForm(JPanel parent) {
        JLabel labelName = new JLabel("Name:");
        JTextField inputName = new JTextField("", this.TEXT_LENGTH);
        JLabel labelIdentification = new JLabel("Student ID:");
        JTextField inputIdentification = new JTextField("", this.TEXT_LENGTH);
        JLabel labelCourse = new JLabel("Course:");
        JComboBox inputCourse = new CourseComboBox();

        parent.add(labelName);
        parent.add(inputName);
        parent.add(labelIdentification);
        parent.add(inputIdentification);
        parent.add(labelCourse);
        parent.add(inputCourse);

        this.putConstraint(SpringLayout.WEST, labelName, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelName, 25, SpringLayout.NORTH, parent);
        this.putConstraint(SpringLayout.WEST, inputName, 30, SpringLayout.EAST, labelName);
        this.putConstraint(SpringLayout.NORTH, inputName, -2, SpringLayout.NORTH, labelName);

        this.putConstraint(SpringLayout.WEST , labelIdentification, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelIdentification, 30, SpringLayout.NORTH, labelName);
        this.putConstraint(SpringLayout.WEST , inputIdentification, 0, SpringLayout.WEST, inputName);
        this.putConstraint(SpringLayout.NORTH, inputIdentification, 28, SpringLayout.NORTH, inputName);

        this.putConstraint(SpringLayout.WEST , labelCourse, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelCourse, 30, SpringLayout.NORTH, labelIdentification);
        this.putConstraint(SpringLayout.WEST , inputCourse, 0, SpringLayout.WEST, inputIdentification);
        this.putConstraint(SpringLayout.NORTH, inputCourse, 28, SpringLayout.NORTH, inputIdentification);
    }
}
