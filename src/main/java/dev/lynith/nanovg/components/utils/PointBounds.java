package dev.lynith.nanovg.components.utils;

import lombok.Getter;
import lombok.Setter;

public class PointBounds {

    @Getter @Setter
    private float x, y;

    public PointBounds(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public PointBounds() {
        this(0, 0);
    }

    public boolean is(float x, float y) {
        return this.x == x && this.y == y;
    }

    public boolean is(PointBounds other) {
        return is(other.x, other.y);
    }

    public boolean inside(BoxBounds box) {
        return box.contains(x, y);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(PointBounds other) {
        set(other.x, other.y);
    }

    public float distance(PointBounds other) {
        return (float) Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    @Override
    public String toString() {
        return "PointBounds{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
