package by.chmut.shapes.action;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;

public class CubeService implements Service<Cube> {

    @Override
    public double calculateSquare(Cube cube) {
        Point[] points = cube.getPoints();
        double cubeSide = cubeSide(points[0], points[1]);
        return cubeSide * cubeSide * 6;
    }

    @Override
    public double calculateVolume(Cube cube) {
        Point[] points = cube.getPoints();
        double cubeSide = cubeSide(points[0], points[1]);
        return Math.pow(cubeSide, 3);
    }

    @Override
    public double calculateRatioWithCartesianPlane(Cube cube) {
        Point[] points = cube.getPoints();
        double ratio = 0;
        for (int i = 0; i < 3; i++) {
            double[] coordinates1 = points[i].getCoordinates();
            for (int j = i + 1; j < 4; j++) {
                double[] coordinates2 = points[j].getCoordinates();
                double half1 = coordinates1[i];
                double half2 = coordinates2[i];
                if ((half1 - half2) != 0) {
                    if (Math.abs(half1) > Math.abs(half2)) {
                        return Math.abs(half2 / half1);
                    }
                    return Math.abs(half1 / half2);
                }
            }
        }
        return ratio;
    }

    @Override
    public boolean isOnCartesianPlane(Cube cube) {
        boolean result = false;
        Point[] points = cube.getPoints();
        double[] pointA = points[0].getCoordinates();
        double[] pointC1 = points[6].getCoordinates();
        for (int i = 0; i < 3; i++) {
            if (pointA[i] == 0 || pointC1[i] == 0) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean isShape(Cube cube, String type) {
        return cube.getClass().getSimpleName().equalsIgnoreCase(type);
    }

    @Override
    public long getId(Cube cube) {
        return cube.getId();
    }

    @Override
    public Point[] getPoints(Cube cube) {
        return cube.getPoints();
    }

    private static double cubeSide(Point point1, Point point2) {
        double x = (point1.getX() - point2.getX());
        double y = (point1.getY() - point2.getY());
        double z = (point1.getZ() - point2.getZ());
        return Math.hypot(Math.hypot(x, y), z);
    }
}
