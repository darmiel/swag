package io.d2a.swag.components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Keymap;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;

public class STextField extends TextFieldWrapper<JTextField> {

    public STextField() {
        super(new JTextField());
    }

    public STextField(final int cols) {
        super(new JTextField(cols));
    }

    public STextField(final String text) {
        super(new JTextField(text));
    }

    public STextField key(final Integer keyCode, final Runnable runnable) {
        this.getObject().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (keyCode == null || keyCode == e.getKeyCode()) {
                    runnable.run();
                }
            }
        });
        return this;
    }

    public STextField enter(final Runnable runnable) {
        return this.key(KeyEvent.VK_ENTER, runnable);
    }

    public STextField raw(final Consumer<JTextField> ta) {
        ta.accept(this.getObject());
        return this;
    }

    @Override
    public JTextField build() {
        return super.getObject();
    }

    /// AUTO GENERATED

    public STextField font(Font param1) {
        this.getObject().setFont(param1);
        return this;
    }

    public STextField columns(int param1) {
        this.getObject().setColumns(param1);
        return this;
    }

    public STextField editable(boolean param1) {
        this.getObject().setEditable(param1);
        return this;
    }

    public STextField dragEnabled(boolean param1) {
        this.getObject().setDragEnabled(param1);
        return this;
    }

    public STextField caretPosition(int param1) {
        this.getObject().setCaretPosition(param1);
        return this;
    }

    public STextField caret(Caret param1) {
        this.getObject().setCaret(param1);
        return this;
    }

    public STextField margin(Insets param1) {
        this.getObject().setMargin(param1);
        return this;
    }

    public STextField highlighter(Highlighter param1) {
        this.getObject().setHighlighter(param1);
        return this;
    }

    public STextField keymap(Keymap param1) {
        this.getObject().setKeymap(param1);
        return this;
    }

    public STextField dropMode(DropMode param1) {
        this.getObject().setDropMode(param1);
        return this;
    }

    public STextField caretColor(Color param1) {
        this.getObject().setCaretColor(param1);
        return this;
    }

    public STextField selectionColor(Color param1) {
        this.getObject().setSelectionColor(param1);
        return this;
    }

    public STextField selectedTextColor(Color param1) {
        this.getObject().setSelectedTextColor(param1);
        return this;
    }

    public STextField disabledTextColor(Color param1) {
        this.getObject().setDisabledTextColor(param1);
        return this;
    }

    public STextField selectionStart(int param1) {
        this.getObject().setSelectionStart(param1);
        return this;
    }

    public STextField selectionEnd(int param1) {
        this.getObject().setSelectionEnd(param1);
        return this;
    }

    public STextField document(Document param1) {
        this.getObject().setDocument(param1);
        return this;
    }

    public STextField text(String param1) {
        this.getObject().setText(param1);
        return this;
    }

    public STextField border(Border param1) {
        this.getObject().setBorder(param1);
        return this;
    }

    public STextField alignmentY(float param1) {
        this.getObject().setAlignmentY(param1);
        return this;
    }

    public STextField alignmentX(float param1) {
        this.getObject().setAlignmentX(param1);
        return this;
    }

    public STextField inputVerifier(InputVerifier param1) {
        this.getObject().setInputVerifier(param1);
        return this;
    }

    public STextField toolTipText(String param1) {
        this.getObject().setToolTipText(param1);
        return this;
    }

    public STextField visible(boolean param1) {
        this.getObject().setVisible(param1);
        return this;
    }

    public STextField preferredSize(Dimension param1) {
        this.getObject().setPreferredSize(param1);
        return this;
    }

    public STextField maximumSize(Dimension param1) {
        this.getObject().setMaximumSize(param1);
        return this;
    }

    public STextField minimumSize(Dimension param1) {
        this.getObject().setMinimumSize(param1);
        return this;
    }

    public STextField enabled(boolean param1) {
        this.getObject().setEnabled(param1);
        return this;
    }

    public STextField foreground(Color param1) {
        this.getObject().setForeground(param1);
        return this;
    }

    public STextField background(Color param1) {
        this.getObject().setBackground(param1);
        return this;
    }

    public STextField opaque(boolean param1) {
        this.getObject().setOpaque(param1);
        return this;
    }

    public STextField bounds(int param1, int param2, int param3, int param4) {
        this.getObject().setBounds(param1, param2, param3, param4);
        return this;
    }

    public STextField bounds(Rectangle param1) {
        this.getObject().setBounds(param1);
        return this;
    }

    public STextField location(Point param1) {
        this.getObject().setLocation(param1);
        return this;
    }

    public STextField location(int param1, int param2) {
        this.getObject().setLocation(param1, param2);
        return this;
    }

    public STextField dropTarget(DropTarget param1) {
        this.getObject().setDropTarget(param1);
        return this;
    }

    public STextField cursor(Cursor param1) {
        this.getObject().setCursor(param1);
        return this;
    }

    public STextField focusable(boolean param1) {
        this.getObject().setFocusable(param1);
        return this;
    }

    public STextField size(int param1, int param2) {
        this.getObject().setSize(param1, param2);
        return this;
    }

    public STextField size(Dimension param1) {
        this.getObject().setSize(param1);
        return this;
    }

    public STextField name(String param1) {
        this.getObject().setName(param1);
        return this;
    }



}
