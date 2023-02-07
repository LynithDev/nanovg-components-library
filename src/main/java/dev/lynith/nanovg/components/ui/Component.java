package dev.lynith.nanovg.components.ui;

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
    private int textSize = 16;

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

    public float getOuterLeft() {
        return bounds.getLeft() - margin.getLeft() - border.getWidth();
    }

    public float getOuterTop() {
        return bounds.getTop() - margin.getTop() - border.getWidth();
    }

    public float getOuterWidth() {
        return bounds.getWidth() + margin.getLeft() + margin.getRight() + border.getWidth() * 2;
    }

    public float getOuterHeight() {
        return bounds.getHeight() + margin.getTop() + margin.getBottom() + border.getWidth() * 2;
    }

    public float getCenterX() {
        return getLeft() + (getWidth() / 2);
    }

    public float getCenterY() {
        return getTop() + (getHeight() / 2);
    }

    public float getRight() {
        return getLeft() + getWidth();
    }

    public float getBottom() {
        return getTop() + getHeight();
    }

    public float getPaddingLeft() {
        return padding.getLeft();
    }

    public float getPaddingTop() {
        return padding.getTop();
    }

    public float getPaddingRight() {
        return padding.getRight();
    }

    public float getPaddingBottom() {
        return padding.getBottom();
    }

    public float getPaddingAll() {
        return Math.max(padding.getLeft(), Math.max(padding.getTop(), Math.max(padding.getRight(), padding.getBottom())));
    }

    public float getPaddingHorizontal() {
        return Math.max(padding.getLeft(), padding.getRight());
    }

    public float getPaddingVertical() {
        return Math.max(padding.getTop(), padding.getBottom());
    }

    public float getMarginLeft() {
        return margin.getLeft();
    }

    public float getMarginTop() {
        return margin.getTop();
    }

    public float getMarginRight() {
        return margin.getRight();
    }

    public float getMarginBottom() {
        return margin.getBottom();
    }

    public float getMarginAll() {
        return Math.max(margin.getLeft(), Math.max(margin.getTop(), Math.max(margin.getRight(), margin.getBottom())));
    }

    public float getMarginHorizontal() {
        return Math.max(margin.getLeft(), margin.getRight());
    }

    public float getMarginVertical() {
        return Math.max(margin.getTop(), margin.getBottom());
    }

    public float getBorderWidth() {
        return getBorder().getWidth();
    }

    public boolean hasBorder() {
        return getBorder().getWidth() > 0;
    }

    public void setBorderColor(Color color) {
        border.setColor(color);
    }

    public void setBorderRadius(float radius) {
        border.setRadius((int) radius);
    }

    public void setBorderWidth(float width) {
        border.setWidth(width);
    }

}
