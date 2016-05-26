package com.Kiyivinski.graphical.listeners.interfaces;

/**
 * The interface Student database interface.
 */
public interface StudentDatabaseInterface {
    /**
     * Create student.
     *
     * @param name           the name
     * @param identification the identification
     * @param course         the course
     */
    void createStudent(String name, String identification, String course);

    /**
     * Modify student.
     *
     * @param id             the id
     * @param name           the name
     * @param identification the identification
     * @param course         the course
     */
    void modifyStudent(String id, String name, String identification, String course);

    /**
     * Delete student.
     *
     * @param id the id
     */
    void deleteStudent(String id);
}
