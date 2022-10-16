package io.d2a.ahpe.examples.radio;

import io.d2a.ahpe.AhpeDialog;
import io.d2a.ahpe.AhpeMisc;
import io.d2a.ahpe.AhpeRandom;
import io.d2a.ahpe.examples.countdown.ChatMessagesComponent;
import io.d2a.swag.builder.components.Radio;
import io.d2a.swag.builder.layouts.Border;
import io.d2a.swag.builder.layouts.Grid;
import io.d2a.swag.components.placeholder.Placeholder;

import javax.swing.*;
import java.awt.*;

public class RadioExample extends JFrame {

    // enum of some states
    public enum Status {
        ONLINE("Online"),
        OFFLINE("Offline"),
        BRB("Be right Back!");

        private final String nice;

        Status(final String nice) {
            this.nice = nice;
        }

        // NOTE:
        // The `toString()`-method defines the text displayed by the radio buttons
        @Override
        public String toString() {
            return this.nice;
        }
    }

    final ChatMessagesComponent component = new ChatMessagesComponent();

    private final Radio.RadioPanel<Status> statusPanel = Radio.group(Status.values())
            .select(Status.ONLINE)
            .onChange(this::handleStatusChange)
            .asPanel();

    private void handleStatusChange(final Status newStatus) {
        // remove color from all radio buttons
        for (final JRadioButton button : this.statusPanel.getButtons()) {
            button.setForeground(Color.BLACK);
        }
        // add color to selected
        this.statusPanel.getButton(newStatus).setForeground(AhpeRandom.randomColor());
        // add status message to ChatMessagesComponent
        component.add(new JLabel("Status: " + newStatus));
    }

    public RadioExample() throws HeadlessException {
        this.add(Border.padding(5, 5)
                .top(this.statusPanel)
                .center(component));

        AhpeMisc.visible(this);
    }

    public static void main(String[] args) {
        new RadioExample();
    }

}
