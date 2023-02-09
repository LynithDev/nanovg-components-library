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
    private ClickCallback onClick;

    @Getter
    private String text;

    public void setText(String text) {
        this.text = text;
        label.setText(text);
    }

    private final Label label;

    public Button(String text, ClickCallback onClick) {
        super();
        this.onClick = onClick;
        this.text = text;
        this.label = new Label(text);
    }

    public Button(String text) {
        this(text, null);
    }

    @Override
    public void init() {
        super.init();
        setBorder(new Border(1, Color.BLACK));
        setBounds(0, 0, 100, 50);

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
        onClick.accept(mouseBounds, button);
    }

    @FunctionalInterface
    public interface ClickCallback {
        void accept(PointBounds mouseBounds, int button);
    }

}
