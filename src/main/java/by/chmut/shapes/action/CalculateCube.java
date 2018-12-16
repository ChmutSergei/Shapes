package by.chmut.shapes.action;


import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;

public class CalculateCube {

    public static double getSquare(Cube cube) {
        Point[] points = cube.getPoints();
        double cubeSide = cubeSide(points[0], points[1]);
        return cubeSide * cubeSide * 6;
    }

    public static double getVolume(Cube cube) {
        Point[] points = cube.getPoints();
        double cubeSide = cubeSide(points[0], points[1]);
        return Math.pow(cubeSide, 3);
    }

    public static double getRatioWithCartesianPlane(Cube cube) {
        Point[] points = cube.getPoints();
        double ratio = 0;
        for (int i = 0; i < 3; i++) {
            double[] coordinates1 = points[i].getCoordinates();
            for (int j = i + 1; j < 4; j++) {
                double[] coordinates2 = points[j].getCoordinates();
                double half1 = coordinates1[i];
                double half2 = coordinates2[i];
                if (( half1 - half2) != 0) {
                    if (Math.abs(half1) > Math.abs(half2)) {
                        return Math.abs(half2 / half1);
                    }
                    return Math.abs(half1 / half2);
                }
            }
        }
        return ratio;
    }

    private static double cubeSide(Point point1, Point point2) {
        double x = (point1.getX() - point2.getX());
        double y = (point1.getY() - point2.getY());
        double z = (point1.getZ() - point2.getZ());
        return Math.sqrt(x * x + y * y + z * z);
    }


}
