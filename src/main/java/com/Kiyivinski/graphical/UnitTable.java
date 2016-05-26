package com.Kiyivinski.graphical;

import com.Kiyivinski.models.Unit;

import javax.swing.table.DefaultTableModel;

public class UnitTable extends ModelTable {
    private DefaultTableModel model;

    public UnitTable() {
        super.addColumn("id");
        super.addColumn("Name");
        super.addColumn("Code");
    }

    public void addCreate() {
        Object [] row = new Object[]{
                "0", "Create Unit", "000"
        };
        super.addRow(row);
    }

    public void addRow(Unit unit) {
        Object [] row = new Object[]{
                unit.getID(),
                unit.getName(),
                unit.getCode()
        };
        super.addRow(row);
    }
}
