package dev.lynith.nanovg.components;

public class DemoMain {

    public DemoMain(long windowHandle) {
        NVGManager.createContext(windowHandle);
        NVGManager.setupInput();
        NVGManager.displayScreen(new MainScreen());
    }

    public void render() {
        NVGManager.renderCurrentScreen();
    }

}
