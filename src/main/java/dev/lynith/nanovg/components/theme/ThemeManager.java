package dev.lynith.nanovg.components.theme;

import java.util.ArrayList;
import java.util.List;

public class ThemeManager {

    private final List<Class<?>> classes = new ArrayList<>();

    public void register(Object object) {
        classes.add(object.getClass());
    }


}
