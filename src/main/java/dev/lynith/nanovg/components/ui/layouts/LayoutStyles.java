package dev.lynith.nanovg.components.ui.layouts;

import dev.lynith.nanovg.components.ui.ComponentStyle;
import dev.lynith.nanovg.components.ui.styles.LayoutDirection;
import dev.lynith.nanovg.components.ui.styles.Overflow;
import dev.lynith.nanovg.components.ui.styles.Wrap;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class LayoutStyles extends ComponentStyle {

    private LayoutDirection direction = LayoutDirection.VERTICAL;
    private Wrap wrap = Wrap.NO_WRAP;
    private Overflow overflow = Overflow.VISIBLE;

}
