package by.chmut.shapes.specification;

import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.observer.MeasurementData;
import by.chmut.shapes.observer.Warehouse;

public class VolumeBetweenMinMax implements Specification<Shape> {

    private double min;
    private double max;

    public VolumeBetweenMinMax(double min, double max) {
        this.min = min;
        this.max = max;
    }


    @Override
    public boolean specify(Shape shape) {
        Warehouse warehouse = Warehouse.getInstance();
        MeasurementData data = warehouse.getParameters().get(shape.getId());
        double volume = data.getVolume();
        return volume >= min & volume <= max;
    }
}
