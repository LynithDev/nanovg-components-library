package dev.lynith.nanovg.components;

import dev.lynith.nanovg.components.ui.ScreenComponent;
import dev.lynith.nanovg.components.ui.layouts.StackLayout;
import dev.lynith.nanovg.components.ui.widgets.Button;
import dev.lynith.nanovg.components.ui.widgets.Label;
import dev.lynith.nanovg.components.utils.Color;
import dev.lynith.nanovg.components.utils.PointBounds;

public class MainScreen extends ScreenComponent {

    @Override
    public void init() {
        super.init();
        setBackgroundColor(new Color(100, 100, 100));
        setLayout(new StackLayout());
        getLayout().add(
                new Label("Hello World"),
                new Button("Click Me", button -> System.out.println("Clicked!"))
        );
    }
}
