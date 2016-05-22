package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.SemesterInterface;
import com.Kiyivinski.interfaces.StudentInterface;
import com.Kiyivinski.interfaces.UnitInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("student_units")
public class StudentUnit extends Model implements StudentInterface, UnitInterface, SemesterInterface {
    public static StudentUnit create(String student_id, String unit_id, String semester_id) {
        StudentUnit studentUnit = new StudentUnit();
        studentUnit.set("student_id", student_id);
        studentUnit.set("unit_id", unit_id);
        studentUnit.set("semester_id", semester_id);
        studentUnit.saveIt();
        return studentUnit;
    }

    public static List<StudentUnit> all() {
        return StudentUnit.findAll();
    }

    // region GETTER
    public String getStudentID() {
        return this.get("student_id").toString();
    }

    public Student getStudent() {
        return Student.find(this.getStudentID());
    }

    public String getUnitID() {
        return this.get("unit_id").toString();
    }

    public Unit getUnit() {
        return Unit.find(this.getUnitID());
    }

    public String getSemesterID() {
        return this.get("semester_Id").toString();
    }

    public Semester getSemester() {
        return Semester.find(this.getSemesterID());
    }
    // endregion

    // region SETTER
    public void setUnit(String unit_id) {
        this.set("unit_id", unit_id).saveIt();
    }

    public void setAssessment(String assessment_id) {
        this.set("assessment_id", assessment_id).saveIt();
    }

    public void setSemester(String semester_id) {
        this.set("semester_id", semester_id).saveIt();
    }
    // endregion

    // region QUERY
    public static StudentUnit find(String id) {
        List<StudentUnit> studentUnits = StudentUnit.where("id = '" + id + "'");
        return studentUnits.get(0);
    }

    public static List<StudentUnit> whereStudent(String student_id) {
        return StudentUnit.where("student_id = '" + student_id + "'");
    }

    public static List<StudentUnit> whereUnit(String unit_id) {
        return StudentUnit.where("unit_id = '" + unit_id + "'");
    }

    public static List<StudentUnit> whereSemester(String semester_id) {
        return StudentUnit.where("semester_id = '" + semester_id + "'");
    }
    // endregion
}
