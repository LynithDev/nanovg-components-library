package dev.lynith.nanovg.components.ui.layouts;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.utils.PointBounds;

public class StackLayout extends AbstractLayout {

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);

        float y = getTop();

        for (int i = 0; i < getChildren().size(); i++) {
            Component child = getChildren().get(i);
            child.setBounds(getLeft() + child.getBorderWidth(), y + child.getBorderWidth(), getWidth() == 0 ? child.getWidth() : getWidth(), child.getHeight());
            y += child.getOuterHeight();
        }
    }

}
