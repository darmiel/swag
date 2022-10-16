package io.d2a.ahpe.examples.grid;

import io.d2a.ahpe.AhpeDialog;
import io.d2a.ahpe.AhpeMisc;
import io.d2a.swag.components.SButton;
import io.d2a.swag.layouts.SBorder;
import io.d2a.swag.layouts.SFlow;
import io.d2a.swag.layouts.SGrid;
import io.d2a.swag.templates.SHeader;

import javax.swing.*;
import java.awt.*;

public class ExampleGrid extends JFrame {

    public static void main(String[] args) {
        new ExampleGrid();
    }

    private final JLabel statusLabel = new JLabel("Letzte Aktion:");

    private final JButton fireButton = new SButton("Christian Feuern")
            .click((event) -> fire("Christian"))
            .build();

    private void fire(final String who) {
        final String status = who + " wurde gefeuert!";
        this.statusLabel.setText(status);
        this.fireButton.setEnabled(false);

        AhpeDialog.info(status);
    }

    public ExampleGrid() throws HeadlessException {
        this.setLayout(SFlow.center(10, 10).getLayout());

        this.add(SBorder.create()
                .top(SFlow.center(SHeader.of("Die Feuerstation")))
                .center(SGrid.builder()
                        .headers(4, "Name", "Position", "Aktionen")
                        .data("Simon", "Ausbildungsleiter", "Kann nicht gefeuert werden")
                        .data("Christian", "CEO", fireButton)
                        .data("Daniel", "VT", "Der kann auch nicht gefeuert werden")
                        .build())
                .bottom(this.statusLabel)
        );
        AhpeMisc.visible(this);
    }

}
