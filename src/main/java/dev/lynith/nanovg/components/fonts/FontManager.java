package dev.lynith.nanovg.components.fonts;

import dev.lynith.nanovg.components.Font;
import dev.lynith.nanovg.components.utils.SystemUtils;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FontManager {

    @Getter
    private List<String> cachedSystemFonts = new ArrayList<>();

    private String defaultFont;

    private static FontManager instance;
    public static FontManager getManager() {
        if (instance == null) instance = new FontManager();
        return instance;
    }

    private List<String> getSystemFontsPaths() {
        switch (SystemUtils.getOS()) {
            case WINDOWS:
                return Collections.singletonList(System.getenv("WINDIR") + "\\Fonts");
            case MACOS:
                return Arrays.asList(
                        System.getProperty("user.home") + "/Library/Fonts",
                        "/Library/Fonts",
                        "/System/Library/Fonts"
                );
            case LINUX:
                List<String> paths = Arrays.asList(
                        System.getProperty("user.home") + "/.fonts",
                        "/usr/share/fonts/"
                );

                List<String> result = new ArrayList<>();

                for (String path : paths) {
                    File file = new File(path);

                    if (file.exists() && file.isDirectory()) {
                        File[] files = file.listFiles();
                        if (files == null) continue;

                        for (File font : files) {
                            if (font.isDirectory() && new File(font, "fonts.dir").exists()) {
                                result.add(font.getAbsolutePath());
                            }
                        }
                    }
                }

                return result;
        }
        return Collections.emptyList();
    }

    public List<String> getSystemFonts() {
        if (cachedSystemFonts.isEmpty())
            cachedSystemFonts = forceGetSystemFonts();

        return cachedSystemFonts;
    }

    public String getDefaultFont() {
        if (defaultFont != null) return defaultFont;
        List<String> fonts = Arrays.asList(
                "NotoSans-Regular",
                "SegoeUI",
                "Roboto-Regular",
                "Roboto-Regular",
                "Arial"
        );

        for (String font : getSystemFonts()) {
            for (String name : fonts) {
                if (font.toLowerCase().contains(name.toLowerCase())) {
                    defaultFont = font;
                    return font;
                }
            }
        }

        return null;
    }

    public List<String> forceGetSystemFonts() {
        List<String> result = new ArrayList<>();

        for (String path : getSystemFontsPaths()) {
            File file = new File(path);

            if (file.exists() && file.isDirectory()) {
                File[] files = file.listFiles();
                if (files == null) continue;

                for (File font : files) {
                    if (font.getName().endsWith(".ttf") || font.getName().endsWith(".otf"))
                        result.add(font.getAbsolutePath());
                }
            }
        }

        return result;
    }

}
