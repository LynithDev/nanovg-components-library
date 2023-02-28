package dev.lynith.nanovg.components.ui.layouts.impl;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.ui.styles.impl.LayoutDirection;
import dev.lynith.nanovg.components.utils.PointBounds;

import java.util.List;

public class AbsoluteLayout extends AbstractLayout {

    public AbsoluteLayout(Component parent) {
        super(parent);
    }

    public AbsoluteLayout(Component parent, LayoutDirection direction) {
        super(parent, direction);
    }

    @Override
    public void render(PointBounds mouseBounds, List<Component> children) {
        for (Component child : children) {
            child.render(mouseBounds);
        }
    }
}
