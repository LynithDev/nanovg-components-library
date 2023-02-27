package dev.lynith.nanovg.components.ui.styles;

import dev.lynith.nanovg.components.ui.font.FontFamily;
import dev.lynith.nanovg.components.ui.font.FontManager;
import dev.lynith.nanovg.components.ui.font.FontWeight;
import dev.lynith.nanovg.components.ui.styles.impl.*;
import dev.lynith.nanovg.components.utils.Color;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ComponentStyle implements Cloneable {

    private Color backgroundColor;
    private Color foregroundColor;

    private Border border;
    private Spacing padding;
    private Spacing margin;

    private FontWeight fontWeight;
    private TextAlignment textAlignment;
    private Float fontSize;
    private FontFamily fontFamily;
    private TextWrap textWrap;

    private LayoutDirection direction;
    private Wrap wrap;
    private Overflow overflow;

    public static ComponentStyle defaults() {
        return new ComponentStyle(
                Color.TRANSPARENT,
                Color.BLACK,
                new Border(),
                new Spacing(),
                new Spacing(),
                FontWeight.REGULAR,
                TextAlignment.LEFT,
                18F,
                FontManager.getManager().getDefaultFontFamily(),
                TextWrap.WRAP,
                LayoutDirection.VERTICAL,
                Wrap.WRAP,
                Overflow.VISIBLE
        );
    }

    @Override
    public String toString() {
        return "ComponentStyle{" +
                "backgroundColor=" + backgroundColor +
                ", foregroundColor=" + foregroundColor +
                ", border=" + border +
                ", padding=" + padding +
                ", margin=" + margin +
                ", fontWeight=" + fontWeight +
                ", textAlignment=" + textAlignment +
                ", fontSize=" + fontSize +
                ", fontFamily=" + fontFamily +
                ", textWrap=" + textWrap +
                '}';
    }

    public boolean hasBorder() {
        return border != null;
    }

    @Override
    public ComponentStyle clone() {
        try {
            return (ComponentStyle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
