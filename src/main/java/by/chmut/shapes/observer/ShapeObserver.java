package by.chmut.shapes.observer;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.entity.Shape;
import by.chmut.shapes.warehouse.MeasurementData;
import by.chmut.shapes.warehouse.Warehouse;

public class ShapeObserver implements Observer{

    @Override
    public void handleEvent(ShapeEvent event) {
        Shape shape = event.getSource();
        ServiceFactory factory = ServiceFactory.getInstance();
        Service<Shape> service = factory.getService(shape);
        double square = service.calculateSquare(shape);
        double volume = service.calculateVolume(shape);
        long id = service.getId(shape);
        MeasurementData data = new MeasurementData();
        data.setSquare(square);
        data.setVolume(volume);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id,data);
    }
}
