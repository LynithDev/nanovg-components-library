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

public class DarkTheme extends AbstractTheme {

    public DarkTheme() {
        super("Default Dark", ThemeType.DARK);

        registerStyle(ScreenComponent.class, getScreenStyle());
        registerStyle(AbstractPanel.class, getPanelStyle());
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
                .setBackgroundColor(secondaryBackgroundColor)
                .setForegroundColor(foregroundColor)
                .setBorder(border);
    }

    @Override
    public ComponentStyle getLabelStyle() {
        return ComponentStyle.defaults()
                .setForegroundColor(foregroundColor)
                .setFontSize(20F)
                .setTextWrap(TextWrap.NO_WRAP);
    }

}
