package dev.lynith.nanovg.components.ui.layouts;

import dev.lynith.nanovg.components.ui.layouts.impl.StackLayout;
import lombok.Getter;

public enum Layouts {

    STACK(StackLayout.class),
    GRID(null),
    CONSTRAINT(null);

    @Getter
    private Class<? extends AbstractLayout> layoutClass;
    Layouts(Class<? extends AbstractLayout> layoutClass) {
        this.layoutClass = layoutClass;
    }

}
