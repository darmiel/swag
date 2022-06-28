package io.d2a.swag.components;

import io.d2a.swag.builder.layouts.Grid;

import javax.swing.*;

public class GridBuilderTest {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.add(Grid.builder()
                .headers("Vorname", "Nachname", "Alter")
                .with("Tom", "Doil", 12)
                .with("Luca", "Hackl", "mag 14")
                .with("Jan", "👑", 55)
                .headers(3, "UwU", "OwO", "IwI")
                .with("Ja", "Nein", "Nicht")
                .build());
        frame.setVisible(true);
        frame.setSize(720, 480);
        frame.setVisible(true);
    }

}
