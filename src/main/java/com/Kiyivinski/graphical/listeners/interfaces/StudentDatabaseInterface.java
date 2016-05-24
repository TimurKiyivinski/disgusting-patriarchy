package com.Kiyivinski.graphical.listeners.interfaces;

import com.Kiyivinski.models.Student;

public interface StudentDatabaseInterface {
    void createStudent(String name, String identification, String course);
    void modifyStudent(String id, String name, String identification, String course);
    void deleteStudent(String id);
}
