package by.chmut.shapes.creator;

import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.exception.DataException;

public interface ShapeCreator<T extends Shape> {

    T create(double[] numbers) throws DataException;
}
