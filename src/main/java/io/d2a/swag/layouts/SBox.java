package io.d2a.swag.layouts;

import io.d2a.swag.ComponentBuilder;
import io.d2a.swag.components.SPanel;

import javax.swing.*;
import java.awt.*;

public class SBox extends SPanel {

    private SBox(final int axis) {
        this.setLayout(new BoxLayout(this, axis));
    }

    public static SBox vertical(){
        return new SBox(BoxLayout.Y_AXIS);
    }

    public static SBox horizontal() {
        return new SBox(BoxLayout.X_AXIS);
    }

    public SBox align(final float alignmentX) {
        this.setAlignmentX(alignmentX);
        return this;
    }

    public SBox with(final ComponentBuilder<?> builder) {
        this.add(builder.build());
        return this;
    }

    public SBox with(final Component component) {
        this.add(component);
        return this;
    }

    public SBox background(final Color color) {
        this.setBackground(color);
        return this;
    }

}
