package io.d2a.swag.builder;

import java.awt.*;

public interface ComponentBuilder<T extends Component> {

    T build();

}
