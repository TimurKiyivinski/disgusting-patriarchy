package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.SemesterInterface;
import com.Kiyivinski.interfaces.StudentInterface;
import com.Kiyivinski.interfaces.UnitInterface;
import com.Kiyivinski.interfaces.UnitSemesterInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("student_units")
public class StudentUnit extends Model implements StudentInterface, UnitSemesterInterface, UnitInterface, SemesterInterface {
    public static StudentUnit create(String student_id, String unit_semester_id) {
        StudentUnit studentUnit = new StudentUnit();
        studentUnit.set("student_id", student_id);
        studentUnit.set("unit_semester_id", unit_semester_id);
        studentUnit.saveIt();
        return studentUnit;
    }

    public static List<StudentUnit> all() {
        return StudentUnit.findAll();
    }

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

    // region SETTER
    public void setUnitSemester(String unit_semester_id) {
        this.set("unit_semester_id", unit_semester_id).saveIt();
    }

    public void setStudent(String student_id) {
        this.set("student_id", student_id).saveIt();
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

    public static List<StudentUnit> whereUnitSemester(String unit_semester_id) {
        return StudentUnit.where("unit_semester_id = '" + unit_semester_id + "'");
    }
    // endregion
}
