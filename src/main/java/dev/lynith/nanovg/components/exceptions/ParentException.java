package dev.lynith.nanovg.components.exceptions;

public class ParentException extends Exception {

    public ParentException() {
        super("Component already has a parent");
    }

}
