package io.d2a.swag.components;

import io.d2a.swag.layouts.Box;
import io.d2a.swag.layouts.Flow;

import javax.swing.*;
import java.awt.*;

public class LayoutBuilderTest {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(Box.vertical()
                .background(Color.YELLOW)
                .with(Flow.center()
                        .with(new JLabel("Header"))
                        .with(new JButton("Kni Kna Knopp"))
                        .background(Color.RED))
                .with(Box.horizontal()
                        .with(new JLabel("Uwu"))
                        .with(new JButton("Yes"))
                        .background(Color.BLUE)));
        frame.setSize(720, 480);
        frame.setVisible(true);
    }

}
