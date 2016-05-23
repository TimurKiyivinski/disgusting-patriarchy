package com.Kiyivinski;

import com.Kiyivinski.graphical.MainFrame;
import org.javalite.activejdbc.Base;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
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
    }
}
