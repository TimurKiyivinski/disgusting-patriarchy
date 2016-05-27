package com.Kiyivinski.graphical;

import com.Kiyivinski.models.UnitSemester;

/**
 * The type Unit semester table.
 */
public class UnitSemesterTable extends ModelTable {
    /**
     * Instantiates a new Unit semester table.
     */
    public UnitSemesterTable() {
        super.addColumn("id");
        super.addColumn("Name");
    }

    public void addCreate() {
        //
    }

    /**
     * Add row.
     *
     * @param unit the unit
     */
    public void addRow(UnitSemester unit) {
        Object[] row = new Object[]{
                unit.getID(),
                unit.toString()
        };
        super.addRow(row);
    }
}
