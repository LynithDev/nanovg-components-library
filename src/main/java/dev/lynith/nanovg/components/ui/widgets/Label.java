package dev.lynith.nanovg.components.ui.widgets;

import dev.lynith.nanovg.components.NVGManager;
import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.ComponentStyle;
import dev.lynith.nanovg.components.ui.font.FontWeight;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public class Label extends Component<ComponentStyle> {

    @Getter @Setter
    private String text;

    public Label(String text, int fontSize, FontWeight fontWeight) {
        this.text = text;
        getStyle().setFontSize(fontSize);
        getStyle().setFontWeight(fontWeight);
    }

    public Label(String text, int fontSize) {
        this(text, fontSize, FontWeight.REGULAR);
    }

    public Label(String text) {
        this(text, 16);
    }

    @Override
    public void init() {
        super.init();

        setBounds(0, 0, getTextWidth(text), getStyle().getFontSize());
    }

    public float getTextWidth(String text) {
        return getStyle().getFontFamily().getFont(getStyle().getFontWeight()).getWidth(NVGManager.getNvg(), text);
    }

    public float getTextHeight(String text) {
        return getStyle().getFontFamily().getFont(getStyle().getFontWeight()).getHeight(NVGManager.getNvg(), getStyle().getFontSize());
    }

    @Override
    public void render(PointBounds mouse) {
        super.render(mouse);
        drawText(text, getLeft(), getTop(), getStyle().getFontSize(), getStyle().getForegroundColor());
    }

}
