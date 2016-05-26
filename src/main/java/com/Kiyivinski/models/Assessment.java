package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.SemesterInterface;
import com.Kiyivinski.interfaces.UnitInterface;
import com.Kiyivinski.interfaces.UnitSemesterInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * The type Assessment.
 */
@Table("assessments")
public class Assessment extends Model implements UnitSemesterInterface, UnitInterface, SemesterInterface {
    /**
     * Create assessment.
     *
     * @param name             the name
     * @param mark             the mark
     * @param unit_semester_id the unit semester id
     * @return the assessment
     */
    public static Assessment create(String name, String mark, String unit_semester_id) {
        Assessment assessment = new Assessment();
        assessment.set("name", name);
        assessment.set("mark", mark);
        assessment.set("unit_semester_id", unit_semester_id);
        assessment.saveIt();
        return assessment;
    }

    /**
     * All list.
     *
     * @return the list
     */
    public static List<Assessment> all() {
        return Assessment.findAll();
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
     * Gets mark.
     *
     * @return the mark
     */
    public String getMark() {
        return this.get("mark").toString();
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
        return this.get("semester_id").toString();
    }

    public Semester getSemester() {
        return Semester.find(this.getSemesterID());
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
     * Sets mark.
     *
     * @param mark the mark
     */
    public void setMark(String mark) {
        this.set("mark", mark).saveIt();
    }

    /**
     * Sets semester.
     *
     * @param semester_id the semester id
     */
    public void setSemester(String semester_id) {
        this.set("semester_id", semester_id).saveIt();
    }
    // endregion

    /**
     * Find assessment.
     *
     * @param id the id
     * @return the assessment
     */
// region QUERY
    public static Assessment find(String id) {
        List<Assessment> assessments = Assessment.where("id = '" + id + "'");
        return assessments.get(0);
    }

    /**
     * Where name list.
     *
     * @param name the name
     * @return the list
     */
    public static List<Assessment> whereName(String name) {
        return Assessment.where("name = '" + name + "'");
    }

    /**
     * Where mark list.
     *
     * @param mark the mark
     * @return the list
     */
    public static List<Assessment> whereMark(String mark) {
        return Assessment.where("mark = '" + mark + "'");
    }

    /**
     * Where semester list.
     *
     * @param semester_id the semester id
     * @return the list
     */
    public static List<Assessment> whereSemester(String semester_id) {
        return Assessment.where("semester_id = '" + semester_id + "'");
    }
    // endregion
}
