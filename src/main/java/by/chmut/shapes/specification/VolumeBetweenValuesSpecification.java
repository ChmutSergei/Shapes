package by.chmut.shapes.specification;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.warehouse.MeasurementData;
import by.chmut.shapes.warehouse.Warehouse;

public class VolumeBetweenValuesSpecification implements Specification<Shape> {

    private double min;
    private double max;

    public VolumeBetweenValuesSpecification(double min, double max) {
        this.min = min;
        this.max = max;
    }


    @Override
    public boolean specify(Shape shape) {
        Warehouse warehouse = Warehouse.getInstance();
        Service service = ServiceFactory.getInstance().getService(shape);
        MeasurementData data = warehouse.getMeasurements(service.getId(shape));
        double volume = data.getVolume();
        return volume >= min & volume <= max;
    }
}
