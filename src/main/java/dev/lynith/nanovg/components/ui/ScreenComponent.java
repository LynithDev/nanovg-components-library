package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.ui.widgets.panels.AbstractPanel;
import dev.lynith.nanovg.components.ui.widgets.panels.Panel;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public abstract class ScreenComponent extends Component {

    public ScreenComponent(Component root) {
        setParent(root);
    }

    @Getter @Setter
    private AbstractPanel<Panel> panel = new Panel();

    public ScreenComponent() {
        setParent(new ScreenWrapper());
        setBounds(getParent().getBounds());
    }

    public void onClose() {}
    public void onResize(int width, int height) {
        setBounds(getParent().getBounds());
        getPanel().setBounds(getBounds());
    }

    @Override
    public void init() {
        super.init();
        panel.setParent(this);
        panel.init();
    }

    @Override
    public void onThemeChange() {
        super.onThemeChange();
        panel.onThemeChange();
    }

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);
        panel.render(mouseBounds);
    }

    @Override
    public void onClick(PointBounds mouseBounds, int button) {
        super.onClick(mouseBounds, button);
        panel.onClick(mouseBounds, button);
    }

    @Override
    public void onRelease(PointBounds mouseBounds, int state) {
        super.onRelease(mouseBounds, state);
        panel.onRelease(mouseBounds, state);
    }

    @Override
    public void onKeyTyped(char typedChar, int keyCode) {
        super.onKeyTyped(typedChar, keyCode);
        panel.onKeyTyped(typedChar, keyCode);
    }
}
