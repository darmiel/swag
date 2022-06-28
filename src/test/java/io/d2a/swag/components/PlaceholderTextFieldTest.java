package io.d2a.swag.components;

import javax.swing.*;

public class PlaceholderTextFieldTest {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new PlaceholderTextField("User"));
        panel.add(new PlaceholderTextField("Password"));
        panel.add(new PlaceholderTextField("E-Mail"));
        frame.add(panel);
        frame.setSize(720, 480);
        frame.setVisible(true);
    }

}
