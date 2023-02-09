package dev.lynith.nanovg.components.ui.font;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FontFamily {

    @Getter
    private final String name;

    @Getter @Setter
    private Font thin, extraLight, light, regular, medium, semiBold, bold, extraBold, black;

    public FontFamily(String name, Font thin, Font extraLight, Font light, Font regular, Font medium, Font semiBold, Font bold, Font extraBold, Font black) {
        this.name = name;
        this.thin = thin;
        this.extraLight = extraLight;
        this.light = light;
        this.regular = regular;
        this.medium = medium;
        this.semiBold = semiBold;
        this.bold = bold;
        this.extraBold = extraBold;
        this.black = black;
    }

    public FontFamily(String name, Font regular) {
        this(name, regular, regular, regular, regular, regular, regular, regular, regular, regular);
    }

    public FontFamily(String name) {
        this(name, null, null, null, null, null, null, null, null, null);
    }

    public void add(Font font) {
        switch (font.getType()) {
            case THIN: thin = font; break;
            case EXTRA_LIGHT: extraLight = font; break;
            case LIGHT: light = font; break;
            case REGULAR: regular = font; break;
            case MEDIUM: medium = font; break;
            case SEMI_BOLD: semiBold = font; break;
            case BOLD: bold = font; break;
            case EXTRA_BOLD: extraBold = font; break;
            case BLACK: black = font; break;
        }
    }

    public void add(Font... fonts) {
        for (Font font : fonts)
            add(font);
    }

    public void add(List<Font> fonts) {
        for (Font font : fonts)
            add(font);
    }

    public Font getFont(FontType type) {
        switch (type) {
            case THIN: return thin;
            case EXTRA_LIGHT: return extraLight;
            case LIGHT: return light;
            default: return regular;
            case MEDIUM: return medium;
            case SEMI_BOLD: return semiBold;
            case BOLD: return bold;
            case EXTRA_BOLD: return extraBold;
            case BLACK: return black;
        }
    }

    public Font getFont(String type) {
        return getFont(FontType.valueOf(type.toUpperCase()));
    }

}
