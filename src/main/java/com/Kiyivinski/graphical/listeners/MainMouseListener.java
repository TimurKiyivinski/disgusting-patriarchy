package com.Kiyivinski.graphical.listeners;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMouseListener implements MouseListener {
    private JFrame parent;
    private final String title = "4316886 TIMOTHY KIYUI Assignment 2";

    public MainMouseListener(JFrame parent) {
        this.parent = parent;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    public void mouseEntered(MouseEvent e) {
        parent.setTitle(this.title);
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    public void mouseExited(MouseEvent e) {
        parent.setTitle("FOCUS ON TITLE TO DISCOVER DEVELOPER");
    }
}
