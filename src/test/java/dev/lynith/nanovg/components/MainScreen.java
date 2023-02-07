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

        setBackgroundColor(Color.RED);
        setLayout(new StackLayout());

        getLayout().add(
                new Label("Hello World"),
                new Button("Click Me", (mouseBounds, button) -> System.out.println("Clicked!"))
        );

        Button btn = new Button("Click Me");

        btn.setOnClick((mouseBounds, button) -> {
            System.out.println("Clicked!");
            btn.setText("Clicked!");
        });

        getLayout().add(btn);

        getLayout().init();
    }
}
