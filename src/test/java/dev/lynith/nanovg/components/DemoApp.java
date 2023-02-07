package dev.lynith.nanovg.components;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class DemoApp {

    private long window;

    private DemoMain main;

    public void run() {
        System.out.println("LWJGL " + Version.getVersion());

        init();
        loop();

        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public int width = 860;
    public int height = 480;

    private IntBuffer pWidth;
    private IntBuffer pHeight;

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwDefaultWindowHints(); 
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); 
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(width, height, "NanoVG Components App", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); 
        });

        try ( MemoryStack stack = stackPush() ) {
            pWidth = stack.mallocInt(1);
            pHeight = stack.mallocInt(1);
            
            glfwGetWindowSize(window, pWidth, pHeight);

            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } 

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);

        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // Initialize our app
        main = new DemoMain(window);
    }

    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            glfwSwapBuffers(window);
            glfwPollEvents();
            glfwGetWindowSize(window, pWidth, pHeight);

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glViewport(0, 0, pWidth.get(0), pHeight.get(0));

            // Hook into render
            main.render();
        }
    }

    public static void main(String[] args) {
        new DemoApp().run();
    }

}
