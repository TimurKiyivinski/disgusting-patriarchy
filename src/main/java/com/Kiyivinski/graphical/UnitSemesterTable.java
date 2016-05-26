package com.Kiyivinski.graphical;

import com.Kiyivinski.models.UnitSemester;

public class UnitSemesterTable extends ModelTable {
    public UnitSemesterTable() {
        super.addColumn("id");
        super.addColumn("Name");
    }

    public void addCreate() {
        //
    }

    public void addRow(UnitSemester unit) {
        Object [] row = new Object[]{
                unit.getUnitID(),
                unit.getUnit().getName(),
        };
        super.addRow(row);
    }
}
