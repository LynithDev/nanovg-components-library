package dev.lynith.nanovg.components.ui.font;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FontFamily {

    @Getter
    private final String name;

    @Getter @Setter
    private Font thin, thinItalic,
            extraLight, extraLightItalic,
            light, lightItalic,
            regular, regularItalic,
            medium, mediumItalic,
            semiBold, semiBoldItalic,
            bold, boldItalic,
            extraBold, extraBoldItalic,
            black, blackItalic;

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
            case THIN_ITALIC: thinItalic = font; break;
            case EXTRA_LIGHT: extraLight = font; break;
            case EXTRA_LIGHT_ITALIC: extraLightItalic = font; break;
            case LIGHT: light = font; break;
            case LIGHT_ITALIC: lightItalic = font; break;
            case REGULAR: regular = font; break;
            case REGULAR_ITALIC: regularItalic = font; break;
            case MEDIUM: medium = font; break;
            case MEDIUM_ITALIC: mediumItalic = font; break;
            case SEMI_BOLD: semiBold = font; break;
            case SEMI_BOLD_ITALIC: semiBoldItalic = font; break;
            case BOLD: bold = font; break;
            case BOLD_ITALIC: boldItalic = font; break;
            case EXTRA_BOLD: extraBold = font; break;
            case EXTRA_BOLD_ITALIC: extraBoldItalic = font; break;
            case BLACK: black = font; break;
            case BLACK_ITALIC: blackItalic = font; break;
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

    public Font getFont(FontWeight type) {
        switch (type) {
            case THIN: return thin;
            case THIN_ITALIC: return thinItalic;
            case EXTRA_LIGHT: return extraLight;
            case EXTRA_LIGHT_ITALIC: return extraLightItalic;
            case LIGHT: return light;
            case LIGHT_ITALIC: return lightItalic;
            default: return regular;
            case REGULAR_ITALIC: return regularItalic;
            case MEDIUM: return medium;
            case MEDIUM_ITALIC: return mediumItalic;
            case SEMI_BOLD: return semiBold;
            case SEMI_BOLD_ITALIC: return semiBoldItalic;
            case BOLD: return bold;
            case BOLD_ITALIC: return boldItalic;
            case EXTRA_BOLD: return extraBold;
            case EXTRA_BOLD_ITALIC: return extraBoldItalic;
            case BLACK: return black;
            case BLACK_ITALIC: return blackItalic;
        }
    }

    public Font getFont(String type) {
        return getFont(FontWeight.valueOf(type.toUpperCase()));
    }

}
