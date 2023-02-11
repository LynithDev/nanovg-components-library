package dev.lynith.nanovg.components.ui.font;

import lombok.Getter;

public enum FontWeight {

    THIN(100, false),
    EXTRA_LIGHT(200, false),
    LIGHT(300, false),
    REGULAR(400, false),
    MEDIUM(500, false),
    SEMI_BOLD(600, false),
    BOLD(700, false),
    EXTRA_BOLD(800, false),
    BLACK(900, false),

    THIN_ITALIC(100, true),
    EXTRA_LIGHT_ITALIC(200, true),
    LIGHT_ITALIC(300, true),
    REGULAR_ITALIC(400, true),
    MEDIUM_ITALIC(500, true),
    SEMI_BOLD_ITALIC(600, true),
    BOLD_ITALIC(700, true),
    EXTRA_BOLD_ITALIC(800, true),
    BLACK_ITALIC(900, true);

    @Getter
    private final Integer weight;

    @Getter
    private final Boolean italic;

    FontWeight(Integer weight, Boolean italic) {
        this.weight = weight;
        this.italic = italic;
    }

}
