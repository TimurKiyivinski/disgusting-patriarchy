package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("types")
public class Type extends Model {
    public static Type create(String name) {
        Type course = new Type();
        course.set("name", name);
        course.saveIt();
        return course;
    }

    public static List<Type> all() {
        return Type.findAll();
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
    public static Type find(String id) {
        List<Type> courses = Type.where("id = '" + id + "'");
        return courses.get(0);
    }

    public static List<Type> whereName(String name) {
        return Student.where("name = '" + name + "'");
    }
    // endregion
}
