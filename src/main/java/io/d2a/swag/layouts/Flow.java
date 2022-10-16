package io.d2a.swag.layouts;

import io.d2a.swag.ComponentBuilder;
import io.d2a.swag.components.Panel;

import java.awt.*;

public class Flow extends Panel {

    public Flow(final int align, final int hgap, final int vgap) {
        this.setLayout(new FlowLayout(align, hgap, vgap));
    }

    public static Flow left() {
        return left(5, 5);
    }

    public static Flow left(final int hgap, final int vgap) {
        return new Flow(FlowLayout.LEFT, hgap, vgap);
    }

    public static Flow right() {
        return right(5, 5);
    }

    public static Flow right(final int hgap, final int vgap) {
        return new Flow(FlowLayout.RIGHT, hgap, vgap);
    }

    public static Flow center() {
        return center(5, 5);
    }

    public static Flow center(final Component component) {
        return center().with(component);
    }

    public static Flow center(final ComponentBuilder<?> component) {
        return center(component.build());
    }

    public static Flow center(final int hgap, final int vgap) {
        return new Flow(FlowLayout.CENTER, hgap, vgap);
    }

    public Flow with(final ComponentBuilder<?> builder) {
        this.add(builder.build());
        return this;
    }

    public Flow with(final Component component) {
        this.add(component);
        return this;
    }

    public Flow background(final Color color) {
        this.setBackground(color);
        return this;
    }

}
