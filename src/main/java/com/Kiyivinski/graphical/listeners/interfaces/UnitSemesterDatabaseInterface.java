package com.Kiyivinski.graphical.listeners.interfaces;

public interface UnitSemesterDatabaseInterface {
    void createUnitSemester(String unit_id, String semester_id);
    void modifyUnitSemester(String id, String unit_id, String semester_id);
    void deleteUnitSemester(String id);
}
