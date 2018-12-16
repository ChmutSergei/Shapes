package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Point;
import by.chmut.shapes.entity.Shape;

public class ExistInFirstOctant implements Specification<Shape> {

    @Override
    public boolean specify(Shape shape) {
        Point[] points = shape.getPoints();
        for (Point point : points) {
            if (point.getX() < 0 || point.getY() < 0 || point.getZ() < 0) {
                return false;
            }
        }
        return true;
    }
}
