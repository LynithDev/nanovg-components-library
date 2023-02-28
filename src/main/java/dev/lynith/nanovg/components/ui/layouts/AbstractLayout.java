package dev.lynith.nanovg.components.ui.layouts;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.styles.impl.LayoutDirection;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractLayout {

    @Getter
    private final Component parent;

    @Getter @Setter
    private LayoutDirection direction = LayoutDirection.VERTICAL;

    public AbstractLayout(Component parent) {
        this.parent = parent;
    }

    public AbstractLayout(Component parent, LayoutDirection direction) {
        this(parent);
        this.direction = direction;
    }

    public abstract void render(PointBounds mouseBounds, List<Component> children);

}
