package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.ui.font.FontFamily;
import dev.lynith.nanovg.components.ui.font.FontManager;
import dev.lynith.nanovg.components.ui.font.FontWeight;
import dev.lynith.nanovg.components.ui.styles.Border;
import dev.lynith.nanovg.components.ui.styles.Spacing;
import dev.lynith.nanovg.components.ui.styles.TextAlignment;
import dev.lynith.nanovg.components.utils.Color;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class ComponentStyle {

    private Color backgroundColor = Color.TRANSPARENT;
    private Color foregroundColor = Color.BLACK;

    private Border border = new Border();
    private Spacing padding = new Spacing();
    private Spacing margin = new Spacing();

    private FontWeight fontWeight = FontWeight.REGULAR;
    private TextAlignment textAlignment = TextAlignment.LEFT;
    private float fontSize = 16;
    private FontFamily fontFamily = FontManager.getManager().getDefaultFontFamily();

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
                '}';
    }

    public boolean hasBorder() {
        return border != null;
    }
}
