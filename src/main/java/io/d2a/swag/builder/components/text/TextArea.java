package io.d2a.swag.builder.components.text;

import javax.swing.*;

public class TextArea extends TextFieldWrapper<JTextArea> {

    public TextArea() {
        super(new JTextArea());
    }

    public TextArea(final String text) {
        super(new JTextArea(text));
    }

    @Override
    public JTextArea build() {
        return super.getObject();
    }

}
