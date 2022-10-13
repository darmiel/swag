package io.d2a.swag.builder.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 */
public class Radio<T> {

    @SafeVarargs
    public static <T> Radio<T> group(final T ... names) {
        final Radio<T> radio = new Radio<>();
        for (final T obj : names) {
            if (obj == null) {
                continue;
            }
            radio.createButton(obj);
        }
        return radio;
    }

    private final ButtonGroup group;
    private final Set<JRadioButton> buttons;

    private final List<Object> listeners;

    public Radio() {
        this.group = new ButtonGroup();
        this.buttons = new HashSet<>();
        this.listeners = new ArrayList<>();
    }

    /// Util

    public void createButton(final T obj) {
        final String stringer = obj.toString();
        final JRadioButton button = new JRadioButton(stringer);
        this.buttons.add(button);
        this.group.add(button);
        button.addActionListener(e -> this.buttonClickListener(obj, e));
    }


    /// Listeners

    public Radio<T> onChange(BiConsumer<T, ActionEvent> listener) {
        this.listeners.add(listener);
        return this;
    }

    public Radio<T> onChange(Consumer<T> listener) {
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

    public JPanel asPanel() {
        return this.asPanel(BoxLayout.X_AXIS);
    }

    public JPanel asPanel(final int align) {
        final JPanel panel = new JPanel();
        final BoxLayout box = new BoxLayout(panel, align);
        panel.setLayout(box);
        this.addTo(panel);
        return panel;
    }

    /// Getters

    public Set<JRadioButton> getButtons() {
        return buttons;
    }

}
