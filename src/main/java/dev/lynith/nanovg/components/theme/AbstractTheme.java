package dev.lynith.nanovg.components.theme;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.ComponentStyle;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTheme {

    @Getter
    private final String name;

    @Getter
    private final ThemeType type;

    @Getter
    private final Map<Class<? extends Component<?>>, ComponentStyle> componentStyles;

    public AbstractTheme(String name, ThemeType type) {
        this(name, type, new HashMap<>());
    }

    public AbstractTheme(String name, ThemeType type, Map<Class<? extends Component<?>>, ComponentStyle> componentStyles) {
        this.name = name;
        this.type = type;
        this.componentStyles = componentStyles;
    }

    public AbstractTheme registerStyle(Class<? extends Component<?>> componentClass, ComponentStyle style) {
        componentStyles.put(componentClass, style);
        return this;
    }

    public <T extends ComponentStyle> T getComponentStyle(Component<T> component) {
        ComponentStyle style = componentStyles.get(component.getClass());
        return style == null ? component.getStyle() : (T) style;
    }

    public enum ThemeType {
        DARK,
        LIGHT,
        DARK_HIGH_CONTRAST,
        LIGHT_HIGH_CONTRAST,
        CUSTOM
    }

    // --- Component Styles ---
    public abstract ComponentStyle getScreenStyle();
    public abstract ComponentStyle getLayoutStyle();

    public abstract ComponentStyle getButtonStyle();
    public abstract ComponentStyle getLabelStyle();

}
