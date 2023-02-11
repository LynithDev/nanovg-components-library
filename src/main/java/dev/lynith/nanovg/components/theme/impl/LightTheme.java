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

public class LightTheme extends AbstractTheme {

    public LightTheme() {
        super("Default Light", ThemeType.LIGHT);

        registerStyle(ScreenComponent.class, getScreenStyle());
        registerStyle(AbstractLayout.class, getLayoutStyle());
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
