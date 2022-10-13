package io.d2a.swag.builder.components.text;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextField extends TextFieldWrapper<JTextField> {

    public TextField() {
        super(new JTextField());
    }

    public TextField(final String text) {
        super(new JTextField(text));
    }

    public TextField key(final int keyCode, final Runnable runnable) {
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

    public TextField enter(final Runnable runnable) {
        return this.key(KeyEvent.VK_ENTER, runnable);
    }

    @Override
    public JTextField build() {
        return super.getObject();
    }

}
