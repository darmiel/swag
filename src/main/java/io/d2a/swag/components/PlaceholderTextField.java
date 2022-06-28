package io.d2a.swag.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlaceholderTextField extends JTextField implements FocusListener {

    /**
     * Indicates whether the placeholder is displayed
     */
    private boolean showPlaceholder = false;

    /**
     * Placeholder to show when no text is entered and focus is lost
     */
    private String placeholderMessage;

    public PlaceholderTextField(final String message) {
        this.placeholderMessage = message;
        this.addFocusListener(this);
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
        if (!this.showPlaceholder && this.getText().isEmpty()) {
            this.showPlaceholder();
        }
    }

    /// Placeholder Toggle

    private void hidePlaceholder() {
        PlaceholderTextField.this.setText("");

        final int style = PlaceholderTextField.this.getFont().getStyle() & ~Font.ITALIC;
        PlaceholderTextField.this.setFont(PlaceholderTextField.this.getFont().deriveFont(style));
        PlaceholderTextField.this.setForeground(Color.BLACK);

        PlaceholderTextField.this.showPlaceholder = false;
    }

    private void showPlaceholder() {
        PlaceholderTextField.this.setText(PlaceholderTextField.this.placeholderMessage);

        final int style = PlaceholderTextField.this.getFont().getStyle() | Font.ITALIC;
        PlaceholderTextField.this.setFont(PlaceholderTextField.this.getFont().deriveFont(style));
        PlaceholderTextField.this.setForeground(Color.GRAY);

        PlaceholderTextField.this.showPlaceholder = true;
    }

    /// Setters

    public void setPlaceholderMessage(String placeholderMessage) {
        this.placeholderMessage = placeholderMessage;
    }

}
