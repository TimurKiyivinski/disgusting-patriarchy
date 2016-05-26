package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.InputFieldButtonListener;
import com.Kiyivinski.graphical.listeners.CourseFormCreateListener;
import com.Kiyivinski.graphical.listeners.interfaces.CourseDatabaseInterface;
import com.Kiyivinski.models.Course;

import javax.swing.*;

/**
 * The type Course form.
 */
public class CourseForm extends SpringLayout {
    private final int TEXT_LENGTH = 14;

    /**
     * Instantiates a new Course form.
     *
     * @param parent       the parent
     * @param modifyCourse the modify course
     * @param observer     the observer
     */
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

            inputName = new JTextField(modifyCourse.getName(), this.TEXT_LENGTH);

            submit.putClientProperty("id", modifyCourse.getID());
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

    /**
     * Instantiates a new Course form.
     *
     * @param parent   the parent
     * @param observer the observer
     */
    public CourseForm(JPanel parent, CourseDatabaseInterface observer) {
        this(parent, null, observer);
    }
}
