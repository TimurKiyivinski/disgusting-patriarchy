package com.Kiyivinski.graphical;

import com.Kiyivinski.models.Unit;

import javax.swing.*;
import java.util.List;

/**
 * The type Unit combo box.
 */
public class UnitComboBox extends JComboBox {
    /**
     * Instantiates a new Unit combo box.
     */
    UnitComboBox() {
        List<Unit> units = Unit.all();
        for (Unit u : units) {
            this.addItem(u);
        }
    }
}
