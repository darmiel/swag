package io.d2a.swag.layouts;

import io.d2a.swag.ComponentBuilder;
import io.d2a.swag.components.Panel;

import javax.swing.*;
import java.awt.*;

public class Box extends Panel {

    private Box(final int axis) {
        this.setLayout(new BoxLayout(this, axis));
    }

    public static Box vertical(){
        return new Box(BoxLayout.Y_AXIS);
    }

    public static Box horizontal() {
        return new Box(BoxLayout.X_AXIS);
    }

    public Box align(final float alignmentX) {
        this.setAlignmentX(alignmentX);
        return this;
    }

    public Box with(final ComponentBuilder<?> builder) {
        this.add(builder.build());
        return this;
    }

    public Box with(final Component component) {
        this.add(component);
        return this;
    }

    public Box background(final Color color) {
        this.setBackground(color);
        return this;
    }

}
