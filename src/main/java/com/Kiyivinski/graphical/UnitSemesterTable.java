package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.UnitSemesterTableRowListener;
import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterTableInterface;
import com.Kiyivinski.models.UnitSemester;

public class UnitSemesterTable extends ModelTable {
    public UnitSemesterTable(UnitSemesterTableInterface observer) {
        super.addColumn("id");
        super.addColumn("Name");
        this.getSelectionModel().addListSelectionListener(new UnitSemesterTableRowListener(this, observer));
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
