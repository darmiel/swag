package io.d2a.swag.layouts;

import io.d2a.swag.ComponentBuilder;
import io.d2a.swag.templates.SHeader;
import io.d2a.swag.components.SPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SGrid extends SPanel {

    public SGrid() {
        this.setLayout(new GridLayout());
    }

    public SGrid(final int rows, final int cols) {
        this.setLayout(new GridLayout(rows, cols));
    }

    public SGrid(final int rows, final int cols, final int hgap, final int vgap) {
        this.setLayout(new GridLayout(rows, cols, hgap, vgap));
    }

    public static SGrid of(final int cols, final Object... components) {
        final SGrid grid = new SGrid(components.length / cols, cols);
        for (final Object object : components) {
            if (object instanceof Component component) {
                grid.add(component);
            } else if (object instanceof ComponentBuilder<?> builder) {
                grid.add(builder.build());
            } else {
                grid.add(new JLabel(Objects.toString(object)));
            }
        }
        return grid;
    }


    public SGrid with(final ComponentBuilder<?> builder) {
        this.add(builder.build());
        return this;
    }

    public SGrid with(final Component component) {
        this.add(component);
        return this;
    }

    public static Geritt builder() {
        return new Geritt();
    }

    public static class Geritt implements ComponentBuilder<SGrid> {

        private int cols = -1;
        private final List<Object[]> rows = new ArrayList<>();

        public Geritt labelComponent(final String label, final Component component) {
            return this.with(new JLabel(label), component);
        }

        public Geritt headers(final String... headers) {
            return this.headers(1, headers);
        }

        public Geritt headers(final int level, final String... headers) {
            if (this.cols == -1) { // initial value
                this.cols = headers.length;
            } else if (this.cols != headers.length) {
                throw new IllegalArgumentException("grid must have even cols");
            }
            final Object[] objects = new Object[headers.length];
            for (int i = 0; i < headers.length; i++) {
                objects[i] = SHeader.of(level, headers[i]);
            }
            this.rows.add(objects);
            return this;
        }

        public Geritt with(final Object... objects) {
            if (this.cols == -1) { // initial value
                this.cols = objects.length;
            } else if (this.cols != objects.length) {
                throw new IllegalArgumentException("grid must have even cols");
            }
            this.rows.add(objects);
            return this;
        }

        /**
         * Alias to {@link Geritt#with(Object...)}
         *
         * @param objects Objects to add
         * @return Geritt instance
         */
        public Geritt data(final Object... objects) {
            return this.with(objects);
        }

        @Override
        public SGrid build() {
            final Object[] objects = new Object[this.cols * this.rows.size()];
            int i = 0;
            for (final Object[] row : rows) {
                for (final Object o : row) {
                    objects[i++] = o;
                }
            }
            return SGrid.of(this.cols, objects);
        }

    }


}
