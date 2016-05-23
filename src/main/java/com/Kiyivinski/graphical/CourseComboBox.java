package com.Kiyivinski.graphical;

import com.Kiyivinski.models.Course;

import javax.swing.*;
import java.util.List;

public class CourseComboBox extends JComboBox {
    CourseComboBox() {
        List<Course> courses = Course.all();
        for (Course c: courses) {
            this.addItem(c.getName());
        }
    }
}
