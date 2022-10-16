package io.d2a.ahpe.examples.radio;

import io.d2a.ahpe.AhpeMisc;
import io.d2a.ahpe.AhpeRandom;
import io.d2a.ahpe.examples.countdown.ChatMessagesComponent;
import io.d2a.swag.templates.SRadio;
import io.d2a.swag.layouts.SBorder;

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

    private final SRadio.RadioPanel<Status> statusPanel = SRadio.group(Status.values())
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
        this.add(SBorder.gap(5, 5)
                .top(this.statusPanel)
                .center(component)
                .padding(15));

        AhpeMisc.visible(this, 30, 0);
    }

    public static void main(String[] args) {
        new RadioExample();
    }

}
