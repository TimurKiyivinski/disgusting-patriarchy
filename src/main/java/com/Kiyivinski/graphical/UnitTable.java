package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ModelTableRowListener;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.models.Unit;

/**
 * The type Unit table.
 */
public class UnitTable extends ModelTable {
    /**
     * Instantiates a new Unit table.
     *
     * @param observer the observer
     */
    public UnitTable(ModelTableInterface observer) {
        super.addColumn("id");
        super.addColumn("Name");
        super.addColumn("Code");
        this.getSelectionModel().addListSelectionListener(new ModelTableRowListener(this, observer));
    }

    public void addCreate() {
        Object[] row = new Object[]{
                "0", "Create Unit", "000"
        };
        super.addRow(row);
    }

    /**
     * Add row.
     *
     * @param unit the unit
     */
    public void addRow(Unit unit) {
        Object[] row = new Object[]{
                unit.getID(),
                unit.getName(),
                unit.getCode()
        };
        super.addRow(row);
    }
}
