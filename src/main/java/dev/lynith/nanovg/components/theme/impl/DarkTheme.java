package dev.lynith.nanovg.components.theme.impl;

import dev.lynith.nanovg.components.theme.AbstractTheme;
import dev.lynith.nanovg.components.ui.ComponentStyle;
import dev.lynith.nanovg.components.ui.ScreenComponent;
import dev.lynith.nanovg.components.ui.layouts.AbstractLayout;
import dev.lynith.nanovg.components.ui.styles.Border;
import dev.lynith.nanovg.components.ui.styles.Spacing;
import dev.lynith.nanovg.components.ui.widgets.Button;
import dev.lynith.nanovg.components.ui.widgets.Label;
import dev.lynith.nanovg.components.utils.Color;

public class DarkTheme extends AbstractTheme {

    public DarkTheme() {
        super("Default Dark", ThemeType.DARK);

        registerStyle(ScreenComponent.class, getScreenStyle());
        registerStyle(AbstractLayout.class, getLayoutStyle());
        registerStyle(Button.class, getButtonStyle());
        registerStyle(Label.class, getLabelStyle());
    }

    private final Color backgroundColor = new Color(40, 40, 40);
    private final Color secondaryBackgroundColor = new Color(45, 45, 45);
    private final Color tertiaryBackgroundColor = new Color(50, 50, 50);
    private final Color foregroundColor = Color.WHITE;
    private final Border border = new Border(1, tertiaryBackgroundColor);
    private final Spacing padding = new Spacing(5, 10);

    @Override
    public ComponentStyle getScreenStyle() {
        return new ComponentStyle()
                .setBackgroundColor(backgroundColor)
                .setForegroundColor(foregroundColor);
    }

    @Override
    public ComponentStyle getLayoutStyle() {
        return new ComponentStyle()
                .setBackgroundColor(secondaryBackgroundColor)
                .setForegroundColor(foregroundColor);
    }

    @Override
    public ComponentStyle getButtonStyle() {
        return new ComponentStyle()
                .setBackgroundColor(secondaryBackgroundColor)
                .setForegroundColor(foregroundColor)
                .setBorder(border);
    }

    @Override
    public ComponentStyle getLabelStyle() {
        return new ComponentStyle()
                .setForegroundColor(foregroundColor);
    }

}