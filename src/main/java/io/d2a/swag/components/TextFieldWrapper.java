package io.d2a.swag.components;

import io.d2a.swag.ComponentBuilder;

import javax.swing.text.JTextComponent;
import java.util.function.Supplier;

public abstract class TextFieldWrapper<T extends JTextComponent> implements ComponentBuilder<T> {

    private final T object;

    public T getObject() {
        return object;
    }

    public TextFieldWrapper(T object) {
        this.object = object;
    }

    public void clear() {
        this.object.setText("");
    }

    public <K> K wrapNumberFormatException(final Supplier<K> supplier, final K def) {
        try {
            return supplier.get();
        } catch (final NumberFormatException nfex) {
            if (def != null) {
                return def;
            }
            throw nfex; // rethrow
        }
    }

    ///

    public int asInt() {
        return this.asInt(null);
    }

    public int asInt(final Integer def) {
        return this.wrapNumberFormatException(() -> Integer.parseInt(this.asString()), def);
    }

    public double asDouble() {
        return this.asDouble(null);
    }

    public double asDouble(final Double def) {
        return this.wrapNumberFormatException(() -> Double.parseDouble(this.asString()), def);
    }

    public String asString() {
        return this.object.getText();
    }

    public TextFieldWrapper<T> text(final String newText) {
        this.object.setText(newText);
        return this;
    }

}
