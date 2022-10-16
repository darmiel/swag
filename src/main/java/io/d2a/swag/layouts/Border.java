package io.d2a.swag.layouts;

import io.d2a.swag.ComponentBuilder;
import io.d2a.swag.components.Panel;

import java.awt.*;

public class Border extends Panel {

    private Border() {
        this.setLayout(new BorderLayout());
    }

    private Border(final int hgap, final int vgap) {
        this.setLayout(new BorderLayout(hgap, vgap));
    }

    public static Border create() {
        return new Border();
    }

    public static Border gap(final int hgap, final int vgap) {
        return new Border(hgap, vgap);
    }

    //

    public Border center(final Component component) {
        this.add(component, BorderLayout.CENTER);
        return this;
    }

    public Border center(final ComponentBuilder<?> builder) {
        return this.center(builder.build());
    }

    //

    public Border north(final Component component) {
        this.add(component, BorderLayout.NORTH);
        return this;
    }

    public Border north(final ComponentBuilder<?> builder) {
        return this.north(builder.build());
    }

    public Border top(final ComponentBuilder<?> builder) {
        return this.north(builder);
    }

    public Border top(final Component component) {
        return this.north(component);
    }

    //

    public Border east(final Component component) {
        this.add(component, BorderLayout.EAST);
        return this;
    }

    public Border east(final ComponentBuilder<?> builder) {
        return this.east(builder.build());
    }

    public Border right(final Component component) {
        return this.east(component);
    }

    public Border right(final ComponentBuilder<?> builder) {
        return this.east(builder.build());
    }

    //

    public Border south(final Component component) {
        this.add(component, BorderLayout.SOUTH);
        return this;
    }

    public Border south(final ComponentBuilder<?> builder) {
        return this.south(builder.build());
    }

    public Border bottom(final Component component) {
        return this.south(component);
    }

    public Border bottom(final ComponentBuilder<?> builder) {
        return this.south(builder.build());
    }

    //

    public Border west(final Component component) {
        this.add(component, BorderLayout.WEST);
        return this;
    }

    public Border west(final ComponentBuilder<?> builder) {
        return this.west(builder.build());
    }

    public Border left(final Component component) {
        return this.west(component);
    }

    public Border left(final ComponentBuilder<?> builder) {
        return this.west(builder);
    }

    //


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
