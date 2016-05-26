package com.Kiyivinski.graphical.listeners.interfaces;

public interface UnitDatabaseInterface {
    void createUnit(String name, String code);
    void modifyUnit(String id, String name, String code);
    void deleteUnit(String id);
}
