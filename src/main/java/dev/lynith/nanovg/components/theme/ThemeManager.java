package dev.lynith.nanovg.components.theme;

import dev.lynith.nanovg.components.theme.impl.LightTheme;
import lombok.Getter;

public class ThemeManager {

    @Getter
    private AbstractTheme currentTheme = new LightTheme();

    private static ThemeManager instance;
    public static ThemeManager getManager() {
        if (instance == null) instance = new ThemeManager();
        return instance;
    }

    public void setCurrentTheme(AbstractTheme theme) {
        this.currentTheme = theme;
    }

}
