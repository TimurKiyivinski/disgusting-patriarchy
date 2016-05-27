package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.graphical.listeners.interfaces.UnitSemesterDatabaseInterface;

import javax.swing.*;

/**
 * The type Assessment panel.
 */
public class AssessmentPanel extends JPanel implements ConnectInterface, ModelTableInterface, UnitSemesterDatabaseInterface {
    /**
     * Sets connect.
     *
     * @param database the database
     * @param user     the user
     * @param password the password
     */
    public void setConnect(String database, String user, String password) {

    }

    /**
     * Connect.
     */
    public void connect() {

    }

    /**
     * Update model form.
     *
     * @param id the id
     */
    public void updateModelForm(String id) {

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
