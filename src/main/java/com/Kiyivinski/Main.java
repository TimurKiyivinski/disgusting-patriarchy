package com.Kiyivinski;

import com.Kiyivinski.models.*;
import org.javalite.activejdbc.Base;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO: Variable connection settings
        // Open database connection
        Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://192.168.99.100:3306/java", "root", "password");

        List<Student> students = Student.all();
        for (Student i: students) {
            String output = "Student: "
                    + i.getName() + " "
                    + i.getIdentification();
            System.out.println(output);
        }

        List<Course> courses = Course.all();
        for (Course i: courses) {
            String output = "Course: "
                    + i.getName();
            System.out.println(output);
        }

        List<Semester> semesters = Semester.all();
        for (Semester i: semesters) {
            String output = "Semester: "
                    + i.getName();
            System.out.println(output);
        }

        List<Type> types = Type.all();
        for (Type i: types) {
            String output = "Types: "
                    + i.getName();
            System.out.println(output);
        }

        List<Unit> units = Unit.all();
        for (Unit i: units) {
            String output = "Units: "
                    + i.getName() + " "
                    + i.getCode();
            System.out.println(output);
        }

        // Close database connection
        Base.close();
    }
}
