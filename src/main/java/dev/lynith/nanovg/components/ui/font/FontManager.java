package dev.lynith.nanovg.components.ui.font;

import lombok.Getter;

import java.io.InputStream;
import java.util.*;
import java.util.List;

public class FontManager {

    public static final String DEFAULT_FONT_FAMILY = "OpenSans";

    @Getter
    private final List<FontFamily> families = new ArrayList<>();

    public static int CURRENT_FAMILY_INDEX = 0;

    private static FontManager INSTANCE;
    public static FontManager getManager() {
        if (INSTANCE == null) INSTANCE = new FontManager();
        return INSTANCE;
    }

    public FontManager() {
        loadFont();
    }

    public FontFamily getCurrentFamily() {
        return families.get(CURRENT_FAMILY_INDEX);
    }

    public void add(FontFamily family) {
        families.add(family);
    }

    public boolean addToFamily(String fontFamily, Font font) {
        FontFamily family = getFontFamily(fontFamily);
        if (family == null)
            return false;

        family.add(font);
        return true;
    }

    public boolean addToFamily(String fontFamily, Font... fonts) {
        FontFamily family = getFontFamily(fontFamily);
        if (family == null)
            return false;

        family.add(fonts);
        return true;
    }

    public boolean addToFamily(String fontFamily, List<Font> fonts) {
        FontFamily family = getFontFamily(fontFamily);
        if (family == null)
            return false;

        family.add(fonts);
        return true;
    }

    public FontFamily getFontFamily(String fontFamily) {
        for (FontFamily family : families)
            if (family.getName().equals(fontFamily)) return family;
        return null;
    }

    public FontFamily getDefaultFontFamily() {
        return getFontFamily(DEFAULT_FONT_FAMILY);
    }

    // --- Load Default FOnt --

    private void loadFont() {
        try {
            FontFamily family = new FontFamily(DEFAULT_FONT_FAMILY);
            family.add(new Font(getFontStream("Light"), FontType.LIGHT),
                    new Font(getFontStream("LightItalic"), FontType.LIGHT_ITALIC),
                    new Font(getFontStream("Regular"), FontType.REGULAR),
                    new Font(getFontStream("Italic"), FontType.REGULAR_ITALIC),
                    new Font(getFontStream("Medium"), FontType.MEDIUM),
                    new Font(getFontStream("MediumItalic"), FontType.MEDIUM_ITALIC),
                    new Font(getFontStream("SemiBold"), FontType.SEMI_BOLD),
                    new Font(getFontStream("SemiBoldItalic"), FontType.SEMI_BOLD_ITALIC),
                    new Font(getFontStream("Bold"), FontType.BOLD),
                    new Font(getFontStream("BoldItalic"), FontType.BOLD_ITALIC));

            add(family);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InputStream getFontStream(String suffix) {
        return FontManager.class.getResourceAsStream("/" + FontManager.DEFAULT_FONT_FAMILY + "/" + FontManager.DEFAULT_FONT_FAMILY + "-" + suffix + ".ttf");
    }

}
