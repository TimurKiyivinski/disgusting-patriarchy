package com.Kiyivinski.interfaces;

import com.Kiyivinski.models.Course;

/**
 * The interface Course interface.
 */
public interface CourseInterface {
    /**
     * Gets course id.
     *
     * @return the course id
     */
    public String getCourseID();

    /**
     * Gets course.
     *
     * @return the course
     */
    public Course getCourse();
}
