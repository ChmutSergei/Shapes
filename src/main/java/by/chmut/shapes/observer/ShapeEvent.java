package by.chmut.shapes.observer;

import by.chmut.shapes.entity.Shape;

import java.util.EventObject;

public class ShapeEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ShapeEvent(Object source) {
        super(source);
    }

    @Override

    public Shape getSource() {
        return (Shape)super.getSource();
    }

}
