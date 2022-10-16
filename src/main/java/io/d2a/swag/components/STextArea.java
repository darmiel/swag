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

public class STextArea extends TextFieldWrapper<JTextArea> {

    public STextArea() {
        super(new JTextArea());
    }

    public STextArea(final int rows, final int cols) {
        super(new JTextArea(rows, cols));
    }

    public STextArea(final String text) {
        super(new JTextArea(text));
    }

    public STextArea key(final int keyCode, final Runnable runnable) {
        this.getObject().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == keyCode) {
                    runnable.run();
                }
            }
        });
        return this;
    }

    public STextArea enter(final Runnable runnable) {
        return this.key(KeyEvent.VK_ENTER, runnable);
    }

    public STextArea raw(final Consumer<JTextArea> ta) {
        ta.accept(this.getObject());
        return this;
    }

    @Override
    public JTextArea build() {
        return super.getObject();
    }


    /// AUTO GENERATED

    public STextArea font(Font param1) {
        this.getObject().setFont(param1);
        return this;
    }

    public STextArea tabSize(int param1) {
        this.getObject().setTabSize(param1);
        return this;
    }

    public STextArea rows(int param1) {
        this.getObject().setRows(param1);
        return this;
    }

    public STextArea columns(int param1) {
        this.getObject().setColumns(param1);
        return this;
    }

    public STextArea editable(boolean param1) {
        this.getObject().setEditable(param1);
        return this;
    }

    public STextArea dragEnabled(boolean param1) {
        this.getObject().setDragEnabled(param1);
        return this;
    }

    public STextArea caretPosition(int param1) {
        this.getObject().setCaretPosition(param1);
        return this;
    }

    public STextArea caret(Caret param1) {
        this.getObject().setCaret(param1);
        return this;
    }

    public STextArea margin(Insets param1) {
        this.getObject().setMargin(param1);
        return this;
    }

    public STextArea highlighter(Highlighter param1) {
        this.getObject().setHighlighter(param1);
        return this;
    }

    public STextArea keymap(Keymap param1) {
        this.getObject().setKeymap(param1);
        return this;
    }

    public STextArea dropMode(DropMode param1) {
        this.getObject().setDropMode(param1);
        return this;
    }

    public STextArea caretColor(Color param1) {
        this.getObject().setCaretColor(param1);
        return this;
    }

    public STextArea selectionColor(Color param1) {
        this.getObject().setSelectionColor(param1);
        return this;
    }

    public STextArea selectedTextColor(Color param1) {
        this.getObject().setSelectedTextColor(param1);
        return this;
    }

    public STextArea disabledTextColor(Color param1) {
        this.getObject().setDisabledTextColor(param1);
        return this;
    }

    public STextArea selectionStart(int param1) {
        this.getObject().setSelectionStart(param1);
        return this;
    }

    public STextArea selectionEnd(int param1) {
        this.getObject().setSelectionEnd(param1);
        return this;
    }

    public STextArea document(Document param1) {
        this.getObject().setDocument(param1);
        return this;
    }

    public STextArea text(String param1) {
        this.getObject().setText(param1);
        return this;
    }

    public STextArea border(Border param1) {
        this.getObject().setBorder(param1);
        return this;
    }

    public STextArea alignmentY(float param1) {
        this.getObject().setAlignmentY(param1);
        return this;
    }

    public STextArea alignmentX(float param1) {
        this.getObject().setAlignmentX(param1);
        return this;
    }

    public STextArea inputVerifier(InputVerifier param1) {
        this.getObject().setInputVerifier(param1);
        return this;
    }

    public STextArea toolTipText(String param1) {
        this.getObject().setToolTipText(param1);
        return this;
    }

    public STextArea visible(boolean param1) {
        this.getObject().setVisible(param1);
        return this;
    }

    public STextArea preferredSize(Dimension param1) {
        this.getObject().setPreferredSize(param1);
        return this;
    }

    public STextArea maximumSize(Dimension param1) {
        this.getObject().setMaximumSize(param1);
        return this;
    }

    public STextArea minimumSize(Dimension param1) {
        this.getObject().setMinimumSize(param1);
        return this;
    }

    public STextArea enabled(boolean param1) {
        this.getObject().setEnabled(param1);
        return this;
    }

    public STextArea foreground(Color param1) {
        this.getObject().setForeground(param1);
        return this;
    }

    public STextArea background(Color param1) {
        this.getObject().setBackground(param1);
        return this;
    }

    public STextArea opaque(boolean param1) {
        this.getObject().setOpaque(param1);
        return this;
    }

    public STextArea bounds(int param1, int param2, int param3, int param4) {
        this.getObject().setBounds(param1, param2, param3, param4);
        return this;
    }

    public STextArea bounds(Rectangle param1) {
        this.getObject().setBounds(param1);
        return this;
    }

    public STextArea location(Point param1) {
        this.getObject().setLocation(param1);
        return this;
    }

    public STextArea location(int param1, int param2) {
        this.getObject().setLocation(param1, param2);
        return this;
    }

    public STextArea dropTarget(DropTarget param1) {
        this.getObject().setDropTarget(param1);
        return this;
    }

    public STextArea cursor(Cursor param1) {
        this.getObject().setCursor(param1);
        return this;
    }

    public STextArea focusable(boolean param1) {
        this.getObject().setFocusable(param1);
        return this;
    }

    public STextArea size(int param1, int param2) {
        this.getObject().setSize(param1, param2);
        return this;
    }

    public STextArea size(Dimension param1) {
        this.getObject().setSize(param1);
        return this;
    }

    public STextArea name(String param1) {
        this.getObject().setName(param1);
        return this;
    }


}
