package by.chmut.shapes.creator;

import by.chmut.shapes.entity.Cube;
import by.chmut.shapes.entity.Point;
import by.chmut.shapes.exception.DataException;
import by.chmut.shapes.repository.Repository;
import by.chmut.shapes.repository.ShapeRepository;
import by.chmut.shapes.validation.Validator;

import java.util.Arrays;

public class CubeCreator implements ShapeCreator<Cube> {

    private static final int COUNT_NUMBERS = 24;
    private static final int COUNT_POINTS = 8;

    private static final Repository repository = ShapeRepository.getInstance();

    @Override
    public Cube create(double[] numbers) throws DataException {
        if (numbers.length != COUNT_NUMBERS) {
            throw new DataException("Incorrect data - not possible to create a cube " + Arrays.toString(numbers));
        }
        Point[] points = new Point[COUNT_POINTS];
        for (int i = 0; i < COUNT_POINTS; i++) {
            points[i] = new Point(numbers[i*3], numbers[i*3+1], numbers[i*3+2]);
        }
        if (!Validator.isCorrectCube(points)) {
            throw new DataException("Incorrect points - not possible to create a cube " + Arrays.toString(points));
        }
        Cube cube = new Cube();
        cube.setPoints(points);
        repository.add(cube);
        return cube;
    }
}
