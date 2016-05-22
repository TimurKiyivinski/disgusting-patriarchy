package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("semesters")
public class Semester extends Model {
    public static Semester create(String name) {
        Semester course = new Semester();
        course.set("name", name);
        course.saveIt();
        return course;
    }

    public static List<Semester> all() {
        return Semester.findAll();
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
    public static Semester find(String id) {
        List<Semester> courses = Semester.where("id = '" + id + "'");
        return courses.get(0);
    }

    public static List<Semester> whereName(String name) {
        return Student.where("name = '" + name + "'");
    }
    // endregion
}
