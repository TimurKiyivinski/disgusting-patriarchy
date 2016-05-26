package com.Kiyivinski.graphical.listeners.interfaces;

/**
 * The interface Course database interface.
 */
public interface CourseDatabaseInterface {
    /**
     * Create course.
     *
     * @param name the name
     */
    void createCourse(String name);

    /**
     * Modify course.
     *
     * @param id   the id
     * @param name the name
     */
    void modifyCourse(String id, String name);
}
