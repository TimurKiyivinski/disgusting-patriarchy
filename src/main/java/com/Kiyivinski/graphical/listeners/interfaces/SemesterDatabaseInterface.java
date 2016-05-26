package com.Kiyivinski.graphical.listeners.interfaces;

/**
 * The interface Semester database interface.
 */
public interface SemesterDatabaseInterface {
    /**
     * Create semester.
     *
     * @param name the name
     */
    void createSemester(String name);

    /**
     * Modify semester.
     *
     * @param id   the id
     * @param name the name
     */
    void modifySemester(String id, String name);

    /**
     * Delete semester.
     *
     * @param id the id
     */
    void deleteSemester(String id);
}
