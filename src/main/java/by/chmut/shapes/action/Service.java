package by.chmut.shapes.action;

import by.chmut.shapes.entity.Point;
import by.chmut.shapes.entity.Shape;

public interface Service<T extends Shape> {

    double calculateSquare(T t);
    double calculateVolume(T t);
    double calculateRatioWithCartesianPlane(T t);
    boolean isOnCartesianPlane(T t);
    boolean isShape(T t, String type);
    long getId(T t);
    Point[] getPoints(T t);

}
