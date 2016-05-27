package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ModelTableRowListener;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.models.Assessment;

/**
 * The type Unit semester table.
 */
public class AssessmentTable extends ModelTable {
    /**
     * Instantiates a new Unit semester table.
     *
     * @param observer the observer
     */
    public AssessmentTable(ModelTableInterface observer) {
        super.addColumn("id");
        super.addColumn("Name");
        super.addColumn("Mark");
        this.getSelectionModel().addListSelectionListener(new ModelTableRowListener(this, observer));
    }

    public void addCreate() {
        //
    }

    /**
     * Add row.
     *
     * @param assessment the assessment
     */
    public void addRow(Assessment assessment) {
        Object[] row = new Object[]{
                assessment.getID(),
                assessment.getName(),
                assessment.getMark()
        };
        super.addRow(row);
    }
}
