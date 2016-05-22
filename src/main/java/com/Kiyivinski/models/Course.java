package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("courses")
public class Course extends Model {
    public static Course create(String name) {
        Course course = new Course();
        course.set("name", name);
        course.saveIt();
        return course;
    }

    public static List<Course> all() {
        return Course.findAll();
    }

    // region GETTER
    public String getName() {
        return this.get("name").toString();
    }
    // endregion

    // region SETTER
    public void setName(String name) {
        this.set("name", name).saveIt();
    }
    // endregion

    // region QUERY
    public static Course find(String id) {
        List<Course> courses = Course.where("id = '" + id + "'");
        return courses.get(0);
    }

    public static List<Course> whereName(String name) {
        return Student.where("name = '" + name + "'");
    }
    // endregion
}
