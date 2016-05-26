package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ComboBoxButtonListener;
import com.Kiyivinski.graphical.listeners.InputFieldButtonListener;
import com.Kiyivinski.graphical.listeners.UnitSemesterFormCreateListener;
import com.Kiyivinski.graphical.listeners.UnitSemesterFormDeleteListener;
import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterDatabaseInterface;
import com.Kiyivinski.models.UnitSemester;

import javax.swing.*;

public class UnitSemesterForm extends SpringLayout {
    public UnitSemesterForm(JPanel parent, UnitSemester modifyUnitSemester, UnitSemesterDatabaseInterface observer) {
        JLabel labelUnit = new JLabel("Unit:");
        JComboBox inputUnit = new UnitComboBox();
        JButton submit;
        if (modifyUnitSemester == null) {
            submit = new JButton("Create");
            submit.putClientProperty("id", "0");
        } else {
            submit = new JButton("Modify");
            JButton delete = new JButton("Delete");

            inputUnit.setSelectedItem(modifyUnitSemester.getUnit().getName());

            submit.putClientProperty("id", modifyUnitSemester.getID());
            delete.putClientProperty("id", modifyUnitSemester.getID());

            parent.add(delete);

            this.putConstraint(SpringLayout.EAST, delete, 0, SpringLayout.WEST, submit);
            this.putConstraint(SpringLayout.NORTH, delete, 28, SpringLayout.NORTH, inputUnit);

            delete.addActionListener(new UnitSemesterFormDeleteListener(observer));
        }

        parent.add(labelUnit);
        parent.add(inputUnit);
        parent.add(submit);

        this.putConstraint(SpringLayout.WEST, labelUnit, 5, SpringLayout.WEST, parent);
        this.putConstraint(SpringLayout.NORTH, labelUnit, 25, SpringLayout.NORTH, parent);
        this.putConstraint(SpringLayout.WEST, inputUnit, 30, SpringLayout.EAST, labelUnit);
        this.putConstraint(SpringLayout.NORTH, inputUnit, -2, SpringLayout.NORTH, labelUnit);

        this.putConstraint(SpringLayout.EAST, submit, 0, SpringLayout.EAST, inputUnit);
        this.putConstraint(SpringLayout.NORTH, submit, 28, SpringLayout.NORTH, inputUnit);

        //submit.putClientProperty("name", inputName.getText());
        //submit.putClientProperty("identification", inputIdentification.getText());
        //submit.putClientProperty("unit", inputUnit.getSelectedItem().toString());

        //inputName.getDocument().addDocumentListener(
        //        new InputFieldButtonListener("name", inputName, submit)
        //);
        //inputIdentification.getDocument().addDocumentListener(
        //        new InputFieldButtonListener("identification", inputIdentification, submit)
        //);
        //inputUnit.addItemListener(new ComboBoxButtonListener("unit", submit));
        //submit.addActionListener(new UnitSemesterFormCreateListener(observer));
    }

    UnitSemesterForm(JPanel parent, UnitSemesterDatabaseInterface observer) {
        this(parent, null, observer);
    }
}
