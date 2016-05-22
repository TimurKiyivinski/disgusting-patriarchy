package com.Kiyivinski;

import com.Kiyivinski.models.Student;
import org.javalite.activejdbc.Base;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO: Variable connection settings
        // Open database connection
        Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://192.168.99.100:3306/java", "root", "password");

        List<Student> students = Student.findAll();
        for (Student s: students) {
            System.out.println(s);
        }

        // Close database connection
        Base.close();
    }
}
