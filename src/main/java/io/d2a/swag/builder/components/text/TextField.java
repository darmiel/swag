package io.d2a.swag.builder.components.text;

import javax.swing.*;

public class TextField extends TextFieldWrapper<JTextField> {

    public TextField() {
        super(new JTextField());
    }

    public TextField(final String text) {
        super(new JTextField(text));
    }

    @Override
    public JTextField build() {
        return super.getObject();
    }

}
