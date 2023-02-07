package dev.lynith.nanovg.components.utils;

import lombok.Getter;
import lombok.Setter;

public class Color {

    @Getter @Setter
    private float red, green, blue, alpha;

    public Color(float r, float g, float b, float a) {
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alpha = a;
    }

    public Color(float r, float g, float b) {
        this(r, g, b, 1f);
    }

    public Color(int r, int g, int b, int a) {
        this(r / 255f, g / 255f, b / 255f, a / 255f);
    }

    public Color(int r, int g, int b) {
        this(r, g, b, 255);
    }

    public Color(int rgb) {
        this((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF);
    }

    public String toHex() {
        return String.format("#%02x%02x%02x", (int) (red * 255), (int) (green * 255), (int) (blue * 255));
    }

    @Override
    public String toString() {
        return toHex();
    }

    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0);

    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);

    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color CYAN = new Color(0, 255, 255);
    public static final Color MAGENTA = new Color(255, 0, 255);
    
}
