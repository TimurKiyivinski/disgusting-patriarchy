package com.Kiyivinski.graphical.listeners.interfaces;

public interface SemesterDatabaseInterface {
    void createSemester(String name);
    void modifySemester(String id, String name);
    void deleteSemester(String id);
}
