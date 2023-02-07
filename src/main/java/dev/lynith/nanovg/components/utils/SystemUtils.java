package dev.lynith.nanovg.components.utils;

import dev.lynith.nanovg.components.NVGManager;
import dev.lynith.nanovg.components.ui.NVGHelper;
import lombok.Getter;
import lombok.Setter;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.IntBuffer;

public class SystemUtils {

    public static OS getOS() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            return OS.WINDOWS;
        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            return OS.MACOS;
        } else if (System.getProperty("os.name").toLowerCase().contains("nix") || System.getProperty("os.name").toLowerCase().contains("nux") || System.getProperty("os.name").toLowerCase().contains("aix")) {
            return OS.LINUX;
        }

        return OS.UNKNOWN;
    }

    public enum OS {
        WINDOWS("Windows"),
        LINUX("Linux"),
        MACOS("Mac OS"),
        UNKNOWN("Unknown");

        @Getter
        private final String name;

        OS(String name) {
            this.name = name;
        }
    }

}
