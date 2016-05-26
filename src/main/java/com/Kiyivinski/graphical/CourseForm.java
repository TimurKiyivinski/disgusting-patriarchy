package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.InputFieldButtonListener;
import com.Kiyivinski.graphical.listeners.CourseFormCreateListener;
import com.Kiyivinski.graphical.listeners.CourseFormDeleteListener;
import com.Kiyivinski.graphical.listeners.interfaces.CourseDatabaseInterface;
import com.Kiyivinski.models.Course;

import javax.swing.*;

public class CourseForm extends SpringLayout {
    private final int TEXT_LENGTH = 14;

    public CourseForm(JPanel parent, Course modifyCourse, CourseDatabaseInterface observer) {
        JLabel labelName = new JLabel("Name:");
        JTextField inputName;
        JButton submit;
        if (modifyCourse == null) {
            submit = new JButton("Create");
            inputName = new JTextField("Course Name", this.TEXT_LENGTH);
            submit.putClientProperty("id", "0");
        } else {
            submit = new JButton("Modify");
            JButton delete = new JButton("Delete");

            inputName = new JTextField(modifyCourse.getName(), this.TEXT_LENGTH);

            submit.putClientProperty("id", modifyCourse.getID());
            delete.putClientProperty("id", modifyCourse.getID());

            parent.add(delete);

            this.putConstraint(SpringLayout.EAST, delete, 0, SpringLayout.WEST, submit);
            this.putConstraint(SpringLayout.NORTH, delete, 28, SpringLayout.NORTH, inputName);

            delete.addActionListener(new CourseFormDeleteListener(observer));
        }

        parent.add(labelName);
        parent.add(inputName);
        parent.add(submit);

        this.putConstraint(SpringLayout.WEST, labelName, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelName, 25, SpringLayout.NORTH, parent);
        this.putConstraint(SpringLayout.WEST, inputName, 30, SpringLayout.EAST, labelName);
        this.putConstraint(SpringLayout.NORTH, inputName, -2, SpringLayout.NORTH, labelName);

        this.putConstraint(SpringLayout.EAST, submit, 0, SpringLayout.EAST, inputName);
        this.putConstraint(SpringLayout.NORTH, submit, 28, SpringLayout.NORTH, inputName);

        submit.putClientProperty("name", inputName.getText());

        inputName.getDocument().addDocumentListener(
                new InputFieldButtonListener("name", inputName, submit)
        );
        submit.addActionListener(new CourseFormCreateListener(observer));
    }

    public CourseForm(JPanel parent, CourseDatabaseInterface observer) {
        this(parent, null, observer);
    }
}
