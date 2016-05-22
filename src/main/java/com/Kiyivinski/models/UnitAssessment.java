package com.Kiyivinski.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("unit_assessments")
public class UnitAssessment extends Model {
    public static UnitAssessment create(String unit_id, String assessment_id) {
        UnitAssessment unitAssessment = new UnitAssessment();
        unitAssessment.set("unit_id", unit_id);
        unitAssessment.set("assessment_id", assessment_id);
        unitAssessment.saveIt();
        return unitAssessment;
    }

    public static List<UnitAssessment> all() {
        return UnitAssessment.findAll();
    }

    // region GETTER
    // TODO: Implement from interface
    // endregion

    // region SETTER
    public void setUnit(String unit_id) {
        this.set("unit_id", unit_id).saveIt();
    }

    public void setAssessment(String assessment_id) {
        this.set("assessment_id", assessment_id).saveIt();
    }
    // endregion

    // region QUERY
    public static UnitAssessment find(String id) {
        List<UnitAssessment> unitAssessments = UnitAssessment.where("id = '" + id + "'");
        return unitAssessments.get(0);
    }

    public static List<UnitAssessment> whereUnit(String unit_id) {
        return UnitAssessment.where("unit_id = '" + unit_id + "'");
    }

    public static List<UnitAssessment> whereAssessment(String assessment_id) {
        return UnitAssessment.where("assessment_id = '" + assessment_id + "'");
    }
    // endregion
}
