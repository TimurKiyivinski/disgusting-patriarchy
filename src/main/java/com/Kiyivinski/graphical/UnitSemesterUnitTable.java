package com.Kiyivinski.graphical;

import com.Kiyivinski.models.UnitSemester;

/**
 * The type Unit semester table.
 */
public class UnitSemesterUnitTable extends ModelTable {
    /**
     * Instantiates a new Unit semester table.
     */
    public UnitSemesterUnitTable() {
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
        Object [] row = new Object[]{
                unit.getUnitID(),
                unit.getUnit().getName(),
        };
        super.addRow(row);
    }
}
