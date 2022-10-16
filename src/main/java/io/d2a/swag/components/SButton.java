package io.d2a.swag.components;

import io.d2a.swag.ComponentBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class SButton implements ComponentBuilder<JButton> {

    private final JButton button;

    public SButton() {
        this.button = new JButton();
    }

    public SButton(final String text) {
        this.button = new JButton(text);
    }

    public SButton click(final ActionListener listener) {
        this.button.addActionListener(listener);
        return this;
    }

    public SButton focus() {
        this.button.grabFocus();
        return this;
    }

    public SButton actionCommand(final String actionCommand) {
        this.button.setActionCommand(actionCommand);
        return this;
    }

    public SButton text(final String text) {
        this.button.setText(text);
        return this;
    }

    public SButton enable() {
        this.button.setEnabled(true);
        return this;
    }

    public SButton disable() {
        this.button.setEnabled(false);
        return this;
    }

    public SButton raw(final Consumer<JButton> button) {
        button.accept(this.button);
        return this;
    }

    @Override
    public JButton build() {
        return this.button;
    }

    /// AUTO GENERATED

    public SButton selected(boolean param1) {
        this.button.setSelected(param1);
        return this;
    }

    public SButton rolloverEnabled(boolean param1) {
        this.button.setRolloverEnabled(param1);
        return this;
    }

    public SButton hideActionText(boolean param1) {
        this.button.setHideActionText(param1);
        return this;
    }

    public SButton displayedMnemonicIndex(int param1) {
        this.button.setDisplayedMnemonicIndex(param1);
        return this;
    }

    public SButton mnemonic(char param1) {
        this.button.setMnemonic(param1);
        return this;
    }

    public SButton mnemonic(int param1) {
        this.button.setMnemonic(param1);
        return this;
    }

    public SButton icon(Icon param1) {
        this.button.setIcon(param1);
        return this;
    }

    public SButton disabledIcon(Icon param1) {
        this.button.setDisabledIcon(param1);
        return this;
    }

    public SButton disabledSelectedIcon(Icon param1) {
        this.button.setDisabledSelectedIcon(param1);
        return this;
    }

    public SButton borderPainted(boolean param1) {
        this.button.setBorderPainted(param1);
        return this;
    }

    public SButton iconTextGap(int param1) {
        this.button.setIconTextGap(param1);
        return this;
    }

    public SButton contentAreaFilled(boolean param1) {
        this.button.setContentAreaFilled(param1);
        return this;
    }

    public SButton margin(Insets param1) {
        this.button.setMargin(param1);
        return this;
    }

    public SButton pressedIcon(Icon param1) {
        this.button.setPressedIcon(param1);
        return this;
    }

    public SButton selectedIcon(Icon param1) {
        this.button.setSelectedIcon(param1);
        return this;
    }

    public SButton verticalAlignment(int param1) {
        this.button.setVerticalAlignment(param1);
        return this;
    }

    public SButton horizontalAlignment(int param1) {
        this.button.setHorizontalAlignment(param1);
        return this;
    }

    public SButton verticalTextPosition(int param1) {
        this.button.setVerticalTextPosition(param1);
        return this;
    }

    public SButton horizontalTextPosition(int param1) {
        this.button.setHorizontalTextPosition(param1);
        return this;
    }

    public SButton enabled(boolean param1) {
        this.button.setEnabled(param1);
        return this;
    }

    public SButton alignmentX(float param1) {
        this.button.setAlignmentX(param1);
        return this;
    }

    public SButton alignmentY(float param1) {
        this.button.setAlignmentY(param1);
        return this;
    }

    public SButton font(Font param1) {
        this.button.setFont(param1);
        return this;
    }

    public SButton preferredSize(Dimension param1) {
        this.button.setPreferredSize(param1);
        return this;
    }

    public SButton maximumSize(Dimension param1) {
        this.button.setMaximumSize(param1);
        return this;
    }

    public SButton minimumSize(Dimension param1) {
        this.button.setMinimumSize(param1);
        return this;
    }

    public SButton visible(boolean param1) {
        this.button.setVisible(param1);
        return this;
    }

    public SButton foreground(Color param1) {
        this.button.setForeground(param1);
        return this;
    }

    public SButton background(Color param1) {
        this.button.setBackground(param1);
        return this;
    }

    public SButton autoscrolls(boolean param1) {
        this.button.setAutoscrolls(param1);
        return this;
    }

    public SButton border(Border param1) {
        this.button.setBorder(param1);
        return this;
    }

    public SButton inputVerifier(InputVerifier param1) {
        this.button.setInputVerifier(param1);
        return this;
    }

    public SButton toolTipText(String param1) {
        this.button.setToolTipText(param1);
        return this;
    }

    public SButton opaque(boolean param1) {
        this.button.setOpaque(param1);
        return this;
    }

    public SButton size(Dimension param1) {
        this.button.setSize(param1);
        return this;
    }

    public SButton size(int param1, int param2) {
        this.button.setSize(param1, param2);
        return this;
    }

    public SButton bounds(Rectangle param1) {
        this.button.setBounds(param1);
        return this;
    }

    public SButton bounds(int param1, int param2, int param3, int param4) {
        this.button.setBounds(param1, param2, param3, param4);
        return this;
    }

    public SButton location(int param1, int param2) {
        this.button.setLocation(param1, param2);
        return this;
    }

    public SButton location(Point param1) {
        this.button.setLocation(param1);
        return this;
    }

    public SButton cursor(Cursor param1) {
        this.button.setCursor(param1);
        return this;
    }

    public SButton focusable(boolean param1) {
        this.button.setFocusable(param1);
        return this;
    }

    public SButton dropTarget(DropTarget param1) {
        this.button.setDropTarget(param1);
        return this;
    }

}
