package io.d2a.swag.components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panel extends JPanel {

    public Panel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public Panel(LayoutManager layout) {
        super(layout);
    }

    public Panel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public Panel() {

    }

    public Panel border(final Border border) {
        this.setBorder(border);
        return this;
    }

    public Panel padding(final int top, final int left, final int bottom, final int right) {
        this.setBorder(new EmptyBorder(top, left, bottom, right));
        return this;
    }

    public Panel padding(final int vertical, final int horizontal) {
        return this.padding(vertical, horizontal, vertical, horizontal);
    }

    public Panel padding(final int padding) {
        return this.padding(padding, padding);
    }

}
