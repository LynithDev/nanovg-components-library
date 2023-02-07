package dev.lynith.nanovg.components.utils;

import lombok.Getter;
import lombok.Setter;

public class BoxBounds {

    @Getter @Setter
    private float left, top, width, height;

    public BoxBounds(float left, float top, float width, float height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public BoxBounds() {
        this(0, 0, 0, 0);
    }

    public boolean contains(float x, float y) {
        return x >= left && x <= left + width && y >= top && y <= top + height;
    }

    public boolean contains(BoxBounds other) {
        return contains(other.left, other.top) && contains(other.left + other.width, other.top + other.height);
    }

    public boolean intersects(BoxBounds other) {
        return contains(other.left, other.top) || contains(other.left + other.width, other.top + other.height);
    }

    public void set(float left, float top, float width, float height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public void set(BoxBounds other) {
        set(other.left, other.top, other.width, other.height);
    }

    public void setPosition(float left, float top) {
        set(left, top, width, height);
    }

    public void setSize(float width, float height) {
        set(left, top, width, height);
    }

    public float getCenterX() {
        return left + (width / 2);
    }

    public float getCenterY() {
        return top + (height / 2);
    }

    public float getRight() {
        return left + width;
    }

    public float getBottom() {
        return top + height;
    }

    @Override
    public String toString() {
        return "BoxBounds{" +
                "left=" + left +
                ", top=" + top +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
