package by.chmut.shapes.action;


import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;
import by.chmut.shapes.validation.Validator;

public class CheckCube {

    public static boolean isOnCartesianPlane(Cube cube) {
        Point[] points = cube.getPoints();
        double[] pointA = points[0].getCoordinates();
        double[] pointC1 = points[6].getCoordinates();
        for (int i = 0; i < 3; i++) {
            if (pointA[i] == 0 || pointC1[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isShape(Cube cube) {
        return Validator.isCube(cube.getPoints());
    }
}
