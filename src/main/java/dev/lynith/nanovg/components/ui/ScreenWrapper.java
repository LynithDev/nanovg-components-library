package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.utils.BoxBounds;

public class ScreenWrapper extends Component {

    public ScreenWrapper() {
        setParent(this);
    }

    @Override
    public BoxBounds getBounds() {
        return new BoxBounds(0, 0, getScreenWidth(), getScreenHeight());
    }
}
