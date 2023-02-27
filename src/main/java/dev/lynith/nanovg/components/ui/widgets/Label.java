package dev.lynith.nanovg.components.ui.widgets;

import dev.lynith.nanovg.components.NVGManager;
import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.styles.ComponentStyle;
import dev.lynith.nanovg.components.ui.font.FontWeight;
import dev.lynith.nanovg.components.ui.styles.impl.TextWrap;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public class Label extends Component {

    @Getter @Setter
    private String text;

    public Label(String text, float fontSize, FontWeight fontWeight) {
        super();
        this.text = text;
        getStyle().setFontSize(fontSize);
        getStyle().setFontWeight(fontWeight);
    }

    public Label(String text, int fontSize) {
        this(text, fontSize, FontWeight.REGULAR);
    }

    public Label(String text) {
        this(text, 18, FontWeight.REGULAR);
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

        if (getStyle().getTextWrap().equals(TextWrap.WRAP) && getTextWidth(text) > getBounds().getWidth()) {
            String[] words = text.split(" ");
            String line = "";
            float y = getTop();
            for (String word : words) {
                float width = getTextWidth(line + word);
                if (width > getBounds().getWidth()) {
                    drawText(line, getLeft(), y, getStyle().getFontSize(), getStyle().getForegroundColor());
                    line = word + " ";
                    y += getTextHeight(line);
                } else {
                    line += word + " ";
                }
            }
            drawText(line, getLeft(), y, getStyle().getFontSize(), getStyle().getForegroundColor());
            return;
        }

        if (getStyle().getTextWrap().equals(TextWrap.ELLIPSIS)) {
            StringBuilder sb = new StringBuilder(text);
            while (getTextWidth(sb.toString()) > getBounds().getWidth()) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("...");
            drawText(sb.toString(), getLeft(), getTop(), getStyle().getFontSize(), getStyle().getForegroundColor());
            return;
        }

        drawText(text, getLeft(), getTop(), getStyle().getFontSize(), getStyle().getForegroundColor());

    }

}
