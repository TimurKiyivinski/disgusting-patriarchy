package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * The type Semester.
 */
@Table("semesters")
public class Semester extends Model {
    /**
     * Create semester.
     *
     * @param name the name
     * @return the semester
     */
    public static Semester create(String name) {
        Semester course = new Semester();
        course.set("name", name);
        course.saveIt();
        return course;
    }

    /**
     * All list.
     *
     * @return the list
     */
    public static List<Semester> all() {
        return Semester.findAll();
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
    // endregion

    /**
     * Find semester.
     *
     * @param id the id
     * @return the semester
     */
// region QUERY
    public static Semester find(String id) {
        List<Semester> courses = Semester.where("id = '" + id + "'");
        return courses.get(0);
    }

    /**
     * Where name list.
     *
     * @param name the name
     * @return the list
     */
    public static List<Semester> whereName(String name) {
        return Student.where("name = '" + name + "'");
    }
    // endregion
}
