package dev.lynith.nanovg.components.ui.styles.impl;

import dev.lynith.nanovg.components.utils.Color;
import lombok.Getter;
import lombok.Setter;

public class Border {

    @Getter @Setter
    private int radius;

    @Getter @Setter
    private Color color;

    @Getter @Setter
    private float width;

    public Border() {
        this(0, 0, Color.BLACK);
    }

    public Border(float width, Color color) {
        this(width, 3, color);
    }

    public Border(float width, int radius, Color color) {
        this.width = width;
        this.radius = radius;
        this.color = color;
    }

}
