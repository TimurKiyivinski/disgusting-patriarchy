package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.CourseInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * The type Student.
 */
@Table("students")
public class Student extends Model implements CourseInterface {
    /**
     * Create student.
     *
     * @param name           the name
     * @param identification the identification
     * @param course_id      the course id
     * @return the student
     */
    public static Student create(String name, String identification, String course_id) {
        Student student = new Student();
        student.set("name", name);
        student.set("identification", identification);
        student.set("course_id", course_id);
        student.saveIt();
        return student;
    }

    /**
     * All list.
     *
     * @return the list
     */
    public static List<Student> all() {
        return Student.findAll();
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
     * Gets identification.
     *
     * @return the identification
     */
    public String getIdentification() {
        return this.get("identification").toString();
    }

    public String getCourseID() {
        return this.get("course_id").toString();
    }

    public Course getCourse() {
        return Course.find(this.getCourseID());
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
     * Sets identification.
     *
     * @param identification the identification
     */
    public void setIdentification(String identification) {
        this.set("identification", identification).saveIt();
    }

    /**
     * Sets course.
     *
     * @param course_id the course id
     */
    public void setCourse(String course_id) {
        this.set("course_id", course_id).saveIt();
    }
    // endregion

    /**
     * Find student.
     *
     * @param id the id
     * @return the student
     */
// region QUERY
    public static Student find(String id) {
        List<Student> students = Student.where("id = '" + id + "'");
        return students.get(0);
    }

    /**
     * Where name list.
     *
     * @param name the name
     * @return the list
     */
    public static List<Student> whereName(String name) {
        return Student.where("name = '" + name + "'");
    }

    /**
     * Where identification list.
     *
     * @param identification the identification
     * @return the list
     */
    public static List<Student> whereIdentification(String identification) {
        return Student.where("identification = '" + identification + "'");
    }

    /**
     * Where course list.
     *
     * @param course_id the course id
     * @return the list
     */
    public static List<Student> whereCourse(String course_id) {
        return Student.where("course_id = '" + course_id + "'");
    }
    // endregion
}
