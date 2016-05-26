package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.SemesterDatabaseInterface;
import com.Kiyivinski.models.Semester;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SemesterPanel extends JPanel implements ConnectInterface, ModelTableInterface, SemesterDatabaseInterface {
    private JScrollPane panelLeft;
    private JPanel panelRight;
    private String database;
    private String user;
    private String password;
    private SemesterTable semesterTable;

    public SemesterPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        GridLayout layout = new GridLayout(1, 2, 25, 25);
        this.setLayout(layout);

        this.semesterTable = new SemesterTable(this);
        this.semesterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.panelLeft = new JScrollPane(semesterTable);
        this.panelRight = new JPanel();

        SpringLayout semesterForm = new SemesterForm(panelRight, this);
        panelRight.setLayout(semesterForm);

        this.initializeLeftTable();

        this.add(panelLeft);
        this.add(panelRight);
    }

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

    public void setConnect(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public void connect() {
        if (! Base.hasConnection()) {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
        }
    }

    public void updateModelForm(String id) {
        this.connect();
        panelRight.removeAll();
        SpringLayout rightPane;
        if (id.equals("0")) {
            rightPane = new SemesterForm(panelRight, this);
        } else {
            Semester semester = Semester.find(id);
            rightPane = new SemesterForm(panelRight, semester, this);
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
        }
    }
}
