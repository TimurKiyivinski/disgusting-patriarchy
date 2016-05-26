package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ModelTableRowListener;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.models.Student;

/**
 * The type Student table.
 */
public class StudentTable extends ModelTable {
    /**
     * Instantiates a new Student table.
     *
     * @param observer the observer
     */
    public StudentTable(ModelTableInterface observer) {
        super.addColumn("id");
        super.addColumn("Name");
        super.addColumn("Identification");
        super.addColumn("Course");
        this.getSelectionModel().addListSelectionListener(new ModelTableRowListener(this, observer));
    }

    public void addCreate() {
        Object [] row = new Object[]{
                "0", "Create Student", "000000", ""
        };
        super.addRow(row);
    }

    /**
     * Add row.
     *
     * @param student the student
     */
    public void addRow(Student student) {
        Object [] row = new Object[]{
                student.getID(),
                student.getName(),
                student.getIdentification(),
                student.getCourse().getName()
        };
        super.addRow(row);
    }
}
