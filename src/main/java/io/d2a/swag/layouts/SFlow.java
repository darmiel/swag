package io.d2a.swag.layouts;

import io.d2a.swag.ComponentBuilder;
import io.d2a.swag.components.SPanel;

import java.awt.*;

public class SFlow extends SPanel {

    public SFlow(final int align, final int hgap, final int vgap) {
        this.setLayout(new FlowLayout(align, hgap, vgap));
    }

    public static SFlow left() {
        return left(5, 5);
    }

    public static SFlow left(final int hgap, final int vgap) {
        return new SFlow(FlowLayout.LEFT, hgap, vgap);
    }

    public static SFlow right() {
        return right(5, 5);
    }

    public static SFlow right(final int hgap, final int vgap) {
        return new SFlow(FlowLayout.RIGHT, hgap, vgap);
    }

    public static SFlow center() {
        return center(5, 5);
    }

    public static SFlow center(final Component component) {
        return center().with(component);
    }

    public static SFlow center(final ComponentBuilder<?> component) {
        return center(component.build());
    }

    public static SFlow center(final int hgap, final int vgap) {
        return new SFlow(FlowLayout.CENTER, hgap, vgap);
    }

    public SFlow with(final ComponentBuilder<?> builder) {
        this.add(builder.build());
        return this;
    }

    public SFlow with(final Component component) {
        this.add(component);
        return this;
    }

    public SFlow background(final Color color) {
        this.setBackground(color);
        return this;
    }

}
