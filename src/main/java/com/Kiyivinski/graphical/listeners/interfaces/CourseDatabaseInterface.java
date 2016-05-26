package com.Kiyivinski.graphical.listeners.interfaces;

public interface CourseDatabaseInterface {
    void createCourse(String name);
    void modifyCourse(String id, String name);
    void deleteCourse(String id);
}
