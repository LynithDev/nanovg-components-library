package dev.lynith.nanovg.components.theme.impl;

import dev.lynith.nanovg.components.theme.AbstractTheme;
import dev.lynith.nanovg.components.ui.styles.ComponentStyle;
import dev.lynith.nanovg.components.ui.ScreenComponent;
import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.ui.styles.impl.Border;
import dev.lynith.nanovg.components.ui.styles.impl.Spacing;
import dev.lynith.nanovg.components.ui.styles.impl.TextWrap;
import dev.lynith.nanovg.components.ui.widgets.Button;
import dev.lynith.nanovg.components.ui.widgets.Label;
import dev.lynith.nanovg.components.ui.widgets.panels.AbstractPanel;
import dev.lynith.nanovg.components.utils.Color;

public class LightTheme extends AbstractTheme {

    public LightTheme() {
        super("Default Light", ThemeType.LIGHT);

        registerStyle(ScreenComponent.class, getScreenStyle());
        registerStyle(AbstractPanel.class, getPanelStyle());
        registerStyle(Button.class, getButtonStyle());
        registerStyle(Label.class, getLabelStyle());
    }

    private final Color backgroundColor = Color.WHITE;
    private final Color secondaryBackgroundColor = new Color(245, 245, 245);
    private final Color tertiaryBackgroundColor = new Color(230, 230, 230);
    private final Color foregroundColor = Color.BLACK;
    private final Border border = new Border(1, tertiaryBackgroundColor);
    private final Spacing padding = new Spacing(5, 10);

    @Override
    public ComponentStyle getScreenStyle() {
        return ComponentStyle.defaults()
                .setBackgroundColor(backgroundColor)
                .setForegroundColor(foregroundColor);
    }

    @Override
    public ComponentStyle getPanelStyle() {
        return ComponentStyle.defaults()
                .setBackgroundColor(secondaryBackgroundColor)
                .setForegroundColor(foregroundColor);
    }

    @Override
    public ComponentStyle getButtonStyle() {
        return ComponentStyle.defaults()
                .setBackgroundColor(Color.RED)
                .setForegroundColor(foregroundColor)
                .setBorder(border);
    }

    @Override
    public ComponentStyle getLabelStyle() {
        return ComponentStyle.defaults()
                .setForegroundColor(foregroundColor)
                .setTextWrap(TextWrap.NO_WRAP);
    }
}
