package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.ModelTableRowListener;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;
import com.Kiyivinski.models.Course;

/**
 * The type Course table.
 */
public class CourseTable extends ModelTable {
    /**
     * Instantiates a new Course table.
     *
     * @param observer the observer
     */
    public CourseTable(ModelTableInterface observer) {
        super.addColumn("id");
        super.addColumn("Name");
        this.getSelectionModel().addListSelectionListener(new ModelTableRowListener(this, observer));
    }

    public void addCreate() {
        Object [] row = new Object[]{
                "0", "Create Course"
        };
        super.addRow(row);
    }

    /**
     * Add row.
     *
     * @param course the course
     */
    public void addRow(Course course) {
        Object [] row = new Object[]{
                course.getID(),
                course.getName()
        };
        super.addRow(row);
    }
}
