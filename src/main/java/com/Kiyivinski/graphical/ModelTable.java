package com.Kiyivinski.graphical;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class ModelTable extends JTable {
    private DefaultTableModel model;

    public ModelTable() {
        this.model = new DefaultTableModel();
        this.setModel(this.model);
    }

    protected void addColumn(String column) {
        this.model.addColumn(column);
    }

    protected void addRow(Object [] row) {
        this.model.addRow(row);
    }

    public abstract void addCreate();
}
