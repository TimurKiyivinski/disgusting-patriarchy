package com.Kiyivinski.graphical.listeners.interfaces;

/**
 * The interface Unit database interface.
 */
public interface UnitDatabaseInterface {
    /**
     * Create unit.
     *
     * @param name the name
     * @param code the code
     */
    void createUnit(String name, String code);

    /**
     * Modify unit.
     *
     * @param id   the id
     * @param name the name
     * @param code the code
     */
    void modifyUnit(String id, String name, String code);

    /**
     * Delete unit.
     *
     * @param id the id
     */
    void deleteUnit(String id);
}
