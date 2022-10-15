package io.d2a.swag.builder.components.text;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Constructor;
import java.util.function.Consumer;

public class TextArea extends TextFieldWrapper<JTextArea> {

    public TextArea() {
        super(new JTextArea());
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

}
