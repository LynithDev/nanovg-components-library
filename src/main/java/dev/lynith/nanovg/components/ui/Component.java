package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.theme.ThemeManager;
import dev.lynith.nanovg.components.ui.styles.ComponentStyle;
import dev.lynith.nanovg.components.utils.BoxBounds;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

public abstract class Component extends NVGHelper {

    // --- Base ---
    public void render(PointBounds mouseBounds) {
        hovered = mouseBounds.inside(bounds);

        renderBackground();
        if (getStyle().hasBorder()) renderBorder();
    }

    public void init() {
        onThemeChange();
    }

    public void onThemeChange() {
        ComponentStyle style = ThemeManager.getManager().getCurrentTheme().getComponentStyle(this);
        setStyleBase(style);
    }

    public void onClick(PointBounds mouseBounds, int button) {}
    public void onRelease(PointBounds mouseBounds, int state) {}
    public void onKeyTyped(char typedChar, int keyCode) {}

    public Component(ComponentStyle style) {
        this.style = style;
    }

    public Component() {
        this(ComponentStyle.defaults());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "={bounds=" + bounds + "}";
    }

    // --- Properties ---

    @Getter @Setter
    private Component parent;

    @Getter @Setter
    private boolean hovered = false;

    @Getter @Setter
    private BoxBounds bounds = new BoxBounds();

    // --- Style ---

    private ComponentStyle style;

    private void setStyleBase(ComponentStyle style) {
        this.style = style;
    }

    public ComponentStyle getStyle() {
        return styleOverride != null ? getMergedStyles(styleOverride) : style;
    }

    private ComponentStyle styleOverride;

    private ComponentStyle getMergedStyles(ComponentStyle override) {
        ComponentStyle mergedStyle = style.clone();
        for (Field field : ComponentStyle.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(override) != null) {
                    field.set(mergedStyle, field.get(override));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return mergedStyle;
    }

    // Overwrite the style of this component and return the child component
    public <C extends Component> C setStyle(ComponentStyleOverwrite styleOverwrite) {
        this.styleOverride = styleOverwrite.overwrite(new ComponentStyle());
        return (C) this;
    }

    @FunctionalInterface
    public interface ComponentStyleOverwrite {
        ComponentStyle overwrite(ComponentStyle style);
    }

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

    public void setWidth(float width) {
        this.bounds.setWidth(width);
    }

    public void setHeight(float height) {
        this.bounds.setHeight(height);
    }

    public void setLeft(float left) {
        this.bounds.setLeft(left);
    }

    public void setTop(float top) {
        this.bounds.setTop(top);
    }

    public void setSize(float width, float height) {
        this.bounds.setSize(width, height);
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
            getStyle().getBorder().getColor()
        );
    }

    private void renderBackground() {
        drawRectRound(getLeft(), getTop(), getWidth(), getHeight(), getStyle().getBorder().getRadius(), getStyle().getBackgroundColor());
    }

}
