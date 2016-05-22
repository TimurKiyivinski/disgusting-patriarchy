package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("units")
public class Unit extends Model {
    public static Unit create(String name, String code) {
        Unit course = new Unit();
        course.set("name", name);
        course.set("code", code);
        course.saveIt();
        return course;
    }

    public static List<Unit> all() {
        return Unit.findAll();
    }

    public String getName() {
        return this.get("name").toString();
    }

    public String getCode() {
        return this.get("code").toString();
    }

    public void setName(String name) {
        this.set("name", name).saveIt();
    }

    public void setCode(String code) {
        this.set("code", code).saveIt();
    }

    public static Unit find(String id) {
        List<Unit> courses = Unit.where("id = '" + id + "'");
        return courses.get(0);
    }

    public static List<Unit> whereName(String name) {
        return Student.where("name = '" + name + "'");
    }
}
