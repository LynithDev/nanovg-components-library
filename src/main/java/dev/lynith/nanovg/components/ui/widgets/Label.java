package dev.lynith.nanovg.components.ui.widgets;

import dev.lynith.nanovg.components.NVGManager;
import dev.lynith.nanovg.components.ui.Component;
import dev.lynith.nanovg.components.ui.font.FontType;
import dev.lynith.nanovg.components.ui.styles.Border;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;

public class Label extends Component {

    @Getter @Setter
    private String text;

    public Label(String text, int fontSize, FontType fontType) {
        this.text = text;
        setFontSize(fontSize);
        setTextColor(getTextColor());
        setFontWeight(fontType);
    }

    public Label(String text, int fontSize) {
        this(text, fontSize, FontType.REGULAR);
    }

    public Label(String text) {
        this(text, 16);
    }

    @Override
    public void init() {
        super.init();

//        System.out.println(NVGManager.getRegularFont().getHeight(NVGManager.getNvg(), getFontSize()));
        setBounds(0, 0, getTextWidth(text), getFontSize());
    }

    public static float getTextWidth(String text) {
        return 5;
//        return NVGManager.getRegularFont().getWidth(NVGManager.getNvg(), text);
    }

    @Override
    public void render(PointBounds mouse) {
        super.render(mouse);
        drawText(text, getLeft(), getTop(), getFontSize(), getTextColor());
    }

}
