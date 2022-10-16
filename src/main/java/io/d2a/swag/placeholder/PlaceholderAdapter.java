package io.d2a.swag.placeholder;

import javax.swing.text.JTextComponent;

public abstract class PlaceholderAdapter implements PlaceholderProvider {

    private final JTextComponent component;

    public PlaceholderAdapter(JTextComponent component) {
        this.component = component;
    }

    @Override
    public String getText() {
        return this.component.getText();
    }

    @Override
    public void setText(String newText) {
        this.component.setText(newText);
    }

}
