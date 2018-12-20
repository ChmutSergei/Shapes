package by.chmut.shapes.validation;


import by.chmut.shapes.entity.Point;

public class Validator {

    private static final int[][] POINTS_CHECK_ORDER = {{0, 1, 2, 3}, {4, 5, 6, 7}, {0, 1, 4, 5}, {1, 2, 5, 6}};

    public static boolean isCorrectCube(Point[] points) {
        if (points.length != 8) {
            return false;
        }
        return checkSides(points) && validatePlanes(points);
    }

    private static boolean checkSides(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (cubeSide(points[i], points[i + 1]) == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean validatePlanes(Point[] points) {
        for (int[] pointIndex : POINTS_CHECK_ORDER) {
            Point point1 = points[pointIndex[0]];
            Point point2 = points[pointIndex[1]];
            Point point3 = points[pointIndex[2]];
            Point point4 = points[pointIndex[3]];
            if (!formPlane(point1, point2, point3, point4)) {
                return false;
            }
        }
        return true;
    }

    private static double cubeSide(Point point1, Point point2) {
        double x = (point1.getX() - point2.getX());
        double y = (point1.getY() - point2.getY());
        double z = (point1.getZ() - point2.getZ());
        return Math.sqrt(x * x + y * y + z * z);
    }

    private static boolean formPlane(Point point1, Point point2, Point point3, Point point4) {
        double[] coordinates1 = point1.getCoordinates();
        double[] coordinates2 = point2.getCoordinates();
        double[] coordinates3 = point3.getCoordinates();
        double[] coordinates4 = point4.getCoordinates();
        for (int i = 0; i < 3; i++) {
            if ((coordinates1[i] == coordinates2[i])&(coordinates2[i] == coordinates3[i])&
                    (coordinates3[i] == coordinates4[i])&(coordinates1[i] == coordinates4[i])) {
                return true;
            }
        }
        return false;
    }

}
