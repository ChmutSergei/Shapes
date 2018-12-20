package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.warehouse.MeasurementData;
import by.chmut.shapes.warehouse.Warehouse;

public class SquareBetweenMinMax implements Specification<Shape>{

    private double min;
    private double max;

    public SquareBetweenMinMax(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean specify(Shape shape) {
        Warehouse warehouse = Warehouse.getInstance();
        MeasurementData data = warehouse.getMeasurements(shape.getId());
        double square = data.getSquare();
        return square >= min & square <= max;
    }
}
