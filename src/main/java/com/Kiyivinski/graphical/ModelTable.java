package com.Kiyivinski.graphical;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * The type Model table.
 */
public abstract class ModelTable extends JTable {
    private DefaultTableModel model;

    /**
     * Instantiates a new Model table.
     */
    public ModelTable() {
        this.model = new DefaultTableModel();
        this.setModel(this.model);
    }

    /**
     * Add column.
     *
     * @param column the column
     */
    protected void addColumn(String column) {
        this.model.addColumn(column);
    }

    /**
     * Add row.
     *
     * @param row the row
     */
    protected void addRow(Object[] row) {
        this.model.addRow(row);
    }

    /**
     * Add create.
     */
    public abstract void addCreate();
}
