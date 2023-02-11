package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.theme.ThemeManager;
import dev.lynith.nanovg.components.utils.BoxBounds;
import dev.lynith.nanovg.components.utils.Color;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public abstract class Component<T extends ComponentStyle> extends NVGHelper {

    // --- Base ---

    public void render(PointBounds mouseBounds) {
        hovered = mouseBounds.inside(bounds);

        renderBackground();
        if (getStyle().hasBorder()) renderBorder();
    }

    public void onThemeUpdate() {
        setStyle(ThemeManager.getManager().getCurrentTheme().getComponentStyle(this));
    }

    public void init() {
        setStyle(ThemeManager.getManager().getCurrentTheme().getComponentStyle(this));
    }

    public void onClick(PointBounds mouseBounds, int button) {}
    public void onRelease(PointBounds mouseBounds, int state) {}
    public void onKeyTyped(char typedChar, int keyCode) {}

    public Component(T style) {
        this.style = style;
    }

    @SuppressWarnings("unchecked")
    public Component() {
        this((T) new ComponentStyle());
    }

    // --- Properties ---

    @Getter @Setter
    private Component<?> parent;

    @Getter @Setter
    private boolean hovered = false;

    @Getter @Setter
    private BoxBounds bounds = new BoxBounds();

    @Setter @Getter
    private T style;

    // --- Helpers ---

    public float getLeft() {
        return bounds.getLeft();
    }
    public float getTop() {
        return bounds.getTop();
    }
    public float getWidth() {
        return bounds.getWidth();
    }
    public float getHeight() {
        return bounds.getHeight();
    }

    public float getOuterLeft() { return getLeft() - getStyle().getMargin().getLeft(); }
    public float getOuterTop() { return getTop() - getStyle().getMargin().getTop(); }
    public float getOuterWidth() { return getWidth() + getStyle().getMargin().getLeft() + getStyle().getMargin().getRight(); }
    public float getOuterHeight() { return getHeight() + getStyle().getMargin().getTop() + getStyle().getMargin().getBottom(); }

    public float getInnerLeft() { return getLeft() + getStyle().getPadding().getLeft(); }
    public float getInnerTop() { return getTop() + getStyle().getPadding().getTop(); }
    public float getInnerWidth() { return getWidth() - getStyle().getPadding().getLeft() - getStyle().getPadding().getRight(); }
    public float getInnerHeight() { return getHeight() - getStyle().getPadding().getTop() - getStyle().getPadding().getBottom(); }

    public float getCenterX() { return getLeft() + getWidth() / 2; }
    public float getCenterY() { return getTop() + getHeight() / 2; }

    public void setBounds(float left, float top, float width, float height) {
        this.bounds.set(left, top, width, height);
    }

    // --- Other ---

    private void renderBorder() {
        drawRectRoundOutline(
                getLeft() - getStyle().getBorder().getWidth() / 2,
                getTop() - getStyle().getBorder().getWidth() / 2,
                getWidth() + getStyle().getBorder().getWidth(),
                getHeight() + getStyle().getBorder().getWidth(),
                getStyle().getBorder().getRadius(),
                getStyle().getBorder().getWidth(),
                getStyle().getBorder().getColor());
    }

    private void renderBackground() {
        drawRectRound(getLeft(), getTop(), getWidth(), getHeight(), getStyle().getBorder().getRadius(), getStyle().getBackgroundColor());
    }

}
