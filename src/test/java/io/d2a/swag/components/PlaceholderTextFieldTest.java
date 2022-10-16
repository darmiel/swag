package io.d2a.swag.components;

import io.d2a.swag.placeholder.Placeholder;

import javax.swing.*;

public class PlaceholderTextFieldTest {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Placeholder.extend("User", new JTextField()));
        panel.add(Placeholder.extend("Password", new JPasswordField()));
        panel.add(Placeholder.extend("E-Mail", new JTextArea()));
        frame.add(panel);
        frame.setSize(720, 480);
        frame.setVisible(true);
    }

}
