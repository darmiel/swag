package io.d2a.swag;

import java.awt.*;

public interface ComponentBuilder<T extends Component> {

    T build();

}
