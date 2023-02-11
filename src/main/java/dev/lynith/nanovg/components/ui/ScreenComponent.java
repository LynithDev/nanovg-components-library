package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.theme.ThemeManager;
import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.ui.layouts.impl.StackLayout;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public abstract class ScreenComponent extends Component<ComponentStyle> {

    public ScreenComponent(Component<ComponentStyle> root) {
        setParent(root);
    }

    @Getter @Setter
    private AbstractLayout layout = new StackLayout();

    public ScreenComponent() {
        setParent(new ScreenWrapper());
        setBounds(getParent().getBounds());
    }

    public void onClose() {}
    public void onResize(int width, int height) {
        setBounds(getParent().getBounds());
    }

    @Override
    public void init() {
        super.init();

        setStyle(ThemeManager.getManager().getCurrentTheme().getScreenStyle());

        if (layout != null)
            layout.init();
    }

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);

        if (layout != null)
            layout.render(mouseBounds);
    }

    @Override
    public void onThemeUpdate() {
        super.onThemeUpdate();
        setStyle(ThemeManager.getManager().getCurrentTheme().getScreenStyle()); // For some reason, the style is not updated for the screen component

        if (layout != null)
            layout.onThemeUpdate();
    }

    @Override
    public void onClick(PointBounds mouseBounds, int button) {
        super.onClick(mouseBounds, button);

        if (layout != null)
            layout.onClick(mouseBounds, button);
    }

    @Override
    public void onRelease(PointBounds mouseBounds, int state) {
        super.onRelease(mouseBounds, state);

        if (layout != null)
            layout.onRelease(mouseBounds, state);
    }

    @Override
    public void onKeyTyped(char typedChar, int keyCode) {
        super.onKeyTyped(typedChar, keyCode);

        if (layout != null)
            layout.onKeyTyped(typedChar, keyCode);
    }
}
