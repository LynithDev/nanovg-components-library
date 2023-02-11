package dev.lynith.nanovg.components;

import dev.lynith.nanovg.components.theme.AbstractTheme;
import dev.lynith.nanovg.components.theme.ThemeManager;
import dev.lynith.nanovg.components.theme.impl.DarkTheme;
import dev.lynith.nanovg.components.theme.impl.LightTheme;
import dev.lynith.nanovg.components.ui.ScreenComponent;
import dev.lynith.nanovg.components.ui.styles.Wrap;
import dev.lynith.nanovg.components.ui.widgets.Button;
import dev.lynith.nanovg.components.ui.widgets.Label;

public class MainScreen extends ScreenComponent {

    @Override
    public void init() {
        super.init();
        getLayout().add(
                new Label("Hello World"),
                new Button("Click Me", (mouseBounds, mouseButton, button) -> System.out.println("Clicked!"))
        );

        Button btn = new Button("Change Theme to: Dark");

        btn.setOnClick((mouseBounds, mouseButton, button) -> {
            AbstractTheme newTheme = ThemeManager.getManager().getCurrentTheme() instanceof DarkTheme ? new LightTheme() : new DarkTheme();
            ThemeManager.getManager().setCurrentTheme(newTheme);
            onThemeUpdate();

            String otherTheme = ThemeManager.getManager().getCurrentTheme() instanceof DarkTheme ? "Light" : "Dark";
            button.setText("Change Theme to: " + otherTheme);
        });

        getLayout().add(btn);
        getLayout().init();
    }

}
