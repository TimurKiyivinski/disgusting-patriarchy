package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.InputFieldButtonListener;
import com.Kiyivinski.graphical.listeners.UnitFormCreateListener;
import com.Kiyivinski.graphical.listeners.UnitFormDeleteListener;
import com.Kiyivinski.graphical.listeners.interfaces.UnitDatabaseInterface;
import com.Kiyivinski.models.Unit;

import javax.swing.*;

public class UnitForm extends SpringLayout {
    private final int TEXT_LENGTH = 14;

    public UnitForm(JPanel parent, Unit modifyUnit, UnitDatabaseInterface observer) {
        JLabel labelName = new JLabel("Name:");
        JTextField inputName;
        JLabel labelCode = new JLabel("Code:");
        JTextField inputCode;
        JButton submit;
        if (modifyUnit == null) {
            submit = new JButton("Create");
            inputName  = new JTextField("Unit Name", this.TEXT_LENGTH);
            inputCode = new JTextField("000", this.TEXT_LENGTH);
            submit.putClientProperty("id", "0");
        } else {
            submit = new JButton("Modify");
            JButton delete = new JButton("Delete");

            inputName  = new JTextField(modifyUnit.getName(), this.TEXT_LENGTH);
            inputCode = new JTextField(modifyUnit.getCode(), this.TEXT_LENGTH);

            submit.putClientProperty("id", modifyUnit.getID());
            delete.putClientProperty("id", modifyUnit.getID());

            parent.add(delete);

            this.putConstraint(SpringLayout.EAST, delete, 0, SpringLayout.WEST, submit);
            this.putConstraint(SpringLayout.NORTH, delete, 28, SpringLayout.NORTH, inputCode);

            delete.addActionListener(new UnitFormDeleteListener(observer));
        }

        parent.add(labelName);
        parent.add(inputName);
        parent.add(labelCode);
        parent.add(inputCode);
        parent.add(submit);

        this.putConstraint(SpringLayout.WEST, labelName, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelName, 25, SpringLayout.NORTH, parent);
        this.putConstraint(SpringLayout.WEST, inputName, 30, SpringLayout.EAST, labelName);
        this.putConstraint(SpringLayout.NORTH, inputName, -2, SpringLayout.NORTH, labelName);

        this.putConstraint(SpringLayout.WEST , labelCode, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelCode, 30, SpringLayout.NORTH, labelName);
        this.putConstraint(SpringLayout.WEST , inputCode, 0, SpringLayout.WEST, inputName);
        this.putConstraint(SpringLayout.NORTH, inputCode, 28, SpringLayout.NORTH, inputName);

        this.putConstraint(SpringLayout.EAST, submit, 0, SpringLayout.EAST, inputCode);
        this.putConstraint(SpringLayout.NORTH, submit, 28, SpringLayout.NORTH, inputCode);

        submit.putClientProperty("name", inputName.getText());
        submit.putClientProperty("code", inputCode.getText());

        inputName.getDocument().addDocumentListener(
                new InputFieldButtonListener("name", inputName, submit)
        );
        inputCode.getDocument().addDocumentListener(
                new InputFieldButtonListener("code", inputCode, submit)
        );
        submit.addActionListener(new UnitFormCreateListener(observer));
    }

    public UnitForm(JPanel parent, UnitDatabaseInterface observer) {
        this(parent, null, observer);
    }
}
