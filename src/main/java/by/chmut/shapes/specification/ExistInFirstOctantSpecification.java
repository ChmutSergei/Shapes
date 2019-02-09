package by.chmut.shapes.specification;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.entity.Point;
import by.chmut.shapes.entity.Shape;

public class ExistInFirstOctantSpecification implements Specification<Shape> {

    @Override
    public boolean specify(Shape shape) {
        Service service = ServiceFactory.getInstance().getService(shape);
        Point[] points = service.getPoints(shape);
        for (Point point : points) {
            if (point.getX() < 0 || point.getY() < 0 || point.getZ() < 0) {
                return false;
            }
        }
        return true;
    }
}
