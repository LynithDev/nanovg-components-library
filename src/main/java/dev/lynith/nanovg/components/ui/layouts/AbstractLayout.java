package dev.lynith.nanovg.components.ui.layouts;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.styles.LayoutDirection;
import dev.lynith.nanovg.components.ui.styles.Overflow;
import dev.lynith.nanovg.components.ui.styles.Wrap;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractLayout extends Component {

    @Getter
    private final List<Component> children = new ArrayList<>();

    public void add(Component... component) {
        children.addAll(Arrays.asList(component));
    }

    @Override
    public void onClick(PointBounds mouseBounds, int mouseButton) {
        super.onClick(mouseBounds, mouseButton);

        for (Component child : children) {
            child.onClick(mouseBounds, mouseButton);
        }
    }

    @Override
    public void onRelease(PointBounds mouseBounds, int state) {
        super.onRelease(mouseBounds, state);

        for (Component child : children) {
            child.onRelease(mouseBounds, state);
        }
    }

    @Override
    public void onKeyTyped(char typedChar, int keyCode) {
        super.onKeyTyped(typedChar, keyCode);

        for (Component child : children) {
            child.onKeyTyped(typedChar, keyCode);
        }
    }

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);

        for (Component child : children) {
            child.render(mouseBounds);
        }
    }

    // --- Styles ---

    @Getter @Setter
    private LayoutDirection direction = LayoutDirection.VERTICAL;

    @Getter @Setter
    private Wrap wrap = Wrap.NO_WRAP;

    @Getter @Setter
    private Overflow overflow = Overflow.VISIBLE;

}
