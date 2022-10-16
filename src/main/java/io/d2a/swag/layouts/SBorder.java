package io.d2a.swag.layouts;

import io.d2a.swag.ComponentBuilder;
import io.d2a.swag.components.SPanel;

import java.awt.*;

public class SBorder extends SPanel {

    private SBorder() {
        this.setLayout(new BorderLayout());
    }

    private SBorder(final int hgap, final int vgap) {
        this.setLayout(new BorderLayout(hgap, vgap));
    }

    public static SBorder create() {
        return new SBorder();
    }

    public static SBorder gap(final int hgap, final int vgap) {
        return new SBorder(hgap, vgap);
    }

    //

    public SBorder center(final Component component) {
        this.add(component, BorderLayout.CENTER);
        return this;
    }

    public SBorder center(final ComponentBuilder<?> builder) {
        return this.center(builder.build());
    }

    //

    public SBorder north(final Component component) {
        this.add(component, BorderLayout.NORTH);
        return this;
    }

    public SBorder north(final ComponentBuilder<?> builder) {
        return this.north(builder.build());
    }

    public SBorder top(final ComponentBuilder<?> builder) {
        return this.north(builder);
    }

    public SBorder top(final Component component) {
        return this.north(component);
    }

    //

    public SBorder east(final Component component) {
        this.add(component, BorderLayout.EAST);
        return this;
    }

    public SBorder east(final ComponentBuilder<?> builder) {
        return this.east(builder.build());
    }

    public SBorder right(final Component component) {
        return this.east(component);
    }

    public SBorder right(final ComponentBuilder<?> builder) {
        return this.east(builder.build());
    }

    //

    public SBorder south(final Component component) {
        this.add(component, BorderLayout.SOUTH);
        return this;
    }

    public SBorder south(final ComponentBuilder<?> builder) {
        return this.south(builder.build());
    }

    public SBorder bottom(final Component component) {
        return this.south(component);
    }

    public SBorder bottom(final ComponentBuilder<?> builder) {
        return this.south(builder.build());
    }

    //

    public SBorder west(final Component component) {
        this.add(component, BorderLayout.WEST);
        return this;
    }

    public SBorder west(final ComponentBuilder<?> builder) {
        return this.west(builder.build());
    }

    public SBorder left(final Component component) {
        return this.west(component);
    }

    public SBorder left(final ComponentBuilder<?> builder) {
        return this.west(builder);
    }

    //


    public SBorder with(final ComponentBuilder<?> builder, final int dir) {
        this.add(builder.build(), dir);
        return this;
    }

    public SBorder with(final Component component, final int dir) {
        this.add(component, dir);
        return this;
    }

    public SBorder background(final Color color) {
        this.setBackground(color);
        return this;
    }

}
