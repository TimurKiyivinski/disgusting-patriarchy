package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.SemesterInterface;
import com.Kiyivinski.interfaces.StudentInterface;
import com.Kiyivinski.interfaces.UnitInterface;
import com.Kiyivinski.interfaces.UnitSemesterInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * The type Student unit.
 */
@Table("student_units")
public class StudentUnit extends Model implements StudentInterface, UnitSemesterInterface, UnitInterface, SemesterInterface {
    /**
     * Create student unit.
     *
     * @param student_id       the student id
     * @param unit_semester_id the unit semester id
     * @return the student unit
     */
    public static StudentUnit create(String student_id, String unit_semester_id) {
        StudentUnit studentUnit = new StudentUnit();
        studentUnit.set("student_id", student_id);
        studentUnit.set("unit_semester_id", unit_semester_id);
        studentUnit.saveIt();
        return studentUnit;
    }

    /**
     * All list.
     *
     * @return the list
     */
    public static List<StudentUnit> all() {
        return StudentUnit.findAll();
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

    public String getStudentID() {
        return this.get("student_id").toString();
    }

    public Student getStudent() {
        return Student.find(this.getStudentID());
    }

    public String getUnitSemesterID() {
        return this.get("unit_semester_id").toString();
    }

    public UnitSemester getUnitSemester() {
        return UnitSemester.find(this.getUnitSemesterID());
    }

    public String getUnitID() {
        return this.getUnitSemester().getUnitID();
    }

    public Unit getUnit() {
        return this.getUnitSemester().getUnit();
    }

    public String getSemesterID() {
        return this.getUnitSemester().getSemesterID();
    }

    public Semester getSemester() {
        return this.getUnitSemester().getSemester();
    }
    // endregion

    /**
     * Sets unit semester.
     *
     * @param unit_semester_id the unit semester id
     */
// region SETTER
    public void setUnitSemester(String unit_semester_id) {
        this.set("unit_semester_id", unit_semester_id).saveIt();
    }

    /**
     * Sets student.
     *
     * @param student_id the student id
     */
    public void setStudent(String student_id) {
        this.set("student_id", student_id).saveIt();
    }
    // endregion

    /**
     * Find student unit.
     *
     * @param id the id
     * @return the student unit
     */
// region QUERY
    public static StudentUnit find(String id) {
        List<StudentUnit> studentUnits = StudentUnit.where("id = '" + id + "'");
        return studentUnits.get(0);
    }

    /**
     * Where student list.
     *
     * @param student_id the student id
     * @return the list
     */
    public static List<StudentUnit> whereStudent(String student_id) {
        return StudentUnit.where("student_id = '" + student_id + "'");
    }

    /**
     * Where unit semester list.
     *
     * @param unit_semester_id the unit semester id
     * @return the list
     */
    public static List<StudentUnit> whereUnitSemester(String unit_semester_id) {
        return StudentUnit.where("unit_semester_id = '" + unit_semester_id + "'");
    }
    // endregion
}
