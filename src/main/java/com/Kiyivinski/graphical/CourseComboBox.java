package com.Kiyivinski.graphical;

import com.Kiyivinski.models.Course;

import javax.swing.*;
import java.util.List;

/**
 * The type Course combo box.
 */
public class CourseComboBox extends JComboBox {
    /**
     * Instantiates a new Course combo box.
     */
    CourseComboBox() {
        List<Course> courses = Course.all();
        for (Course c: courses) {
            this.addItem(c.getName());
        }
    }
}
