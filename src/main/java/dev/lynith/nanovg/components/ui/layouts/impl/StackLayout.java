package dev.lynith.nanovg.components.ui.layouts.impl;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.ui.widgets.Label;
import dev.lynith.nanovg.components.utils.PointBounds;

import java.util.List;

public class StackLayout extends AbstractLayout {

    public StackLayout(Component parent) {
        super(parent);
    }

    @Override
    public void render(PointBounds mouseBounds, List<Component> children) {
        switch (getDirection()) {
            case VERTICAL:
                renderVertical(mouseBounds, children, false);
                break;
            case HORIZONTAL:
                renderHorizontal(mouseBounds, children, false);
                break;
            case REVERSE_VERTICAL:
                renderVertical(mouseBounds, children, true);
                break;
            case REVERSE_HORIZONTAL:
                renderHorizontal(mouseBounds, children, true);
                break;
        }
    }

    private void renderVertical(PointBounds mouseBounds, List<Component> children, boolean reverse) {
        int prevHeight = 0;
        for (Component child : children) {
            child.setBounds(
                getParent().getBounds().getLeft(),
                reverse ? getParent().getBounds().getBottom() - prevHeight : getParent().getBounds().getTop() + prevHeight,
                getParent().getBounds().getWidth(),
                child.getBounds().getHeight()
            );
            prevHeight += child.getBounds().getHeight();
            child.render(mouseBounds);
        }
    }

    private void renderHorizontal(PointBounds mouseBounds, List<Component> children, boolean reverse) {

    }

}
