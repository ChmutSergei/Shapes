package by.chmut.shapes.action;


import by.chmut.shapes.entity.Cube;

public class CubeService implements Service<Cube> {

    @Override
    public double getSquare(Cube cube) {
        return CalculateCube.getSquare(cube);
    }

    @Override
    public double getVolume(Cube cube) {
        return CalculateCube.getVolume(cube);
    }

    @Override
    public double getRatioWithCartesianPlane(Cube cube) {
        return CalculateCube.getRatioWithCartesianPlane(cube);
    }

    @Override
    public boolean isOnCartesianPlane(Cube cube) {
        return CheckCube.isOnCartesianPlane(cube);
    }

    @Override
    public boolean isShape(Cube cube, String type) {
        return cube.getName().equalsIgnoreCase(type);
    }
}
