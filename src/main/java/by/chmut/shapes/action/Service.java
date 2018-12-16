package by.chmut.shapes.action;

import by.chmut.shapes.entity.Shape;

public interface Service<T extends Shape> {

    double getSquare(T t);
    double getVolume(T t);
    double getRatioWithCartesianPlane(T t);
    boolean isOnCartesianPlane(T t);
    boolean isShape(T t, String type);

}
