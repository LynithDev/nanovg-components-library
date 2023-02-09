package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.ui.font.FontType;
import dev.lynith.nanovg.components.ui.styles.Border;
import dev.lynith.nanovg.components.ui.styles.Spacing;
import dev.lynith.nanovg.components.ui.styles.TextAlignment;
import dev.lynith.nanovg.components.utils.BoxBounds;
import dev.lynith.nanovg.components.utils.Color;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public abstract class Component extends NVGHelper {

    // --- Base ---

    public void render(PointBounds mouseBounds) {
        hovered = mouseBounds.inside(bounds);

        drawRectRound(getLeft(), getTop(), getWidth(), getHeight(), getBorder().getRadius(), getBackgroundColor());
        if (hasBorder())
            drawRectRoundOutline(getLeft() - getBorderWidth() / 2, getTop() - getBorderWidth() / 2, getWidth() + getBorderWidth(), getHeight() + getBorderWidth(), getBorder().getRadius(), getBorderWidth(), getBorder().getColor());
    }

    public void init() {}
    public void onClick(PointBounds mouseBounds, int button) {}
    public void onRelease(PointBounds mouseBounds, int state) {}
    public void onKeyTyped(char typedChar, int keyCode) {}

    // --- Properties ---

    @Getter @Setter
    private Component parent;

    @Getter @Setter
    private boolean hovered = false;

    @Getter @Setter
    private BoxBounds bounds = new BoxBounds();

    public void setBounds(float left, float top, float width, float height) {
        this.bounds.set(left, top, width, height);
    }

    // --- Styles ---

    @Getter @Setter
    private Color backgroundColor = Color.TRANSPARENT;

    @Getter @Setter
    private Color textColor = Color.BLACK;

    @Getter @Setter
    private int fontSize = 16;

    @Getter @Setter
    private FontType fontWeight = FontType.REGULAR;

    @Getter @Setter
    private TextAlignment textAlignment = TextAlignment.LEFT;

    @Getter @Setter
    private Spacing padding = new Spacing();

    @Getter @Setter
    private Spacing margin = new Spacing();

    @Getter @Setter
    private Border border = new Border();

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

    public float getOuterLeft() { return getLeft() - getMargin().getLeft(); }
    public float getOuterTop() { return getTop() - getMargin().getTop(); }
    public float getOuterWidth() { return getWidth() + getMargin().getLeft() + getMargin().getRight(); }
    public float getOuterHeight() { return getHeight() + getMargin().getTop() + getMargin().getBottom(); }

    public float getInnerLeft() { return getLeft() + getPadding().getLeft(); }
    public float getInnerTop() { return getTop() + getPadding().getTop(); }
    public float getInnerWidth() { return getWidth() - getPadding().getLeft() - getPadding().getRight(); }
    public float getInnerHeight() { return getHeight() - getPadding().getTop() - getPadding().getBottom(); }

    public float getBorderWidth() { return getBorder().getWidth(); }
    public float getBorderRadius() { return getBorder().getRadius(); }
    public Color getBorderColor() { return getBorder().getColor(); }
    public boolean hasBorder() { return getBorderWidth() > 0; }

    public float getCenterX() { return getLeft() + getWidth() / 2; }
    public float getCenterY() { return getTop() + getHeight() / 2; }

    public float getPaddingLeft() { return getPadding().getLeft(); }
    public float getPaddingTop() { return getPadding().getTop(); }
    public float getPaddingRight() { return getPadding().getRight(); }
    public float getPaddingBottom() { return getPadding().getBottom(); }

    public float getMarginLeft() { return getMargin().getLeft(); }
    public float getMarginTop() { return getMargin().getTop(); }
    public float getMarginRight() { return getMargin().getRight(); }
    public float getMarginBottom() { return getMargin().getBottom(); }

}
