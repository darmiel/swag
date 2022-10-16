package io.d2a.swag.components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SPanel extends JPanel {

    public SPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public SPanel(LayoutManager layout) {
        super(layout);
    }

    public SPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public SPanel() {

    }

    public SPanel border(final Border border) {
        this.setBorder(border);
        return this;
    }

    public SPanel padding(final int top, final int left, final int bottom, final int right) {
        this.setBorder(new EmptyBorder(top, left, bottom, right));
        return this;
    }

    public SPanel padding(final int vertical, final int horizontal) {
        return this.padding(vertical, horizontal, vertical, horizontal);
    }

    public SPanel padding(final int padding) {
        return this.padding(padding, padding);
    }

}
