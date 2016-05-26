package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * The type Course.
 */
@Table("courses")
public class Course extends Model {
    /**
     * Create course.
     *
     * @param name the name
     * @return the course
     */
    public static Course create(String name) {
        Course course = new Course();
        course.set("name", name);
        course.saveIt();
        return course;
    }

    /**
     * All list.
     *
     * @return the list
     */
    public static List<Course> all() {
        return Course.findAll();
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
     * Find course.
     *
     * @param id the id
     * @return the course
     */
// region QUERY
    public static Course find(String id) {
        List<Course> courses = Course.where("id = '" + id + "'");
        return courses.get(0);
    }

    /**
     * Where name list.
     *
     * @param name the name
     * @return the list
     */
    public static List<Course> whereName(String name) {
        return Course.where("name = '" + name + "'");
    }
    // endregion
}
