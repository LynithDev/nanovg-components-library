package dev.lynith.nanovg.components.theme;

import dev.lynith.nanovg.components.utils.Color;
import lombok.Getter;

@Getter
public abstract class AbstractTheme {

    public static final Color BACKGROUND_PRIMARY = new Color(30, 30, 30);
    public static final Color BACKGROUND_SECONDARY = new Color(62, 62, 65);

    public static final Color OVERLAY_COLOR = new Color(0, 0, 0, 102);
    public static final Color OVERLAY_COLOR_DARK = new Color(0, 0, 0, 152);

    public static final Color TEXT_PRIMARY = new Color(255, 255, 255);
    public static final Color TEXT_SECONDARY = new Color(244, 244, 244);

    public static final Color ACCENT_PRIMARY = new Color(85, 85, 230);
    public static final Color ACCENT_SECONDARY = new Color(105, 105, 230);
    
}
