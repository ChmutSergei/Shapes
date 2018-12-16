package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Shape;

public class ByName implements Specification<Shape>{

    private String name;

    public ByName(String name) {
        this.name = name;
    }

    @Override
    public boolean specify(Shape shape) {
        return name.equals(shape.getName());
    }
}
