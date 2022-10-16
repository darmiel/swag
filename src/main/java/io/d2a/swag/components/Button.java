package io.d2a.swag.components;

import io.d2a.swag.ComponentBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

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

    public Button raw(final Consumer<JButton> button) {
        button.accept(this.button);
        return this;
    }

    @Override
    public JButton build() {
        return this.button;
    }

    /// AUTO GENERATED

    public Button selected(boolean param1) {
        this.button.setSelected(param1);
        return this;
    }

    public Button rolloverEnabled(boolean param1) {
        this.button.setRolloverEnabled(param1);
        return this;
    }

    public Button hideActionText(boolean param1) {
        this.button.setHideActionText(param1);
        return this;
    }

    public Button displayedMnemonicIndex(int param1) {
        this.button.setDisplayedMnemonicIndex(param1);
        return this;
    }

    public Button mnemonic(char param1) {
        this.button.setMnemonic(param1);
        return this;
    }

    public Button mnemonic(int param1) {
        this.button.setMnemonic(param1);
        return this;
    }

    public Button icon(Icon param1) {
        this.button.setIcon(param1);
        return this;
    }

    public Button disabledIcon(Icon param1) {
        this.button.setDisabledIcon(param1);
        return this;
    }

    public Button disabledSelectedIcon(Icon param1) {
        this.button.setDisabledSelectedIcon(param1);
        return this;
    }

    public Button borderPainted(boolean param1) {
        this.button.setBorderPainted(param1);
        return this;
    }

    public Button iconTextGap(int param1) {
        this.button.setIconTextGap(param1);
        return this;
    }

    public Button contentAreaFilled(boolean param1) {
        this.button.setContentAreaFilled(param1);
        return this;
    }

    public Button margin(Insets param1) {
        this.button.setMargin(param1);
        return this;
    }

    public Button pressedIcon(Icon param1) {
        this.button.setPressedIcon(param1);
        return this;
    }

    public Button selectedIcon(Icon param1) {
        this.button.setSelectedIcon(param1);
        return this;
    }

    public Button verticalAlignment(int param1) {
        this.button.setVerticalAlignment(param1);
        return this;
    }

    public Button horizontalAlignment(int param1) {
        this.button.setHorizontalAlignment(param1);
        return this;
    }

    public Button verticalTextPosition(int param1) {
        this.button.setVerticalTextPosition(param1);
        return this;
    }

    public Button horizontalTextPosition(int param1) {
        this.button.setHorizontalTextPosition(param1);
        return this;
    }

    public Button enabled(boolean param1) {
        this.button.setEnabled(param1);
        return this;
    }

    public Button alignmentX(float param1) {
        this.button.setAlignmentX(param1);
        return this;
    }

    public Button alignmentY(float param1) {
        this.button.setAlignmentY(param1);
        return this;
    }

    public Button font(Font param1) {
        this.button.setFont(param1);
        return this;
    }

    public Button preferredSize(Dimension param1) {
        this.button.setPreferredSize(param1);
        return this;
    }

    public Button maximumSize(Dimension param1) {
        this.button.setMaximumSize(param1);
        return this;
    }

    public Button minimumSize(Dimension param1) {
        this.button.setMinimumSize(param1);
        return this;
    }

    public Button visible(boolean param1) {
        this.button.setVisible(param1);
        return this;
    }

    public Button foreground(Color param1) {
        this.button.setForeground(param1);
        return this;
    }

    public Button background(Color param1) {
        this.button.setBackground(param1);
        return this;
    }

    public Button autoscrolls(boolean param1) {
        this.button.setAutoscrolls(param1);
        return this;
    }

    public Button border(Border param1) {
        this.button.setBorder(param1);
        return this;
    }

    public Button inputVerifier(InputVerifier param1) {
        this.button.setInputVerifier(param1);
        return this;
    }

    public Button toolTipText(String param1) {
        this.button.setToolTipText(param1);
        return this;
    }

    public Button opaque(boolean param1) {
        this.button.setOpaque(param1);
        return this;
    }

    public Button size(Dimension param1) {
        this.button.setSize(param1);
        return this;
    }

    public Button size(int param1, int param2) {
        this.button.setSize(param1, param2);
        return this;
    }

    public Button bounds(Rectangle param1) {
        this.button.setBounds(param1);
        return this;
    }

    public Button bounds(int param1, int param2, int param3, int param4) {
        this.button.setBounds(param1, param2, param3, param4);
        return this;
    }

    public Button location(int param1, int param2) {
        this.button.setLocation(param1, param2);
        return this;
    }

    public Button location(Point param1) {
        this.button.setLocation(param1);
        return this;
    }

    public Button cursor(Cursor param1) {
        this.button.setCursor(param1);
        return this;
    }

    public Button focusable(boolean param1) {
        this.button.setFocusable(param1);
        return this;
    }

    public Button dropTarget(DropTarget param1) {
        this.button.setDropTarget(param1);
        return this;
    }

}
