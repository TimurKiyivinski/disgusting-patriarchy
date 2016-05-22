package com.Kiyivinski.models;

import com.Kiyivinski.interfaces.SemesterInterface;
import com.Kiyivinski.interfaces.TypeInterface;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("assessments")
public class Assessment extends Model implements TypeInterface, SemesterInterface {
    public static Assessment create(String name, String mark, String type_id, String semester_id) {
        Assessment assessment = new Assessment();
        assessment.set("name", name);
        assessment.set("mark", mark);
        assessment.set("type_id", type_id);
        assessment.set("semester_id", semester_id);
        assessment.saveIt();
        return assessment;
    }

    public static List<Assessment> all() {
        return Assessment.findAll();
    }

    // region GETTER
    public String getName() {
        return this.get("name").toString();
    }

    public String getMark() {
        return this.get("mark").toString();
    }

    public String getTypeID() {
        return this.get("type_id").toString();
    }

    public Type getType() {
        return Type.find(this.getTypeID());
    }

    public String getSemesterID() {
        return this.get("semester_id").toString();
    }

    public Semester getSemester() {
        return Semester.find(this.getSemesterID());
    }
    // TODO: Implement from interface
    // endregion

    // region SETTER
    public void setName(String name) {
        this.set("name", name).saveIt();
    }

    public void setMark(String mark) {
        this.set("mark", mark).saveIt();
    }

    public void setType(String type_id) {
        this.set("type_id", type_id).saveIt();
    }

    public void setSemester(String semester_id) {
        this.set("semester_id", semester_id).saveIt();
    }
    // endregion

    // region QUERY
    public static Assessment find(String id) {
        List<Assessment> assessments = Assessment.where("id = '" + id + "'");
        return assessments.get(0);
    }

    public static List<Assessment> whereName(String name) {
        return Assessment.where("name = '" + name + "'");
    }

    public static List<Assessment> whereMark(String mark) {
        return Assessment.where("mark = '" + mark + "'");
    }

    public static List<Assessment> whereType(String type_id) {
        return Assessment.where("type_id = '" + type_id + "'");
    }

    public static List<Assessment> whereSemester(String semester_id) {
        return Assessment.where("semester_id = '" + semester_id + "'");
    }
    // endregion
}
