package dev.lynith.nanovg.components.ui.layouts.impl;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.utils.PointBounds;

public class StackLayout extends AbstractLayout {

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);

        float y = getTop();

        for (int i = 0; i < getChildren().size(); i++) {
            Component child = getChildren().get(i);
            child.setBounds(getLeft() + child.getStyle().getBorder().getWidth(), y + child.getStyle().getBorder().getWidth(), getWidth() == 0 ? child.getWidth() : getWidth(), child.getHeight());
            y += child.getOuterHeight();
        }
    }

}
