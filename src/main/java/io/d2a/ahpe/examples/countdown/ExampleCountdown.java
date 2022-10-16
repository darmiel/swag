package io.d2a.ahpe.examples.countdown;

import io.d2a.ahpe.AhpeMisc;
import io.d2a.ahpe.AhpeRandom;
import io.d2a.ahpe.AhpeThread;
import io.d2a.swag.builder.components.Button;
import io.d2a.swag.builder.components.text.TextField;
import io.d2a.swag.builder.layouts.Border;
import io.d2a.swag.builder.layouts.Box;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ExampleCountdown extends JFrame {

    public static void main(String[] args) {
        new ExampleCountdown();
    }

    // Components
    private final ChatMessagesComponent component = new ChatMessagesComponent();

    private final JTextField textField = new TextField(20)
            .enter(this::sendMessage)
            .build();

    private final JLabel timeLabel = new JLabel("Uhrzeit");

    // Sends a message
    private void sendMessage() {
        // get text to send
        final String text = "You: " + this.textField.getText();

        // create label to show in messages component
        final JLabel label = new JLabel(text);
        // give label random color
        label.setForeground(AhpeRandom.randomColor());
        // add label to ChatMessagesComponent
        this.component.add(label);

        // delete message after 10 seconds and show remaining time behind message
        AhpeThread.countdown(10,
                // show remaining time behind message
                remaining -> label.setText(String.format("%s [%-10s]", text,
                        AhpeMisc.repeat("#", 10L - remaining))),
                // remove message after countdown ended
                () -> this.component.remove(label));

        // clear chat box
        this.textField.setText("");
        // focus chat box
        this.textField.requestFocus();
    }

    public ExampleCountdown() throws HeadlessException {
        // add components
        this.add(Border.padding(5, 5)
                .top(this.timeLabel)
                .center(this.component)
                .bottom(Box.horizontal()
                        .with(this.textField)
                        .with(new Button("Senden")
                                .click((event) -> this.sendMessage()))));

        // updated time every second
        AhpeThread.everySecond(() -> this.timeLabel.setText(new Date().toString()));

        AhpeMisc.visible(this);
    }

}
