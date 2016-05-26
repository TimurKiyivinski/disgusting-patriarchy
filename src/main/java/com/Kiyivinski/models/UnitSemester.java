package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.SemesterInterface;
import com.Kiyivinski.interfaces.UnitInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("unit_semesters")
public class UnitSemester extends Model implements UnitInterface, SemesterInterface {
    public static UnitSemester create(String unit_id, String semester_id) {
        UnitSemester unitSemester = new UnitSemester();
        unitSemester.set("unit_id", unit_id);
        unitSemester.set("semester_id", semester_id);
        unitSemester.saveIt();
        return unitSemester;
    }

    public static List<UnitSemester> all() {
        return UnitSemester.findAll();
    }

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

    // region SETTER
    public void setUnit(String unit_id) {
        this.set("unit_id", unit_id).saveIt();
    }

    public void setSemester(String semester_id) {
        this.set("semester_id", semester_id).saveIt();
    }
    // endregion

    // region QUERY
    public static UnitSemester find(String id) {
        List<UnitSemester> unitSemesters = UnitSemester.where("id = '" + id + "'");
        return unitSemesters.get(0);
    }

    public static List<UnitSemester> whereUnit(String unit_id) {
        return UnitSemester.where("unit_id = '" + unit_id + "'");
    }

    public static List<UnitSemester> whereSemester(String semester_id) {
        return UnitSemester.where("semester_id = '" + semester_id + "'");
    }
    // endregion
}
