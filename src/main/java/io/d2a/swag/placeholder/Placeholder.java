package io.d2a.swag.placeholder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Placeholder implements FocusListener {

    /**
     * Indicates whether the placeholder is displayed
     */
    private boolean showPlaceholder = false;

    /**
     * Placeholder to show when no text is entered and focus is lost
     */
    private String placeholderMessage;

    private final PlaceholderProvider provider;
    private final PlaceholderCallback callback;

    public Placeholder(final String message, final PlaceholderProvider provider, final PlaceholderCallback callback) {
        this.provider = provider;
        this.callback = callback;

        this.placeholderMessage = message;
        this.showPlaceholder();
    }

    /// FocusListener

    @Override
    public void focusGained(FocusEvent e) {
        if (this.showPlaceholder) {
            this.hidePlaceholder();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (!this.showPlaceholder && this.provider.getText().isEmpty()) {
            this.showPlaceholder();
        }
    }

    /// Placeholder Toggle

    private void hidePlaceholder() {
        this.provider.setText("");

        final int style = this.provider.getFont().getStyle() & ~Font.ITALIC;
        this.provider.setFont(this.provider.getFont().deriveFont(style));
        this.provider.setForeground(Color.BLACK);

        this.showPlaceholder = false;
        this.callback.onHidePlaceholder();
    }

    private void showPlaceholder() {
        this.provider.setText(Placeholder.this.placeholderMessage);

        final int style = this.provider.getFont().getStyle() | Font.ITALIC;
        this.provider.setFont(this.provider.getFont().deriveFont(style));
        this.provider.setForeground(Color.GRAY);

        this.showPlaceholder = true;
        this.callback.onShowPlaceholder();
    }

    /// Setters

    public void setPlaceholderMessage(String placeholderMessage) {
        this.placeholderMessage = placeholderMessage;
    }

    public static FocusListener createListener(
            final String message,
            final JTextField textField,
            final PlaceholderCallback callback
    ) {
        return new Placeholder(
                message,
                new PlaceholderAdapter(textField) {
                    @Override
                    public void setForeground(Color color) {
                        textField.setForeground(color);
                    }

                    @Override
                    public Font getFont() {
                        return textField.getFont();
                    }

                    @Override
                    public void setFont(Font font) {
                        textField.setFont(font);
                    }
                },
                callback
        );
    }

    public static JTextField extend(final String message, final JTextField textField) {
        textField.addFocusListener(createListener(message, textField, PlaceholderCallback.dummy()));
        return textField;
    }

    public static FocusListener createListener(
            final String message,
            final JTextArea area,
            final PlaceholderCallback callback
    ) {
        return new Placeholder(
                message,
                new PlaceholderAdapter(area) {
                    @Override
                    public void setForeground(Color color) {
                        area.setForeground(color);
                    }

                    @Override
                    public Font getFont() {
                        return area.getFont();
                    }

                    @Override
                    public void setFont(Font font) {
                        area.setFont(font);
                    }
                },
                callback
        );
    }


    public static JTextArea extend(final String message, final JTextArea textArea) {
        textArea.addFocusListener(createListener(message, textArea, PlaceholderCallback.dummy()));
        return textArea;
    }

    public static JPasswordField extend(final String message, final JPasswordField passwordField) {
        // get echo char
        final AtomicInteger echo = new AtomicInteger('*');
        passwordField.addFocusListener(createListener(message, passwordField, new PlaceholderCallback() {
            @Override
            public void onShowPlaceholder() {
                echo.set(passwordField.getEchoChar());
                passwordField.setEchoChar((char) 0);
            }

            @Override
            public void onHidePlaceholder() {
                passwordField.setEchoChar((char) echo.get());
            }
        }));
        return passwordField;
    }

}
