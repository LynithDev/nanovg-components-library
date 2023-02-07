package dev.lynith.nanovg.components.ui;

import dev.lynith.nanovg.components.Font;
import dev.lynith.nanovg.components.NVGManager;
import dev.lynith.nanovg.components.utils.Color;
import dev.lynith.nanovg.components.utils.GLUtils;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.opengl.GL11;

import java.nio.IntBuffer;

import static org.lwjgl.nanovg.NanoVG.*;

public class NVGHelper {

    public static int getScreenWidth() {
        IntBuffer x = BufferUtils.createIntBuffer(1);
        GLFW.glfwGetWindowSize(GLUtils.windowHandle, x, null);
        return x.get(0);
    }

    public static int getScreenHeight() {
        IntBuffer y = BufferUtils.createIntBuffer(1);
        GLFW.glfwGetWindowSize(GLUtils.windowHandle, null, y);
        return y.get(0);
    }

    public static void createFrame(int width, int height) {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        nvgBeginFrame(NVGManager.getNvg(), width, height, 1);
    }

    public static void createFrame() {
        createFrame(getScreenWidth(), getScreenHeight());
    }

    public static void endFrame() {
        nvgEndFrame(NVGManager.getNvg());
        GL11.glPopAttrib();
    }

    public static NVGColor createColor(Color color) {
        NVGColor nvgColor = NVGColor.create();
        float r = color.getRed() > 1 ? color.getRed() / 255 : color.getRed();
        float g = color.getGreen() > 1 ? color.getGreen() / 255 : color.getGreen();
        float b = color.getBlue() > 1 ? color.getBlue() / 255 : color.getBlue();
        float a = color.getAlpha() > 1 ? color.getAlpha() / 255 : color.getAlpha();
        nvgRGBAf(r,g,b,a, nvgColor);
        return nvgColor;
    }

    public static void drawRect(float left, float top, float width, float height, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgFillColor(NVGManager.getNvg(), createColor(color));
        nvgRect(NVGManager.getNvg(), left, top, width, height);
        nvgFill(NVGManager.getNvg());
    }

    public static void drawRectOutline(float left, float top, float width, float height, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgStrokeWidth(NVGManager.getNvg(), 1);
        nvgStrokeColor(NVGManager.getNvg(), createColor(color));
        nvgRect(NVGManager.getNvg(), left, top, width, height);
        nvgStroke(NVGManager.getNvg());
    }

    public static void drawRectOutline(float left, float top, float width, float height, float strokeWidth, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgStrokeWidth(NVGManager.getNvg(), strokeWidth);
        nvgStrokeColor(NVGManager.getNvg(), createColor(color));
        nvgRect(NVGManager.getNvg(), left, top, width, height);
        nvgStroke(NVGManager.getNvg());
    }

    public static void drawRectRound(float left, float top, float width, float height, float radius, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgFillColor(NVGManager.getNvg(), createColor(color));
        nvgRoundedRect(NVGManager.getNvg(), left, top, width, height, radius);
        nvgFill(NVGManager.getNvg());
    }

    public static void drawRectRoundOutline(float left, float top, float width, float height, float radius, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgStrokeWidth(NVGManager.getNvg(), 1);
        nvgStrokeColor(NVGManager.getNvg(), createColor(color));
        nvgRoundedRect(NVGManager.getNvg(), left, top, width, height, radius);
        nvgStroke(NVGManager.getNvg());
    }

    public static void drawRectRoundOutline(float left, float top, float width, float height, float radius, float strokeWidth, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgStrokeWidth(NVGManager.getNvg(), strokeWidth);
        nvgStrokeColor(NVGManager.getNvg(), createColor(color));
        nvgRoundedRect(NVGManager.getNvg(), left, top, width, height, radius);
        nvgStroke(NVGManager.getNvg());
    }

    public static void drawText(String text, float x, float y, float fontSize, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgFillColor(NVGManager.getNvg(), createColor(color));
        NVGManager.getRegularFont().renderString(NVGManager.getNvg(), text, x, y, fontSize);
        nvgFill(NVGManager.getNvg());
    }

    public static void drawTextCentered(String text, float x, float y, float fontSize, Color color) {
        float textWidth = NVGManager.getRegularFont().getWidth(NVGManager.getNvg(), text);
        drawText(text, x - (textWidth / 2), y, fontSize, color);
    }

    public static void drawText(Font font, String text, float x, float y, float fontSize, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgFillColor(NVGManager.getNvg(), createColor(color));
        font.renderString(NVGManager.getNvg(), text, x, y, fontSize);
        nvgFill(NVGManager.getNvg());
    }

    public static void drawTextCentered(Font font, String text, float x, float y, float fontSize, Color color) {
        float textWidth = font.getWidth(NVGManager.getNvg(), text);
        drawText(font, text, x - (textWidth / 2), y, fontSize, color);
    }

    public static void drawArc(float x, float y, float radius, float start, float end, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgStrokeWidth(NVGManager.getNvg(), 1);
        nvgStrokeColor(NVGManager.getNvg(), createColor(color));
        nvgArc(NVGManager.getNvg(), x, y, radius, start, end, NVG_CW);
        nvgStroke(NVGManager.getNvg());
    }

    public static void drawArcFill(float x, float y, float radius, float start, float end, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgFillColor(NVGManager.getNvg(), createColor(color));
        nvgArc(NVGManager.getNvg(), x, y, radius, start, end, NVG_CW);
        nvgFill(NVGManager.getNvg());
    }

    public static void drawLine(float x1, float y1, float x2, float y2, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgStrokeWidth(NVGManager.getNvg(), 1);
        nvgStrokeColor(NVGManager.getNvg(), createColor(color));
        nvgMoveTo(NVGManager.getNvg(), x1, y1);
        nvgLineTo(NVGManager.getNvg(), x2, y2);
        nvgStroke(NVGManager.getNvg());
    }

    public static void drawLine(float x1, float y1, float x2, float y2, float width, Color color) {
        nvgBeginPath(NVGManager.getNvg());
        nvgStrokeWidth(NVGManager.getNvg(), width);
        nvgStrokeColor(NVGManager.getNvg(), createColor(color));
        nvgMoveTo(NVGManager.getNvg(), x1, y1);
        nvgLineTo(NVGManager.getNvg(), x2, y2);
        nvgStroke(NVGManager.getNvg());
    }

}
