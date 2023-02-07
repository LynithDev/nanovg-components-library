package dev.lynith.nanovg.components.ui.widgets;

import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.styles.Border;
import dev.lynith.nanovg.components.ui.styles.TextAlignment;
import dev.lynith.nanovg.components.utils.Color;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

public class Button extends Component {

    @Setter
    private Consumer<Button> onClick;

    @Getter @Setter
    private String text;

    private Label label;

    public Button(String text, Consumer<Button> onClick) {
        super();
        this.onClick = onClick;
        this.label = new Label(text);
    }

    @Override
    public void init() {
        super.init();
        setBackgroundColor(Color.GREEN);
        setBorder(new Border(5, Color.BLACK));

        label.setBounds(getBounds());
        label.setTextAlignment(getTextAlignment());
    }

    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);
        label.render(mouseBounds);
    }

    @Override
    public void onClick(PointBounds mouseBounds, int button) {
        super.onClick(mouseBounds, button);
        onClick.accept(this);
    }

}
