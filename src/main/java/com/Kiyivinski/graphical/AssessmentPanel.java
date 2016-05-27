package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterDatabaseInterface;
import com.Kiyivinski.models.Assessment;
import com.Kiyivinski.models.UnitSemester;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * The type Assessment panel.
 */
public class AssessmentPanel extends JPanel implements ConnectInterface, ModelTableInterface, UnitSemesterDatabaseInterface {
    private JScrollPane panelLeft;
    private JScrollPane panelMiddle;
    private JPanel panelRight;
    private String database;
    private String user;
    private String password;
    private UnitSemesterTable unitSemesterTable;
    private AssessmentTable assessmentTable;

    /**
     * Instantiates a new Assessment panel.
     */
    public AssessmentPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridLayout layout = new GridLayout(1, 3, 25, 25);
        this.setLayout(layout);

        this.assessmentTable = new AssessmentTable(this);
        this.unitSemesterTable = new UnitSemesterTable();

        this.panelLeft = new JScrollPane(unitSemesterTable);
        this.panelMiddle = new JScrollPane(assessmentTable);

        this.initializeLeftTable();

        this.add(panelLeft);
        this.add(panelMiddle);
    }

    /**
     * Initialize left table.
     */
    public void initializeLeftTable() {
        this.connect();
        DefaultTableModel model = (DefaultTableModel) this.unitSemesterTable.getModel();

        try {
            model.setRowCount(0);
        } catch (Exception e) {
            // Do not fail
        }

        List<UnitSemester> semesters = UnitSemester.all();
        for (UnitSemester s : semesters) {
            this.unitSemesterTable.addRow(s);
        }
        this.unitSemesterTable.setRowSelectionInterval(0, 0);
    }

    /**
     * Initialize middle table.
     *
     * @param unit_semester_id the unit semester id
     */
    public void initializeMiddleTable(String unit_semester_id) {
        this.connect();
        DefaultTableModel model = (DefaultTableModel) this.assessmentTable.getModel();

        try {
            model.setRowCount(0);
        } catch (Exception e) {
            // Do not fail
        }

        List<Assessment> semesters = Assessment.whereUnitSemester(unit_semester_id);
        for (Assessment s : semesters) {
            this.assessmentTable.addRow(s);
        }
        this.unitSemesterTable.setRowSelectionInterval(0, 0);
    }

    /**
     * Sets connect.
     *
     * @param database the database
     * @param user     the user
     * @param password the password
     */
    public void setConnect(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;
    }

    /**
     * Connect.
     */
    public void connect() {
        if (!Base.hasConnection()) {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
        }
    }

    /**
     * Update model form.
     *
     * @param id the id
     */
    public void updateModelForm(String id) {
        System.out.println("asd");
        this.connect();
        if (id.equals("0")) {
        } else {
            this.initializeMiddleTable(id);
        }
    }

    /**
     * Create unit semester.
     *
     * @param unit_id     the unit id
     * @param semester_id the semester id
     */
    public void createUnitSemester(String unit_id, String semester_id) {

    }

    /**
     * Delete unit semester.
     *
     * @param unit_id     the unit id
     * @param semester_id the semester id
     */
    public void deleteUnitSemester(String unit_id, String semester_id) {

    }
}
