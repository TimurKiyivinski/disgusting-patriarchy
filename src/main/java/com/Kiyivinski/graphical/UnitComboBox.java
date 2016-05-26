package com.Kiyivinski.graphical;

import com.Kiyivinski.models.Unit;

import javax.swing.*;
import java.util.List;

public class UnitComboBox extends JComboBox {
    UnitComboBox() {
        List<Unit> units = Unit.all();
        for (Unit c: units) {
            this.addItem(c.getName());
        }
    }
}
