package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.UnitDatabaseInterface;
import com.Kiyivinski.models.Unit;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * The type Unit panel.
 */
public class UnitPanel extends JPanel implements ConnectInterface, ModelTableInterface, UnitDatabaseInterface {
    private JScrollPane panelLeft;
    private JPanel panelRight;
    private String database;
    private String user;
    private String password;
    private UnitTable unitTable;

    /**
     * Instantiates a new Unit panel.
     */
    public UnitPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridLayout layout = new GridLayout(1, 2, 25, 25);
        this.setLayout(layout);

        this.unitTable = new UnitTable(this);

        this.panelLeft = new JScrollPane(unitTable);
        this.panelRight = new JPanel();

        SpringLayout unitForm = new UnitForm(panelRight, this);
        panelRight.setLayout(unitForm);

        this.initializeLeftTable();

        this.add(panelLeft);
        this.add(panelRight);
    }

    /**
     * Initialize left table.
     */
    public void initializeLeftTable() {
        this.connect();
        DefaultTableModel model = (DefaultTableModel) this.unitTable.getModel();

        try {
            model.setRowCount(0);
        } catch (Exception e) {
            // Do not fail
        }

        this.unitTable.addCreate();
        List<Unit> units = Unit.all();
        for (Unit u : units) {
            this.unitTable.addRow(u);
        }
        this.unitTable.setRowSelectionInterval(0, 0);
    }

    public void setConnect(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public void connect() {
        if (!Base.hasConnection()) {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
        }
    }

    public void updateModelForm(String id) {
        this.connect();
        panelRight.removeAll();
        SpringLayout rightPane;
        if (id.equals("0")) {
            rightPane = new UnitForm(panelRight, this);
        } else {
            Unit unit = Unit.find(id);
            rightPane = new UnitForm(panelRight, unit, this);
        }
        panelRight.setLayout(rightPane);
        panelRight.revalidate();
    }

    public void createUnit(String name, String code) {
        this.connect();
        try {
            Unit unit = Unit.create(name, code);
            unitTable.addRow(unit);
        } catch (Exception e) {
            System.out.println("Fail");
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public void modifyUnit(String id, String name, String code) {
        this.connect();
        Unit modifyUnit = Unit.find(id);
        try {
            modifyUnit.setName(name);
            modifyUnit.setCode(code);
            this.initializeLeftTable();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public void deleteUnit(String id) {
        this.connect();
        Unit deleteUnit = Unit.find(id);
        try {
            deleteUnit.delete();
            this.initializeLeftTable();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }
}
