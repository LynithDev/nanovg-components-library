package dev.lynith.nanovg.components.ui.font;

import dev.lynith.nanovg.components.NVGManager;
import lombok.Getter;
import org.lwjgl.nanovg.NanoVG;

import javax.swing.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Font {

    private final int handle;

    @Getter
    private final FontType type;

    public Font(InputStream inputStream, FontType type) throws Exception {
        this.type = type;
        this.handle = NanoVG.nvgCreateFontMem(NVGManager.getNvg(), "", loadResource(inputStream), 0);
    }

    private void bind(long ctx) {
        NanoVG.nvgFontFaceId(ctx, handle);
    }

    private ByteBuffer loadResource(InputStream stream) throws Exception {
        if (stream == null)
            throw new Exception("Resource not found");

        byte[] buffer = new byte[stream.available()];
        stream.read(buffer);
        ByteBuffer data = ByteBuffer.allocateDirect(buffer.length).put(buffer);
        data.flip();
        return data;
    }

    public float getWidth(long ctx, String string) {
        bind(ctx);
        float[] bounds = new float[4];
        NanoVG.nvgTextBounds(ctx, 0, 0, string, bounds);
        return bounds[2];
    }

    public float getHeight(long ctx, float size) {
        bind(ctx);
        float[] ascender = new float[1];
        float[] descender = new float[1];
        float[] lineh = new float[1];
        NanoVG.nvgFontSize(ctx, size);
        NanoVG.nvgTextMetrics(ctx, ascender, descender, lineh);
        return lineh[0];
    }

    public void renderString(long ctx, String text, float x, float y, float size) {
        bind(ctx);
        NanoVG.nvgFontSize(ctx, size);
        NanoVG.nvgText(ctx, x, y + getHeight(ctx, size), text);
    }

    public void renderCenteredString(long ctx, String text, float x, float y, float size) {
        bind(ctx);
        NanoVG.nvgFontSize(ctx, size);
        NanoVG.nvgText(ctx, x - getWidth(ctx, text) / 2, y + getHeight(ctx, size) / 2, text);
    }

}
