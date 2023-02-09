package dev.lynith.nanovg.components;

import dev.lynith.nanovg.components.ui.NVGHelper;
import dev.lynith.nanovg.components.ui.ScreenComponent;
import dev.lynith.nanovg.components.utils.GLUtils;
import dev.lynith.nanovg.components.utils.PointBounds;
import lombok.Getter;
import lombok.Setter;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.nanovg.NanoVGGL3;

public class NVGManager {

//    @Getter @Setter
//    private static AbstractTheme theme;

    @Getter
    private static long nvg;

    @Getter @Setter
    private static ScreenComponent currentScreen;

    public static void displayScreen(ScreenComponent screen) {
        setCurrentScreen(screen);
        screen.init();
    }

    public static void renderCurrentScreen() {
        if (getCurrentScreen() != null) {
            NVGHelper.createFrame();
            getCurrentScreen().render(GLUtils.getMouseBounds());
            NVGHelper.endFrame();
        }
    }

    public static void setupCallbacks() {
        GLFW.glfwSetWindowSizeCallback(GLUtils.windowHandle, (window, width, height) -> {
            if (getCurrentScreen() != null)
                getCurrentScreen().onResize(width, height);
        });

        GLFW.glfwSetMouseButtonCallback(GLUtils.windowHandle, (window, button, action, mods) -> {
            PointBounds mouse = GLUtils.getMouseBounds();
            if (button == GLFW.GLFW_MOUSE_BUTTON_LEFT && action == GLFW.GLFW_PRESS) {
                getCurrentScreen().onClick(mouse, button);
            }

            if (button == GLFW.GLFW_MOUSE_BUTTON_LEFT && action == GLFW.GLFW_RELEASE) {
                getCurrentScreen().onRelease(mouse, button);
            }
        });

        GLFW.glfwSetCharModsCallback(GLUtils.windowHandle, (window, codepoint, mods) -> {
            onKeyTyped(codepoint);
        });

        GLFW.glfwSetKeyCallback(GLUtils.windowHandle, (window, key, scancode, action, mods) -> {
            if (action == GLFW.GLFW_PRESS && GLFW.glfwGetKeyName(key, scancode) == null && key != GLFW.GLFW_KEY_SPACE) {
                onKeyTyped(key);
            }
        });
    }

    public static void createContext(long windowHandle) {
        try {
            nvg = NanoVGGL3.nvgCreate(NanoVGGL3.NVG_ANTIALIAS | NanoVGGL3.NVG_STENCIL_STROKES);
            if (nvg == 0)
                throw new RuntimeException("Could not init NanoVG context");

            NanoVG.nvgShapeAntiAlias(nvg, true);
            GLUtils.windowHandle = windowHandle;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void onKeyTyped(int keyCode) {
        if (getCurrentScreen() != null) {
            char key = convertKey(keyCode);
            getCurrentScreen().onKeyTyped(key, keyCode);
        }
    }

    private static char convertKey(int keyCode) {
        switch (keyCode) {
            case GLFW.GLFW_KEY_ESCAPE:
                return '\u001B';
            case GLFW.GLFW_KEY_ENTER:
                return '\n';
            case GLFW.GLFW_KEY_BACKSPACE:
                return '\b';
            case GLFW.GLFW_KEY_TAB:
                return '\t';
        }
        return Character.toChars(keyCode)[0];
    }

}
