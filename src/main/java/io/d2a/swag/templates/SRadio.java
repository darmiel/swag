package io.d2a.swag.templates;

import io.d2a.swag.components.SPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 */
public class SRadio<T> {

    @SafeVarargs
    public static <T> SRadio<T> group(final T... names) {
        final SRadio<T> radio = new SRadio<>();
        for (final T obj : names) {
            if (obj == null) {
                continue;
            }
            radio.createButton(obj);
        }
        return radio;
    }

    ///

    private final ButtonGroup group;

    private final List<JRadioButton> buttons;
    private final List<Object> listeners;

    public SRadio() {
        this.group = new ButtonGroup();
        this.buttons = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    /// Util

    public void createButton(final T obj) {
        final String stringer = obj.toString();
        final JRadioButton button = new JRadioButton(stringer);
        if (this.buttons.size() == 0) {
            button.setSelected(true);
        }
        this.buttons.add(button);
        this.group.add(button);
        button.addActionListener(e -> this.buttonClickListener(obj, e));
    }


    /// Listeners

    public SRadio<T> onChange(BiConsumer<T, ActionEvent> listener) {
        this.listeners.add(listener);
        return this;
    }

    public SRadio<T> onChange(Consumer<T> listener) {
        this.listeners.add(listener);
        return this;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void buttonClickListener(final T obj, final ActionEvent event) {
        for (Object listener : this.listeners) {
            if (listener instanceof BiConsumer consumer) {
                consumer.accept(obj, event);
            } else if (listener instanceof Consumer consumer) {
                consumer.accept(obj);
            }
        }
    }

    /// Builders

    public void addTo(final JComponent component) {
        this.buttons.forEach(component::add);
    }

    public SRadio<T> select(final T t) {
        for (final JRadioButton button : this.buttons) {
            button.setSelected(button.getText().equals(t.toString()));
        }
        return this;
    }

    public static class RadioPanel<T> extends SPanel {
        private final List<JRadioButton> buttons;

        public RadioPanel(final List<JRadioButton> buttons) {
            this.buttons = buttons;
        }

        public JRadioButton getButton(final T t) {
            for (JRadioButton button : this.buttons) {
                if (button.getText().equals(Objects.toString(t))) {
                    return button;
                }
            }
            return null;
        }

        public List<JRadioButton> getButtons() {
            return buttons;
        }

    }

    public RadioPanel<T> asPanel() {
        return this.asPanel(BoxLayout.X_AXIS);
    }

    public RadioPanel<T> asPanel(final int align) {
        final RadioPanel<T> panel = new RadioPanel<>(this.buttons);
        final BoxLayout box = new BoxLayout(panel, align);
        panel.setLayout(box);
        this.addTo(panel);
        return panel;
    }

    /// Getters

    public List<JRadioButton> getButtons() {
        return buttons;
    }

}
