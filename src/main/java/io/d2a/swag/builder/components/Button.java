package io.d2a.swag.builder.components;

import io.d2a.swag.builder.ComponentBuilder;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button implements ComponentBuilder<JButton> {

    private final JButton button;

    public Button() {
        this.button = new JButton();
    }

    public Button(final String text) {
        this.button = new JButton(text);
    }

    public Button click(final ActionListener listener) {
        this.button.addActionListener(listener);
        return this;
    }

    public Button focus() {
        this.button.grabFocus();
        return this;
    }

    public Button actionCommand(final String actionCommand) {
        this.button.setActionCommand(actionCommand);
        return this;
    }

    public Button text(final String text) {
        this.button.setText(text);
        return this;
    }

    public Button enable() {
        this.button.setEnabled(true);
        return this;
    }

    public Button disable() {
        this.button.setEnabled(false);
        return this;
    }

    @Override
    public JButton build() {
        return this.button;
    }

}
