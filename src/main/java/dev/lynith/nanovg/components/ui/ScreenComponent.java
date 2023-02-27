package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.ui.layouts.impl.StackLayout;
import dev.lynith.nanovg.components.ui.styles.ComponentStyle;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public abstract class ScreenComponent extends Component {

    public ScreenComponent(Component root) {
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
//        setStyleBase(ThemeManager.getManager().getCurrentTheme().getScreenStyle());

        if (layout != null)
            layout.init();
    }

    @Override
    public void onThemeChange() {
        super.onThemeChange();
//        setStyle(ThemeManager.getManager().getCurrentTheme().getScreenStyle());

        if (layout != null)
            layout.onThemeChange();
    }

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);

        if (layout != null)
            layout.render(mouseBounds);
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
