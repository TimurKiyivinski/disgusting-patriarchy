package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ComboBoxButtonListener;
import com.Kiyivinski.graphical.listeners.InputFieldButtonListener;
import com.Kiyivinski.graphical.listeners.SemesterFormCreateListener;
import com.Kiyivinski.graphical.listeners.SemesterFormDeleteListener;
import com.Kiyivinski.graphical.listeners.interfaces.SemesterDatabaseInterface;
import com.Kiyivinski.models.Semester;

import javax.swing.*;

public class SemesterForm extends SpringLayout {
    private final int TEXT_LENGTH = 10;

    public SemesterForm(JPanel parent, Semester modifySemester, SemesterDatabaseInterface observer) {
        JLabel labelName = new JLabel("Name:");
        JTextField inputName;
        JButton submit;
        if (modifySemester == null) {
            submit = new JButton("Create");
            inputName = new JTextField("Semester Name", this.TEXT_LENGTH);
            submit.putClientProperty("id", "0");
        } else {
            submit = new JButton("Modify");
            JButton delete = new JButton("Delete");

            // Unit buttons
            JComboBox inputUnit = new UnitComboBox();
            JButton addUnit = new JButton("Add Unit");
            JButton deleteUnit = new JButton("Remove Unit");

            inputName = new JTextField(modifySemester.getName(), this.TEXT_LENGTH);

            submit.putClientProperty("id", modifySemester.getID());
            delete.putClientProperty("id", modifySemester.getID());

            parent.add(delete);
            parent.add(inputUnit);
            parent.add(addUnit);
            parent.add(deleteUnit);

            this.putConstraint(SpringLayout.EAST, delete, 0, SpringLayout.WEST, submit);
            this.putConstraint(SpringLayout.NORTH, delete, 28, SpringLayout.NORTH, inputName);

            this.putConstraint(SpringLayout.WEST, inputUnit, 0, SpringLayout.WEST, parent);
            this.putConstraint(SpringLayout.NORTH, inputUnit, 52, SpringLayout.NORTH, submit);

            this.putConstraint(SpringLayout.WEST, addUnit, 0, SpringLayout.WEST, inputUnit);
            this.putConstraint(SpringLayout.NORTH, addUnit, 28, SpringLayout.NORTH, inputUnit);

            this.putConstraint(SpringLayout.WEST, deleteUnit, 0, SpringLayout.EAST, addUnit);
            this.putConstraint(SpringLayout.NORTH, deleteUnit, 28, SpringLayout.NORTH, inputUnit);

            delete.addActionListener(new SemesterFormDeleteListener(observer));

            inputUnit.addItemListener(new ComboBoxButtonListener("unit_id", addUnit));
            inputUnit.addItemListener(new ComboBoxButtonListener("unit_id", deleteUnit));
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
        submit.addActionListener(new SemesterFormCreateListener(observer));
    }

    public SemesterForm(JPanel parent, SemesterDatabaseInterface observer) {
        this(parent, null, observer);
    }
}
