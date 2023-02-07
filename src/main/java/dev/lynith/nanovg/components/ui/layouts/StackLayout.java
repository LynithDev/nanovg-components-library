package dev.lynith.nanovg.components.ui.layouts;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.utils.PointBounds;

public class StackLayout extends AbstractLayout {

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);

        for (int i = 0; i < getChildren().size(); i++) {
            Component child = getChildren().get(i);
            child.setBounds(getLeft(), getTop() + i * child.getHeight(), getWidth(), child.getHeight());
        }
    }

}
