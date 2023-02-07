# NanoVG Components Library
This is a collection of components and a fully fledged component system to be used with the [LWJGL 3](https://github.com/LWJGL/lwjgl3) NanoVG library.

## Components
- [x] Button
- [x] Label
- [ ] Checkbox
- [ ] Radio Button
- [ ] Slider
- [ ] Progress Bar
- [ ] Text Field
- [ ] Text Area
- [ ] List
- [ ] Color Picker

## Layouts
- [ ] Absolute
- [x] Stack
- [ ] Relative

## Usage
### Creating a component
```java
public class ComponentName extends Component {
    
    @Override
    public void init() {
        super.init();
        
        // Initialization code
    }
    
    @Override
    public void render(PointBounds mouseBounds) {
        super.render(mouseBounds);
        
        // Drawing code
    }
    
}
```

### Initializing the library
```java
public class Main {
    
    public void init() {
        // Your initialization code

        NVGManager.createContext(windowHandle);
        NVGManager.setupInput();
        NVGManager.displayScreen(new MainScreen());
    }

    public void render() {
        // Your rendering code

        NVGManager.render();
    }
    
}
```

### Examples
See [Demo Application](./src/test/java/dev/lynith/nanovg/components)

## License
See [LICENSE](./LICENSE)