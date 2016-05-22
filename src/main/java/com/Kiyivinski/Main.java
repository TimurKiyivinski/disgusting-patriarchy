package com.Kiyivinski;

import com.Kiyivinski.graphical.MainFrame;
import com.Kiyivinski.models.*;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO: Variable connection settings
        // Open database connection
        Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://192.168.99.100:3306/java", "root", "password");

        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
        }
        catch (ClassNotFoundException e) {
        }
        catch (InstantiationException e) {
        }
        catch (IllegalAccessException e) {
        }

        MainFrame mainFrame = new MainFrame();

        // Close database connection
        Base.close();
    }
}
