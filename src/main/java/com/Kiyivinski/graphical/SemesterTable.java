package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ModelTableRowListener;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.models.Semester;

/**
 * The type Semester table.
 */
public class SemesterTable extends ModelTable {
    /**
     * Instantiates a new Semester table.
     *
     * @param observer the observer
     */
    public SemesterTable(ModelTableInterface observer) {
        super.addColumn("id");
        super.addColumn("Name");
        this.getSelectionModel().addListSelectionListener(new ModelTableRowListener(this, observer));
    }

    public void addCreate() {
        Object[] row = new Object[]{
                "0", "Create Semester"
        };
        super.addRow(row);
    }

    /**
     * Add row.
     *
     * @param semester the semester
     */
    public void addRow(Semester semester) {
        Object[] row = new Object[]{
                semester.getID(),
                semester.getName()
        };
        super.addRow(row);
    }
}
