package dev.lynith.nanovg.components.ui.widgets;

import dev.lynith.nanovg.components.NVGManager;
import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.utils.Color;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public class Label extends Component {

    @Getter @Setter
    private String text;

    public Label(String text) {
        this.text = text;
    }

    @Override
    public void init() {
        super.init();

        setBounds(0, 0, NVGManager.getRegularFont().getWidth(NVGManager.getNvg(), text), getTextSize());
    }

    @Override
    public void render(PointBounds mouse) {
        super.render(mouse);
        drawText(text, getLeft(), getTop(), getTextSize(), getTextColor());
    }

}
