package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("students")
public class Student extends Model {

    public static Student create(String name, String identification, String course_id) {
        Student student = new Student();
        student.set("name", name);
        student.set("identification", identification);
        student.set("course_id", course_id);
        student.saveIt();
        return student;
    }

    public static List<Student> all() {
        return Student.findAll();
    }

    public String getName() {
        return this.get("name").toString();
    }

    public String getIdentification() {
        return this.get("identification").toString();
    }

    public void setName(String name) {
        this.set("name", name).saveIt();
    }

    public void setIdentification(String identification) {
        this.set("identification", identification).saveIt();
    }

    public void setCourse(String course_id) {
        this.set("course_id", course_id).saveIt();
    }

    public static Student find(String id) {
        List<Student> students = Student.where("id = '" + id + "'");
        return students.get(0);
    }

    public static List<Student> whereName(String name) {
        return Student.where("name = '" + name + "'");
    }

    public static List<Student> whereIdentification(String identification) {
        return Student.where("identification = '" + identification + "'");
    }

    public static List<Student> whereCourse(String course_id) {
        return Student.where("course_id = '" + course_id + "'");
    }
}
