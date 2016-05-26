package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.SemesterInterface;
import com.Kiyivinski.interfaces.UnitInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

/**
 * The type Unit semester.
 */
@Table("unit_semesters")
public class UnitSemester extends Model implements UnitInterface, SemesterInterface {
    /**
     * Create unit semester.
     *
     * @param unit_id     the unit id
     * @param semester_id the semester id
     * @return the unit semester
     */
    public static UnitSemester create(String unit_id, String semester_id) {
        UnitSemester unitSemester = new UnitSemester();
        unitSemester.set("unit_id", unit_id);
        unitSemester.set("semester_id", semester_id);
        unitSemester.saveIt();
        return unitSemester;
    }

    /**
     * All list.
     *
     * @return the list
     */
    public static List<UnitSemester> all() {
        return UnitSemester.findAll();
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

    public String getUnitID() {
        return this.get("unit_id").toString();
    }

    public Unit getUnit() {
        return Unit.find(this.getUnitID());
    }

    public String getSemesterID() {
        return this.get("semester_id").toString();
    }

    public Semester getSemester() {
        return Semester.find(this.getSemesterID());
    }
    // endregion

    /**
     * Sets unit.
     *
     * @param unit_id the unit id
     */
// region SETTER
    public void setUnit(String unit_id) {
        this.set("unit_id", unit_id).saveIt();
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
     * Find unit semester.
     *
     * @param id the id
     * @return the unit semester
     */
// region QUERY
    public static UnitSemester find(String id) {
        List<UnitSemester> unitSemesters = UnitSemester.where("id = '" + id + "'");
        return unitSemesters.get(0);
    }

    /**
     * Where unit list.
     *
     * @param unit_id the unit id
     * @return the list
     */
    public static List<UnitSemester> whereUnit(String unit_id) {
        return UnitSemester.where("unit_id = '" + unit_id + "'");
    }

    /**
     * Where semester list.
     *
     * @param semester_id the semester id
     * @return the list
     */
    public static List<UnitSemester> whereSemester(String semester_id) {
        return UnitSemester.where("semester_id = '" + semester_id + "'");
    }
    // endregion
}
