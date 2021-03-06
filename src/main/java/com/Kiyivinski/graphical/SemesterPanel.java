package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.SemesterDatabaseInterface;
import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterDatabaseInterface;
import com.Kiyivinski.models.Semester;
import com.Kiyivinski.models.UnitSemester;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * The type Semester panel.
 */
public class SemesterPanel extends JPanel implements ConnectInterface, ModelTableInterface, SemesterDatabaseInterface, UnitSemesterDatabaseInterface {
    private JScrollPane panelLeft;
    private JScrollPane panelMiddle;
    private JPanel panelRight;
    private String database;
    private String user;
    private String password;
    private SemesterTable semesterTable;
    private UnitSemesterUnitTable unitSemesterUnitTable;

    /**
     * Instantiates a new Semester panel.
     */
    public SemesterPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridLayout layout = new GridLayout(1, 3, 25, 25);
        this.setLayout(layout);

        this.semesterTable = new SemesterTable(this);
        this.unitSemesterUnitTable = new UnitSemesterUnitTable();

        this.panelLeft = new JScrollPane(semesterTable);
        this.panelMiddle = new JScrollPane(unitSemesterUnitTable);
        this.panelRight = new JPanel();

        SpringLayout semesterForm = new SemesterForm(panelRight, this, this);
        panelRight.setLayout(semesterForm);

        this.initializeLeftTable();

        this.add(panelLeft);
        this.add(panelMiddle);
        this.add(panelRight);
    }

    /**
     * Initialize left table.
     */
    public void initializeLeftTable() {
        this.connect();
        DefaultTableModel model = (DefaultTableModel) this.semesterTable.getModel();

        try {
            model.setRowCount(0);
        } catch (Exception e) {
            // Do not fail
        }

        this.semesterTable.addCreate();
        List<Semester> semesters = Semester.all();
        for (Semester s : semesters) {
            this.semesterTable.addRow(s);
        }
        this.semesterTable.setRowSelectionInterval(0, 0);
    }

    /**
     * Initialize middle table.
     *
     * @param semester_id the semester id
     */
    public void initializeMiddleTable(String semester_id) {
        this.connect();
        DefaultTableModel model = (DefaultTableModel) this.unitSemesterUnitTable.getModel();

        try {
            model.setRowCount(0);
        } catch (Exception e) {
            // Do not fail
        }

        this.unitSemesterUnitTable.addCreate();
        List<UnitSemester> unitSemesters = UnitSemester.whereSemester(semester_id);
        for (UnitSemester s : unitSemesters) {
            this.unitSemesterUnitTable.addRow(s);
        }
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
            rightPane = new SemesterForm(panelRight, this, this);
        } else {
            Semester semester = Semester.find(id);
            rightPane = new SemesterForm(panelRight, semester, this, this);
            this.initializeMiddleTable(id);
        }
        panelRight.setLayout(rightPane);
        panelRight.revalidate();
    }

    public void createSemester(String name) {
        this.connect();
        try {
            Semester semester = Semester.create(name);
            semesterTable.addRow(semester);
        } catch (Exception e) {
            System.out.println("Fail");
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public void modifySemester(String id, String name) {
        this.connect();
        Semester modifySemester = Semester.find(id);
        try {
            modifySemester.setName(name);
            this.initializeLeftTable();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public void deleteSemester(String id) {
        this.connect();
        Semester deleteSemester = Semester.find(id);
        try {
            deleteSemester.delete();
            this.initializeLeftTable();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public void createUnitSemester(String unit_id, String semester_id) {
        this.connect();
        try {
            UnitSemester unitSemester = UnitSemester.create(unit_id, semester_id);
            unitSemesterUnitTable.addRow(unitSemester);
        } catch (Exception e) {
            System.out.println("Fail");
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }

    public void deleteUnitSemester(String unit_id, String semester_id) {
        this.connect();
        List<UnitSemester> deleteUnitSemester = UnitSemester.whereSemester(semester_id);
        try {
            for (UnitSemester u : deleteUnitSemester) {
                if (u.getUnitID().equals(unit_id)) {
                    u.delete();
                }
            }
            this.semesterTable.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Invalid Input");
        }
    }
}
