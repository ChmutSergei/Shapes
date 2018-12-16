package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Shape;

public class ById implements Specification<Shape> {

    private long id;

    public ById(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Shape shape) {
        return this.id == shape.getId();
    }
}
