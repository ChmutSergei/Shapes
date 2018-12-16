package by.chmut.shapes.observer;

import by.chmut.shapes.action.Service;
import by.chmut.shapes.action.ServiceFactory;
import by.chmut.shapes.entity.Shape;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Observer{

    private static Warehouse instance;
    private static Map<Long, MeasurementData> parameters;

    private Warehouse() {
        parameters = new HashMap<>();
    }

    public Map<Long, MeasurementData> getParameters() {
        return Collections.unmodifiableMap(parameters);
    }

    public static synchronized Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    @Override
    public void handleEvent(ShapeEvent event) {
        Shape shape = event.getSource();
        ServiceFactory factory = ServiceFactory.getInstance();
        Service<Shape> service = factory.getService(shape);
        double square = service.getSquare(shape);
        double volume = service.getVolume(shape);
        MeasurementData data = new MeasurementData();
        data.setSquare(square);
        data.setVolume(volume);
        long id = shape.getId();
        parameters.put(id, data);
    }
}
