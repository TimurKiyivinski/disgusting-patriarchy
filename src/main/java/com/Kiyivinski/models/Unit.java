package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * The type Unit.
 */
@Table("units")
public class Unit extends Model {
    /**
     * Create unit.
     *
     * @param name the name
     * @param code the code
     * @return the unit
     */
    public static Unit create(String name, String code) {
        Unit course = new Unit();
        course.set("name", name);
        course.set("code", code);
        course.saveIt();
        return course;
    }

    /**
     * All list.
     *
     * @return the list
     */
    public static List<Unit> all() {
        return Unit.findAll();
    }

    public String toString() {
        return this.getName();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
// region GETTER
    public String getID() {
        return this.get("id").toString();
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.get("name").toString();
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return this.get("code").toString();
    }
    // endregion

    /**
     * Sets name.
     *
     * @param name the name
     */
// region SETTER
    public void setName(String name) {
        this.set("name", name).saveIt();
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.set("code", code).saveIt();
    }
    // endregion

    /**
     * Find unit.
     *
     * @param id the id
     * @return the unit
     */
// region SETTER
    public static Unit find(String id) {
        List<Unit> courses = Unit.where("id = '" + id + "'");
        return courses.get(0);
    }

    /**
     * Where name list.
     *
     * @param name the name
     * @return the list
     */
    public static List<Unit> whereName(String name) {
        return Student.where("name = '" + name + "'");
    }

    /**
     * Where code list.
     *
     * @param code the code
     * @return the list
     */
    public static List<Unit> whereCode(String code) {
        return Student.where("code = '" + code + "'");
    }
    // endregion
}
