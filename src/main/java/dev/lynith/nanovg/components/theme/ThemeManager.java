package dev.lynith.nanovg.components.theme;

import dev.lynith.nanovg.components.theme.impl.LightTheme;
import lombok.Getter;

public class ThemeManager {

    @Getter
    private AbstractTheme currentTheme = getTheme();

    private AbstractTheme getTheme() {
        String themeClass = System.getProperty("nvg.theme", LightTheme.class.getName());
        try {
            return (AbstractTheme) Class.forName(themeClass).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Failed to load theme: \"" + themeClass + "\"");
        }
        return new LightTheme();
    }

    private static ThemeManager instance;
    public static ThemeManager getManager() {
        if (instance == null) instance = new ThemeManager();
        return instance;
    }

    public void setCurrentTheme(AbstractTheme theme) {
        this.currentTheme = theme;
    }

}
