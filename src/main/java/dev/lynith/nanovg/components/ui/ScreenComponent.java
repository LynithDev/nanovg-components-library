package dev.lynith.nanovg.components.ui;

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
    private AbstractPanel<Panel> rootPanel = new Panel();

    public ScreenComponent() {

    }

    public void onClose() {}
    public void onResize(int width, int height) {
        setBounds(getParent().getBounds());
        getRootPanel().setBounds(getBounds());
    }

    @Override
    public void init() {
        super.init();
        setParent(new ScreenWrapper());
        setBounds(getParent().getBounds());
        rootPanel.setParent(this);
        rootPanel.setBounds(getBounds());
        rootPanel.init();
    }

    @Override
    public void onThemeChange() {
        super.onThemeChange();
        rootPanel.onThemeChange();
    }

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);
        rootPanel.render(mouseBounds);
    }

    @Override
    public void onClick(PointBounds mouseBounds, int button) {
        super.onClick(mouseBounds, button);
        rootPanel.onClick(mouseBounds, button);
    }

    @Override
    public void onRelease(PointBounds mouseBounds, int state) {
        super.onRelease(mouseBounds, state);
        rootPanel.onRelease(mouseBounds, state);
    }

    @Override
    public void onKeyTyped(char typedChar, int keyCode) {
        super.onKeyTyped(typedChar, keyCode);
        rootPanel.onKeyTyped(typedChar, keyCode);
    }
}
