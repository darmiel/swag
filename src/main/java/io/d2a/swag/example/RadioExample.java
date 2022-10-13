package io.d2a.swag.example;

import io.d2a.swag.builder.components.Radio;
import io.d2a.swag.builder.layouts.Flow;
import io.d2a.swag.templates.Header;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class RadioExample extends JFrame {

    enum Status {
        ONLINE("Online"),
        OFFLINE("Offline"),
        BRB("Be right Back!");

        final String nice;
        Status(final String nice) {
            this.nice = nice;
        }

        @Override
        public String toString() {
            return this.nice;
        }
    }

    public RadioExample() throws HeadlessException {
        final JPanel buttonPanel = new JPanel(); {
            final BoxLayout layout = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
            buttonPanel.setLayout(layout);
        }

        final JPanel mainPanel = new JPanel(); {
            final BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
            mainPanel.setLayout(layout);
        }

        final JLabel selected = new JLabel();
        final Consumer<Status> changeState = status -> selected.setText("Status: " + status);
        changeState.accept(Status.ONLINE);

        mainPanel.add(Flow.center().with(selected));
        mainPanel.add(Flow.center().with(Header.of("Select Status")));
        buttonPanel.add(Radio.group(Status.values()).onChange(changeState).asPanel());

        mainPanel.add(buttonPanel);
        this.add(mainPanel);
        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        new RadioExample();
    }

}
