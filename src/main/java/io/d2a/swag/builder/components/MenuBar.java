package io.d2a.swag.builder.components;

import java.util.stream.Collectors;

/*
    MenuBar.builder()
        .with(Menu.builder("File")
            .with(Item.builder("New").handle(this::handleNew))
            .with(Item.builder("Close").handle(this::handleClose))
        .with(Menu.builder("Help")
            .with(Item.builder("About").click(this::handleAbout))
        .addTo(this)
        .registerHandlers(this);

    @Menu.Handler("File > New")
    @Menu.Handler("File > {action}")
    private void handleAction(@Menu.Placeholder("action") "final String action") {
        // ...
    }

    @Menu.Handler("File")
    public class FileMenuHandler {
      @Menu.Handler("New")
      public void handleNew() {
          // ...
      }
      @Menu.Handler("Close")
      public void handleClose() {
          // ...
      }
    }
 */
public class MenuBar {


}
