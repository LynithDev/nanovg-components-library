package dev.lynith.nanovg.components.utils;

import dev.lynith.nanovg.components.NVGManager;
import lombok.Getter;
import lombok.Setter;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;

import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

public class GLUtils {

    public static long windowHandle;

    public static BoxBounds getWindowBounds() {
        IntBuffer left = BufferUtils.createIntBuffer(1);
        IntBuffer top = BufferUtils.createIntBuffer(1);
        IntBuffer width = BufferUtils.createIntBuffer(1);
        IntBuffer height = BufferUtils.createIntBuffer(1);

        GLFW.glfwGetWindowPos(windowHandle, left, top);
        GLFW.glfwGetWindowSize(windowHandle, width, height);

        return new BoxBounds(left.get(), top.get(), width.get(), height.get());
    }

    public static PointBounds getMouseBounds() {
        PointBounds mouse = getSystemMousePosition();
        BoxBounds window = getWindowBounds();

        return new PointBounds(Math.max(0, Math.min(mouse.getX(), window.getWidth())), Math.max(0, Math.min(mouse.getY(), window.getHeight())));
    }

    public static PointBounds getSystemMousePosition() {
        DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
        DoubleBuffer y = BufferUtils.createDoubleBuffer(1);

        GLFW.glfwGetCursorPos(windowHandle, x, y);

        return new PointBounds((float) x.get(0), (float) y.get(0));
    }

}
