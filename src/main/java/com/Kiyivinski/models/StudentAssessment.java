package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.AssessmentInterface;
import com.Kiyivinski.interfaces.StudentInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("student_assessments")
public class StudentAssessment extends Model implements StudentInterface, AssessmentInterface {
    public static StudentAssessment create(String student_id, String assessment_id, String grade) {
        StudentAssessment studentAssessment = new StudentAssessment();
        studentAssessment.set("student_id", student_id);
        studentAssessment.set("assessment_id", assessment_id);
        studentAssessment.set("grade", grade);
        studentAssessment.saveIt();
        return studentAssessment;
    }

    public static List<StudentAssessment> all() {
        return StudentAssessment.findAll();
    }

    // region GETTER
    public String getGrade() {
        return this.get("grade").toString();
    }

    public String getStudentID() {
        return this.get("student_id").toString();
    }

    public Student getStudent() {
        return Student.find(this.getStudentID());
    }

    public String getAssessmentID() {
        return this.get("assessment_id").toString();
    }

    public Assessment getAssessment() {
        return Assessment.find(this.getAssessmentID());
    }
    // endregion

    // region SETTER
    public void setStudent(String student_id) {
        this.set("student_id", student_id).saveIt();
    }

    public void setAssessment(String assessment_id) {
        this.set("assessment_id", assessment_id).saveIt();
    }

    public void setGrade(String grade) {
        this.set("grade", grade).saveIt();
    }
    // endregion

    // region QUERY
    public StudentAssessment find(String id) {
        List<StudentAssessment> studentAssessments = StudentAssessment.where("id = '" + id + "'");
        return studentAssessments.get(0);
    }

    public List<UnitAssessment> whereStudent(String student_id) {
        return StudentAssessment.where("student_id = '" + student_id + "'");
    }

    public List<UnitAssessment> whereAssessment(String assessment_id) {
        return StudentAssessment.where("assessment_id = '" + assessment_id + "'");
    }

    public List<StudentAssessment> whereGrade(String grade) {
        return StudentAssessment.where("grade = '" + grade + "'");
    }
    // endregion
}
