package io.d2a.swag.templates;

import io.d2a.swag.ComponentBuilder;

import javax.swing.*;
import java.awt.*;

public final class SHeader implements ComponentBuilder<JLabel> {

    public static final float[] LEVELS = {
            26, 24, 20, 16, 14
    };

    private final int level;
    private final String heading;
    private Color color = null;

    public SHeader(int level, String heading) {
        this.level = level;
        this.heading = heading;
    }

    public static SHeader of(final String heading) {
        return of(1, heading);
    }

    public static SHeader of(final int level, final String heading) {
        return new SHeader(level, heading);
    }

    public SHeader color(final Color color) {
        this.color = color;
        return this;
    }

    @Override
    public JLabel build() {
        final JLabel label = new JLabel(this.heading);
        label.setFont(label.getFont()
                .deriveFont(label.getFont().getStyle() | Font.BOLD) // make bold
                .deriveFont(LEVELS[Math.min(LEVELS.length - 1, this.level - 1)])); // set size
        if (color != null) {
            label.setForeground(this.color);
        }
        return label;
    }

    @Override
    public String toString() {
        return "Header[" +
                "level=" + level + ", " +
                "heading=" + heading + ']';
    }


}
