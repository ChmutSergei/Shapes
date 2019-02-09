package by.chmut.shapes.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Warehouse instance;
    private Map<Long, MeasurementData> parameters;

    private Warehouse() {
        parameters = new HashMap<>();
    }

    public MeasurementData getMeasurements(long id) {
        return parameters.get(id);
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public MeasurementData put(Long key, MeasurementData value) {
        return parameters.put(key, value);
    }
}
