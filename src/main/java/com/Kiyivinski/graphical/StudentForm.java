package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ComboBoxButtonListener;
import com.Kiyivinski.graphical.listeners.InputFieldButtonListener;
import com.Kiyivinski.graphical.listeners.StudentFormCreateListener;
import com.Kiyivinski.graphical.listeners.StudentFormDeleteListener;
import com.Kiyivinski.graphical.listeners.interfaces.StudentDatabaseInterface;
import com.Kiyivinski.models.Student;

import javax.swing.*;

/**
 * The type Student form.
 */
public class StudentForm extends SpringLayout {
    private final int TEXT_LENGTH = 14;

    /**
     * Instantiates a new Student form.
     *
     * @param parent        the parent
     * @param modifyStudent the modify student
     * @param observer      the observer
     */
    public StudentForm(JPanel parent, Student modifyStudent, StudentDatabaseInterface observer) {
        JLabel labelName = new JLabel("Name:");
        JTextField inputName;
        JLabel labelIdentification = new JLabel("Student ID:");
        JTextField inputIdentification;
        JLabel labelCourse = new JLabel("Course:");
        JComboBox inputCourse = new CourseComboBox();
        JButton submit;
        if (modifyStudent == null) {
            submit = new JButton("Create");
            inputName  = new JTextField("Student Name", this.TEXT_LENGTH);
            inputIdentification = new JTextField("000000", this.TEXT_LENGTH);
            submit.putClientProperty("id", "0");
        } else {
            submit = new JButton("Modify");
            JButton delete = new JButton("Delete");

            inputName  = new JTextField(modifyStudent.getName(), this.TEXT_LENGTH);
            inputIdentification = new JTextField(modifyStudent.getIdentification(), this.TEXT_LENGTH);
            inputCourse.setSelectedItem(modifyStudent.getCourse().getName());

            submit.putClientProperty("id", modifyStudent.getID());
            delete.putClientProperty("id", modifyStudent.getID());

            parent.add(delete);

            this.putConstraint(SpringLayout.EAST, delete, 0, SpringLayout.WEST, submit);
            this.putConstraint(SpringLayout.NORTH, delete, 28, SpringLayout.NORTH, inputCourse);

            delete.addActionListener(new StudentFormDeleteListener(observer));
        }

        parent.add(labelName);
        parent.add(inputName);
        parent.add(labelIdentification);
        parent.add(inputIdentification);
        parent.add(labelCourse);
        parent.add(inputCourse);
        parent.add(submit);

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

        this.putConstraint(SpringLayout.EAST, submit, 0, SpringLayout.EAST, inputCourse);
        this.putConstraint(SpringLayout.NORTH, submit, 28, SpringLayout.NORTH, inputCourse);

        submit.putClientProperty("name", inputName.getText());
        submit.putClientProperty("identification", inputIdentification.getText());
        submit.putClientProperty("course", inputCourse.getSelectedItem().toString());

        inputName.getDocument().addDocumentListener(
                new InputFieldButtonListener("name", inputName, submit)
        );
        inputIdentification.getDocument().addDocumentListener(
                new InputFieldButtonListener("identification", inputIdentification, submit)
        );
        inputCourse.addItemListener(new ComboBoxButtonListener("course", submit));
        submit.addActionListener(new StudentFormCreateListener(observer));
    }

    /**
     * Instantiates a new Student form.
     *
     * @param parent   the parent
     * @param observer the observer
     */
    StudentForm(JPanel parent, StudentDatabaseInterface observer) {
        this(parent, null, observer);
    }
}
