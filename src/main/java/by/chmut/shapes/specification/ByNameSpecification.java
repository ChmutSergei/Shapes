package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Shape;

public class ByNameSpecification implements Specification<Shape>{

    private String name;

    public ByNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean specify(Shape shape) {
        return name.equals(shape.getClass().getSimpleName());
    }
}
