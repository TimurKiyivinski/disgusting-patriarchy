package com.Kiyivinski.graphical;

import com.Kiyivinski.models.UnitSemester;

public class UnitSemesterTable extends ModelTable {
    public UnitSemesterTable() {
        super.addColumn("id");
        super.addColumn("Name");
        //this.getSelectionModel().addListSelectionListener(new ModelTableRowListener(this, observer));
    }

    public void addCreate() {
        Object [] row = new Object[]{
                "0", "Add Unit"
        };
        super.addRow(row);
    }

    public void addRow(UnitSemester unit) {
        Object [] row = new Object[]{
                unit.getID(),
                unit.getUnit().getName(),
        };
        super.addRow(row);
    }
}