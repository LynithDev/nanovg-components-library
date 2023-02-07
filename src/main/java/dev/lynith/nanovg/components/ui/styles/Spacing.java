package dev.lynith.nanovg.components.ui.styles;

import lombok.Getter;
import lombok.Setter;

public class Spacing {

    @Getter @Setter
    private float top, right, bottom, left;

    public void setAll(float all) {
        this.top = all;
        this.right = all;
        this.bottom = all;
        this.left = all;
    }

    public Spacing(float top, float left, float bottom, float right) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public Spacing(float all) {
        this(all, all, all, all);
    }

    public Spacing() {
        this(0);
    }

}
