package dev.lynith.nanovg.components.ui.layouts;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractLayout extends Component<LayoutStyles> {

    @Getter
    private final List<Component<?>> children = new ArrayList<>();

    public AbstractLayout() {
        super(new LayoutStyles());
    }

    public void add(Component<?>... component) {
        children.addAll(Arrays.asList(component));
    }

    @Override
    public void onClick(PointBounds mouseBounds, int mouseButton) {
        super.onClick(mouseBounds, mouseButton);

        for (Component<?> child : children) {
            if (mouseBounds.inside(child.getBounds())) {
                child.onClick(mouseBounds, mouseButton);
            }
        }
    }

    @Override
    public void onRelease(PointBounds mouseBounds, int state) {
        super.onRelease(mouseBounds, state);

        for (Component<?> child : children) {
            child.onRelease(mouseBounds, state);
        }
    }

    @Override
    public void onKeyTyped(char typedChar, int keyCode) {
        super.onKeyTyped(typedChar, keyCode);

        for (Component<?> child : children) {
            child.onKeyTyped(typedChar, keyCode);
        }
    }

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);

        for (Component<?> child : children) {
            child.render(mouseBounds);
        }
    }

    @Override
    public void init() {
        super.init();

        for (Component<?> child : children) {
            child.init();
        }
    }

    @Override
    public void onThemeUpdate() {
        super.onThemeUpdate();

        for (Component<?> child : children) {
            child.onThemeUpdate();
        }
    }

}
