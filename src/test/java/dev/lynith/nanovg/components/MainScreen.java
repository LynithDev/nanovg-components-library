package dev.lynith.nanovg.components;

import dev.lynith.nanovg.components.theme.AbstractTheme;
import dev.lynith.nanovg.components.theme.ThemeManager;
import dev.lynith.nanovg.components.theme.impl.DarkTheme;
import dev.lynith.nanovg.components.theme.impl.LightTheme;
import dev.lynith.nanovg.components.ui.ScreenComponent;
import dev.lynith.nanovg.components.ui.layouts.Layouts;
import dev.lynith.nanovg.components.ui.widgets.Label;
import dev.lynith.nanovg.components.ui.widgets.panels.Panel;
import dev.lynith.nanovg.components.utils.Color;
import dev.lynith.nanovg.components.utils.PointBounds;

public class MainScreen extends ScreenComponent {

    @Override
    public void init() {
        super.init();

        Label label1 = new Label("Label One").setStyle(style -> {
            style.setForegroundColor(Color.RED);
            return style;
        });

        Label label2 = new Label("Label Two");

        Panel panel = new Panel();
        panel.setLayout(Layouts.STACK);
        panel.add(
            label1,
            label2
        );

        getPanel().setLayout(Layouts.STACK);
        getPanel().add(
            label1,
            label2,
            panel
        );
    }

    private int timer = 0;

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);
        timer++;

        if (timer > 100) {
            timer = 0;
            AbstractTheme newTheme = ThemeManager.getManager().getCurrentTheme() instanceof DarkTheme ? new LightTheme() : new DarkTheme();
            ThemeManager.getManager().setCurrentTheme(newTheme);
        }
    }
}
