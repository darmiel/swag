package io.d2a.swag.builder.layouts;

import io.d2a.swag.builder.ComponentBuilder;

import javax.swing.*;
import java.awt.*;

public class Border extends JPanel {

    private Border() {
        this.setLayout(new BorderLayout());
    }

    public static Border create() {
        return new Border();
    }

    public Border center(final Component component) {
        this.add(component, BorderLayout.CENTER);
        return this;
    }

    public Border center(final ComponentBuilder<?> builder) {
        this.add(builder.build(), BorderLayout.CENTER);
        return this;
    }

    public Border north(final Component component) {
        this.add(component, BorderLayout.NORTH);
        return this;
    }

    public Border east(final Component component) {
        this.add(component, BorderLayout.EAST);
        return this;
    }

    public Border south(final Component component) {
        this.add(component, BorderLayout.SOUTH);
        return this;
    }

    public Border west(final Component component) {
        this.add(component, BorderLayout.WEST);
        return this;
    }

    public Border north(final ComponentBuilder<?> builder) {
        this.add(builder.build(), BorderLayout.NORTH);
        return this;
    }

    public Border east(final ComponentBuilder<?> builder) {
        this.add(builder.build(), BorderLayout.EAST);
        return this;
    }

    public Border south(final ComponentBuilder<?> builder) {
        this.add(builder.build(), BorderLayout.SOUTH);
        return this;
    }

    public Border west(final ComponentBuilder<?> builder) {
        this.add(builder.build(), BorderLayout.WEST);
        return this;
    }

    public Border with(final ComponentBuilder<?> builder, final int dir) {
        this.add(builder.build(), dir);
        return this;
    }

    public Border with(final Component component, final int dir) {
        this.add(component, dir);
        return this;
    }

    public Border background(final Color color) {
        this.setBackground(color);
        return this;
    }

}
