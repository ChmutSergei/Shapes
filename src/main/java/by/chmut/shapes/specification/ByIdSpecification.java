package by.chmut.shapes.specification;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.entity.Shape;

public class ByIdSpecification implements Specification<Shape> {

    private long id;

    public ByIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Shape shape) {
        Service service = ServiceFactory.getInstance().getService(shape);
        return this.id == service.getId(shape);
    }
}
