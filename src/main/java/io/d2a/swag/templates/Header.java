package io.d2a.swag.templates;

import io.d2a.swag.builder.ComponentBuilder;

import javax.swing.*;
import java.awt.*;

public record Header(int level, String heading) implements ComponentBuilder<JLabel> {

    public static final float[] LEVELS = {
            26, 24, 20, 16, 14
    };

    public static Header of(final String heading) {
        return of(1, heading);
    }

    public static Header of(final int level, final String heading) {
        return new Header(level, heading);
    }

    @Override
    public JLabel build() {
        final JLabel label = new JLabel(this.heading());
        System.out.println(label.getFont());
        label.setFont(label.getFont()
                .deriveFont(label.getFont().getStyle() | Font.BOLD)
                .deriveFont(LEVELS[Math.min(LEVELS.length - 1, this.level() - 1)]));
        System.out.println(label.getFont());
        return label;
    }

}
