package com.Kiyivinski.graphical.listeners.interfaces;

/**
 * The interface Unit semester database interface.
 */
public interface UnitSemesterDatabaseInterface {
    /**
     * Create unit semester.
     *
     * @param unit_id     the unit id
     * @param semester_id the semester id
     */
    void createUnitSemester(String unit_id, String semester_id);

    /**
     * Delete unit semester.
     *
     * @param unit_id     the unit id
     * @param semester_id the semester id
     */
    void deleteUnitSemester(String unit_id, String semester_id);
}
