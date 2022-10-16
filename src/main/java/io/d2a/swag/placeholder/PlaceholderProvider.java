package io.d2a.swag.placeholder;

import java.awt.*;

public interface PlaceholderProvider {

    String getText();

    void setText(final String newText);

    void setForeground(final Color color);

    Font getFont();

    void setFont(final Font font);

}
