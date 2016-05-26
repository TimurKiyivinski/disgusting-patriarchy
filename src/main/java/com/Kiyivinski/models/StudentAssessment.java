package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.AssessmentInterface;
import com.Kiyivinski.interfaces.StudentInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * The type Student assessment.
 */
@Table("student_assessments")
public class StudentAssessment extends Model implements StudentInterface, AssessmentInterface {
    /**
     * Create student assessment.
     *
     * @param student_id    the student id
     * @param assessment_id the assessment id
     * @return the student assessment
     */
    public static StudentAssessment create(String student_id, String assessment_id) {
        StudentAssessment studentAssessment = new StudentAssessment();
        studentAssessment.set("student_id", student_id);
        studentAssessment.set("assessment_id", assessment_id);
        studentAssessment.saveIt();
        return studentAssessment;
    }

    /**
     * All list.
     *
     * @return the list
     */
    public static List<StudentAssessment> all() {
        return StudentAssessment.findAll();
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

    public String getAssessmentID() {
        return this.get("assessment_id").toString();
    }

    public Assessment getAssessment() {
        return Assessment.find(this.getAssessmentID());
    }
    // endregion

    /**
     * Sets student.
     *
     * @param student_id the student id
     */
// region SETTER
    public void setStudent(String student_id) {
        this.set("student_id", student_id).saveIt();
    }

    /**
     * Sets assessment.
     *
     * @param assessment_id the assessment id
     */
    public void setAssessment(String assessment_id) {
        this.set("assessment_id", assessment_id).saveIt();
    }
    // endregion

    /**
     * Find student assessment.
     *
     * @param id the id
     * @return the student assessment
     */
// region QUERY
    public StudentAssessment find(String id) {
        List<StudentAssessment> studentAssessments = StudentAssessment.where("id = '" + id + "'");
        return studentAssessments.get(0);
    }

    /**
     * Where student list.
     *
     * @param student_id the student id
     * @return the list
     */
    public List<UnitSemester> whereStudent(String student_id) {
        return StudentAssessment.where("student_id = '" + student_id + "'");
    }

    /**
     * Where assessment list.
     *
     * @param assessment_id the assessment id
     * @return the list
     */
    public List<UnitSemester> whereAssessment(String assessment_id) {
        return StudentAssessment.where("assessment_id = '" + assessment_id + "'");
    }
    // endregion
}
