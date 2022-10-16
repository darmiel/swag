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

public class TextArea extends TextFieldWrapper<JTextArea> {

    public TextArea() {
        super(new JTextArea());
    }

    public TextArea(final int rows, final int cols) {
        super(new JTextArea(rows, cols));
    }

    public TextArea(final String text) {
        super(new JTextArea(text));
    }

    public TextArea key(final int keyCode, final Runnable runnable) {
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

    public TextArea enter(final Runnable runnable) {
        return this.key(KeyEvent.VK_ENTER, runnable);
    }

    public TextArea raw(final Consumer<JTextArea> ta) {
        ta.accept(this.getObject());
        return this;
    }

    @Override
    public JTextArea build() {
        return super.getObject();
    }


    /// AUTO GENERATED

    public TextArea font(Font param1) {
        this.getObject().setFont(param1);
        return this;
    }

    public TextArea tabSize(int param1) {
        this.getObject().setTabSize(param1);
        return this;
    }

    public TextArea rows(int param1) {
        this.getObject().setRows(param1);
        return this;
    }

    public TextArea columns(int param1) {
        this.getObject().setColumns(param1);
        return this;
    }

    public TextArea editable(boolean param1) {
        this.getObject().setEditable(param1);
        return this;
    }

    public TextArea dragEnabled(boolean param1) {
        this.getObject().setDragEnabled(param1);
        return this;
    }

    public TextArea caretPosition(int param1) {
        this.getObject().setCaretPosition(param1);
        return this;
    }

    public TextArea caret(Caret param1) {
        this.getObject().setCaret(param1);
        return this;
    }

    public TextArea margin(Insets param1) {
        this.getObject().setMargin(param1);
        return this;
    }

    public TextArea highlighter(Highlighter param1) {
        this.getObject().setHighlighter(param1);
        return this;
    }

    public TextArea keymap(Keymap param1) {
        this.getObject().setKeymap(param1);
        return this;
    }

    public TextArea dropMode(DropMode param1) {
        this.getObject().setDropMode(param1);
        return this;
    }

    public TextArea caretColor(Color param1) {
        this.getObject().setCaretColor(param1);
        return this;
    }

    public TextArea selectionColor(Color param1) {
        this.getObject().setSelectionColor(param1);
        return this;
    }

    public TextArea selectedTextColor(Color param1) {
        this.getObject().setSelectedTextColor(param1);
        return this;
    }

    public TextArea disabledTextColor(Color param1) {
        this.getObject().setDisabledTextColor(param1);
        return this;
    }

    public TextArea selectionStart(int param1) {
        this.getObject().setSelectionStart(param1);
        return this;
    }

    public TextArea selectionEnd(int param1) {
        this.getObject().setSelectionEnd(param1);
        return this;
    }

    public TextArea document(Document param1) {
        this.getObject().setDocument(param1);
        return this;
    }

    public TextArea text(String param1) {
        this.getObject().setText(param1);
        return this;
    }

    public TextArea border(Border param1) {
        this.getObject().setBorder(param1);
        return this;
    }

    public TextArea alignmentY(float param1) {
        this.getObject().setAlignmentY(param1);
        return this;
    }

    public TextArea alignmentX(float param1) {
        this.getObject().setAlignmentX(param1);
        return this;
    }

    public TextArea inputVerifier(InputVerifier param1) {
        this.getObject().setInputVerifier(param1);
        return this;
    }

    public TextArea toolTipText(String param1) {
        this.getObject().setToolTipText(param1);
        return this;
    }

    public TextArea visible(boolean param1) {
        this.getObject().setVisible(param1);
        return this;
    }

    public TextArea preferredSize(Dimension param1) {
        this.getObject().setPreferredSize(param1);
        return this;
    }

    public TextArea maximumSize(Dimension param1) {
        this.getObject().setMaximumSize(param1);
        return this;
    }

    public TextArea minimumSize(Dimension param1) {
        this.getObject().setMinimumSize(param1);
        return this;
    }

    public TextArea enabled(boolean param1) {
        this.getObject().setEnabled(param1);
        return this;
    }

    public TextArea foreground(Color param1) {
        this.getObject().setForeground(param1);
        return this;
    }

    public TextArea background(Color param1) {
        this.getObject().setBackground(param1);
        return this;
    }

    public TextArea opaque(boolean param1) {
        this.getObject().setOpaque(param1);
        return this;
    }

    public TextArea bounds(int param1, int param2, int param3, int param4) {
        this.getObject().setBounds(param1, param2, param3, param4);
        return this;
    }

    public TextArea bounds(Rectangle param1) {
        this.getObject().setBounds(param1);
        return this;
    }

    public TextArea location(Point param1) {
        this.getObject().setLocation(param1);
        return this;
    }

    public TextArea location(int param1, int param2) {
        this.getObject().setLocation(param1, param2);
        return this;
    }

    public TextArea dropTarget(DropTarget param1) {
        this.getObject().setDropTarget(param1);
        return this;
    }

    public TextArea cursor(Cursor param1) {
        this.getObject().setCursor(param1);
        return this;
    }

    public TextArea focusable(boolean param1) {
        this.getObject().setFocusable(param1);
        return this;
    }

    public TextArea size(int param1, int param2) {
        this.getObject().setSize(param1, param2);
        return this;
    }

    public TextArea size(Dimension param1) {
        this.getObject().setSize(param1);
        return this;
    }

    public TextArea name(String param1) {
        this.getObject().setName(param1);
        return this;
    }


}
