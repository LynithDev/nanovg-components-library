package dev.lynith.nanovg.components.ui.widgets.panels;

import dev.lynith.nanovg.components.exceptions.ParentException;
import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.ui.layouts.Layouts;
import dev.lynith.nanovg.components.ui.layouts.impl.AbsoluteLayout;
import dev.lynith.nanovg.components.ui.layouts.impl.StackLayout;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbstractPanel<T extends AbstractPanel<?>> extends Component {

    @Getter
    private final List<Component> children = new ArrayList<>();

    @Getter
    private AbstractLayout layout = new AbsoluteLayout(this);

    public AbstractPanel() {

    }

    public AbstractPanel(Layouts layout) {
        setLayout(layout);
    }

    public void setLayout(AbstractLayout layout) {
        this.layout = layout;
    }

    public void setLayout(Layouts layout) {
        try {
            this.layout = layout.getLayoutClass().getConstructor(Component.class).newInstance(this);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public T add(Component... component) {
        for (Component child : component) {
            try {
                if (child.getParent() != null) {
                    throw new ParentException();
                }
                child.setParent(this);
                children.add(child);
                child.init();
            } catch (ParentException e) {
                e.printStackTrace();
            }
        }
        return (T) this;
    }

    public T add(List<Component> component) {
        add(component.toArray(new Component[0]));
        return (T) this;
    }

    public T remove(Component... component) {
        children.removeAll(Arrays.asList(component));
        return (T) this;
    }

    public T remove(List<Component> component) {
        children.removeAll(component);
        return (T) this;
    }

    public T clear() {
        children.clear();
        return (T) this;
    }

    public T set(List<Component> component) {
        children.clear();
        for (Component child : component) {
            child.setParent(this);
            children.add(child);
            child.init();
        }
        return (T) this;
    }

    public T set(Component... component) {
        children.clear();
        for (Component child : component) {
            child.setParent(this);
            children.add(child);
            child.init();
        }
        return (T) this;
    }

    public Component get(int index) {
        return children.get(index);
    }

    public Component get(Component component) {
        return children.get(children.indexOf(component));
    }

    @Override
    public void onClick(PointBounds mouseBounds, int mouseButton) {
        super.onClick(mouseBounds, mouseButton);

        for (Component child : children) {
            if (mouseBounds.inside(child.getBounds())) {
                child.onClick(mouseBounds, mouseButton);
            }
        }
    }

    @Override
    public void onThemeChange() {
        super.onThemeChange();

        for (Component child : children) {
            child.onThemeChange();
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

        getLayout().render(mouseBounds, children);
    }

    @Override
    public void init() {
        super.init();

        for (Component child : children) {
            child.init();
        }
    }

}
